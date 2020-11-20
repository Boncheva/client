package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.hotel.HotelDto;
import com.yitu.hotel.enums.hotelTypeCode;
import com.yitu.hotel.exception.CustomException;
import com.yitu.hotel.mapper.HotelMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.hotel.Hotel;
import com.yitu.hotel.service.HotelService;
import com.yitu.hotel.util.DateTimeUtil;
import com.yitu.hotel.util.PatternUtil;
import com.yitu.hotel.vo.hotel.HotelVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;


    /**
     * 获取区域列表
     *
     * @param
     * @return com.yitu.hotel.model.JsonResult<java.util.List < java.lang.String>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    @Override
    public List<String> districtList() {

        List<String> districtList = hotelMapper.selectListGroupBydistrict();
        return districtList;
    }

    /**
     * 根据区域获取该区域街道列表
     *
     * @param district
     * @return com.yitu.hotel.model.JsonResult<java.util.List < java.lang.String>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    @Override
    public List<String> streetList(String district) {
        List<String> streetList = hotelMapper.selectListGroupByStreet(district);
        return streetList;
    }

    /**
     * 根据查询条件获取酒店列表
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult<com.github.pagehelper.PageInfo < com.yitu.hotel.entity.hotel.Hotel>>
     * @author zouhao
     * @date 2020/11/18 10:56
     */
    @Override
    public JsonResult<PageInfo<HotelVo>> hotelInfoList(HotelDto hotelDto) {
        PageHelper.startPage(hotelDto.getPageNum(), hotelDto.getPageSize());
        List<HotelVo> list = hotelMapper.hotelInfoList(hotelDto);
        PageInfo<HotelVo> pageInfo = new PageInfo<>(list);
        return JsonResult.ok(pageInfo);
    }

    /**
     * 新增酒店信息
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:56
     */
    @Override
    public JsonResult insertHotel(HotelDto hotelDto) {
        LocalDate controlDate = null;
        LocalDate reserveDate = null;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (StringUtils.isBlank(hotelDto.getHotelName())) {
            throw new CustomException("酒店名称不能为空");
        }
        //酒店名称是否重复校验
        verifyIfTheHotelNameIsDuplicate(hotelDto);

        if (StringUtils.isBlank(hotelDto.getHotelOtherName())) {
            throw new CustomException("酒店别名不能为空");
        }
        //酒店别名是否重复校验
        verifyThatTheHotelAliasExists(hotelDto);

        //酒店类型校验
        if (StringUtils.isBlank(hotelDto.getHotelTypes())) {
            throw new CustomException("酒店类型不能为空");
        }
        String[] split = hotelDto.getHotelTypes().split(",");
        for (int i = 0; i < split.length; i++) {
            if (hotelTypeCode.getType(split[i]) == null) {
                throw new CustomException("酒店类型中包含系统不存在的的类型");
            }
        }
        if (StringUtils.isBlank(hotelDto.getAddress())) {
            throw new CustomException("酒店详细地址不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getContractUser())) {
            throw new CustomException("酒店联系人不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getContractMobile())) {
            throw new CustomException("酒店联系电话不能为空");
        }
        boolean isMatch = PatternUtil.matches(hotelDto.getContractMobile());
        if (!isMatch) {
            throw new CustomException("手机格式不正确");
        }

        if (StringUtils.isBlank(hotelDto.getDistrict())) {
            throw new CustomException("区域不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getStreet())) {
            throw new CustomException("街道不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getHotelUsername())) {
            throw new CustomException("酒店管理账号不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getHotelPassword())) {
            throw new CustomException("酒店管理密码不能为空");
        }
        if (hotelDto.getHotelPassword().length() < 8) {
            throw new CustomException("酒店管理密码长度不能少于8位");
        }

        if (StringUtils.isBlank(hotelDto.getControlDate())) {
            throw new CustomException("酒店管控日期不能为空");
        }
        try {
            controlDate = DateTimeUtil.parseLocalDate(hotelDto.getControlDate(), dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            throw new CustomException("酒店管控时间格式有误");

        }
        if (StringUtils.isBlank(hotelDto.getReserveDate())) {
            throw new CustomException("酒店预定日期不能为空");
        }
        try {
            reserveDate = DateTimeUtil.parseLocalDate(hotelDto.getReserveDate(), dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            throw new CustomException("酒店预定日期格式不正确");
        }

        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDto, hotel);
        hotel.setControlDate(controlDate);
        hotel.setReserveDate(reserveDate);
        hotel.setAddDate(LocalDateTime.now());
        int result = hotelMapper.insert(hotel);
        if (result <= 0) {
            throw new CustomException("新增失败");
        }
        return JsonResult.ok();
    }

    /**
     * 根据酒店信息id修改酒店信息
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:59
     */
    @Override
    public JsonResult updateHotel(HotelDto hotelDto) throws Exception {
        if (hotelDto.getId() <= 0) {
            throw new CustomException("参数有误");
        }
        Hotel hotel = hotelMapper.selectById(hotelDto.getId());
        if (hotel == null) {
            throw new CustomException("该酒店不存在");
        }
        if (hotel.getDeleted() == 1) {
            throw new CustomException("该酒店已被删除");
        }
        if (StringUtils.isBlank(hotelDto.getHotelName())) {
            throw new CustomException("酒店名称不能为空");
        }
        verifyIfTheHotelNameIsDuplicate(hotelDto);

        if (StringUtils.isBlank(hotelDto.getHotelOtherName())) {
            throw new CustomException("酒店别名不能为空");
        }
        verifyThatTheHotelAliasExists(hotelDto);

        if (StringUtils.isBlank(hotelDto.getHotelTypes())) {
            throw new CustomException("酒店类型不能为空");
        }
        String[] split = hotelDto.getHotelTypes().split(",");
        for (int i = 0; i < split.length; i++) {
            if (hotelTypeCode.getType(split[i]) == null) {
                throw new CustomException("酒店类型中包含系统不存在的的类型");
            }
        }
        if (StringUtils.isBlank(hotelDto.getAddress())) {
            throw new CustomException("酒店详细地址不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getContractUser())) {
            throw new CustomException("酒店联系人不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getContractMobile())) {
            throw new CustomException("酒店联系电话不能为空");
        }
        boolean isMatch = PatternUtil.matches(hotelDto.getContractMobile());
        if (!isMatch) {
            throw new CustomException("手机格式不正确");
        }

        if (hotelDto.getNotshow() != 0 && hotelDto.getNotshow() != 1) {
            throw new CustomException("是否展示参数有误");
        }

        if (StringUtils.isBlank(hotelDto.getDistrict())) {
            throw new CustomException("区域不能为空");
        }
        if (StringUtils.isBlank(hotelDto.getStreet())) {
            throw new CustomException("街道不能为空");
        }
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setHotelOtherName(hotelDto.getHotelOtherName());
        hotel.setHotelTypes(hotelDto.getHotelTypes());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setContractUser(hotelDto.getContractUser());
        hotel.setContractMobile(hotelDto.getContractMobile());
        hotel.setDistrict(hotelDto.getDistrict());
        hotel.setStreet(hotelDto.getStreet());
        hotel.setRemark(hotelDto.getRemark());
        hotel.setNotshow(hotelDto.getNotshow() == 0 ? 0 : 1);
        int result = hotelMapper.updateById(hotel);
        if (result <= 0) {
            throw new CustomException("修改失败");
        }
        return JsonResult.ok();
    }

    /**
     * 根据酒店id删除酒店信息
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    @Override
    public JsonResult deleteHotel(String id) {
        int result = hotelMapper.deleteById(id);
        if (result <= 0) {
            throw new CustomException("删除失败");
        }
        return JsonResult.ok();
    }

    /**
     * 根据酒店id分配房源
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    @Override
    public JsonResult allocationOfHousing(HotelDto hotelDto) throws Exception {
        if (hotelDto.getId() <= 0) {
            throw new CustomException("参数有误");
        }
        Hotel hotel = hotelMapper.selectById(hotelDto.getId());
        if (hotel == null) {
            throw new CustomException("该酒店不存在");
        }
        if (hotel.getDeleted() == 1) {
            throw new CustomException("该酒店已被删除");
        }
        hotel.setHouse1TotalCount(hotel.getHouse1TotalCount() + hotelDto.getHouse1TotalCount());
        hotel.setHouse1ShowCount(hotel.getHouse1ShowCount() + hotelDto.getHouse1TotalCount());

        hotel.setHouse2TotalCount(hotel.getHouse2TotalCount() + hotelDto.getHouse2TotalCount());
        hotel.setHouse2ShowCount(hotel.getHouse2ShowCount() + hotelDto.getHouse2TotalCount());

        hotel.setHouse3TotalCount(hotel.getHouse3TotalCount() + hotelDto.getHouse3TotalCount());
        hotel.setHouse3ShowCount(hotel.getHouse3ShowCount() + hotelDto.getHouse3TotalCount());

        hotel.setHouse4TotalCount(hotel.getHouse4TotalCount() + hotelDto.getHouse4TotalCount());
        hotel.setHouse4ShowCount(hotel.getHouse4ShowCount() + hotelDto.getHouse4TotalCount());

        hotel.setHouse5TotalCount(hotel.getHouse5TotalCount() + hotelDto.getHouse5TotalCount());
        hotel.setHouse5ShowCount(hotel.getHouse5ShowCount() + hotelDto.getHouse5TotalCount());

        hotel.setHouse6TotalCount(hotel.getHouse6TotalCount() + hotelDto.getHouse6TotalCount());
        hotel.setHouse6ShowCount(hotel.getHouse6ShowCount() + hotelDto.getHouse6TotalCount());

        int result = hotelMapper.updateById(hotel);
        if (result <= 0) {
            throw new CustomException("分配房源失败");
        }
        return JsonResult.ok();
    }

    /**
     * 验证酒店名称是否已经存在(新增或者修改酒店信息的时候调用)
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    public void verifyIfTheHotelNameIsDuplicate(HotelDto hotelDto) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("hotel_name", hotelDto.getHotelName());
        //更新判断
        if (hotelDto.getId() > 0) {
            qw.ne("id", hotelDto.getId());
        }
        List list = hotelMapper.selectList(qw);
        if (list.size() > 0) {
            throw new CustomException("酒店名称已存在");
        }
    }

    /**
     * 验证酒店别名是否已经存在(新增或者修改酒店信息的时候调用)
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    public void verifyThatTheHotelAliasExists(HotelDto hotelDto) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("hotel_other_name", hotelDto.getHotelOtherName());
        //更新判断
        if (hotelDto.getId() > 0) {
            qw.ne("id", hotelDto.getId());
        }
        List list = hotelMapper.selectList(qw);
        if (list.size() > 0) {
            throw new CustomException("酒店别名已存在");
        }
    }

}
