package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitu.hotel.mapper.ConfigMapper;
import com.yitu.hotel.mapper.HotelMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.Hotel;
import com.yitu.hotel.service.HotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private ConfigMapper configMapper;

    /**
     * 获取区域列表
     *
     * @return
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
     * @return
     */
    @Override
    public List<String> streetList(String district) {
        List<String> streetList = hotelMapper.selectListGroupByStreet(district);
        return streetList;
    }

    /**
     * 根据查询条件获取酒店列表
     *
     * @param hotel
     * @return
     */
    @Override
    public PageInfo<Hotel> hotelInfoList(Hotel hotel) {
        PageHelper.startPage(hotel.getPageNum(), hotel.getPageSize());
        List<Hotel> list = hotelMapper.hotelInfoList(hotel);
        PageInfo<Hotel> pageInfo = new PageInfo<Hotel>(list);
        return pageInfo;
    }

    /**
     * 新增酒店信息
     *
     * @param hotel
     * @return
     * @throws Exception
     */
    @Override
    public JsonResult insertHotel(Hotel hotel) throws Exception {
        //判断酒店名称和别名是否已经存在
        JsonResult jsonResult = verifyThatTheHotelNameOrAliasExists(hotel);
        if (jsonResult.getStatus() == 500) {
            return JsonResult.fail(jsonResult.getMsg());
        }
        try {
            hotel.setHouse1Count(0);
            hotel.setHouse1ShowCount(0);
            hotel.setHouse1ControlCount(0);
            hotel.setHouse2Count(0);
            hotel.setHouse2ShowCount(0);
            hotel.setHouse2ControlCount(0);
            hotel.setHouse3Count(0);
            hotel.setHouse3ShowCount(0);
            hotel.setHouse3ControlCount(0);
            hotel.setHouse4Count(0);
            hotel.setHouse4ShowCount(0);
            hotel.setHouse4ControlCount(0);
            hotel.setHouse5Count(0);
            hotel.setHouse5ShowCount(0);
            hotel.setHouse5ControlCount(0);
            hotel.setHouse6Count(0);
            hotel.setHouse6ShowCount(0);
            hotel.setHouse6ControlCount(0);
            hotelMapper.insert(hotel);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return JsonResult.ok();
    }

    /**
     * 根据酒店信息id修改酒店信息
     *
     * @param hotel
     * @return
     */
    @Override
    public JsonResult updateHotel(Hotel hotel) throws Exception {
        JsonResult jsonResult = verifyThatTheHotelNameOrAliasExists(hotel);
        if (jsonResult.getStatus() == 500) {
            return JsonResult.fail(jsonResult.getMsg());
        }
        try {
            hotelMapper.updateById(hotel);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return JsonResult.ok();
    }

    /**
     * 根据酒店id删除酒店信息
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult deleteHotel(String id) throws Exception {
        try {
            hotelMapper.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return JsonResult.ok();
    }

    /**
     * 根据酒店id分配房源
     *
     * @param hotel
     * @return
     * @throws Exception
     */
    @Override
    public JsonResult allocationOfHousing(Hotel hotel) throws Exception {
        Hotel hotel1 = hotelMapper.selectById(hotel.getId());
        if (hotel.getHouse1TotalCount() != null) {
            Integer house1Add = hotel.getHouse1TotalCount();
            if (hotel1.getHouse1TotalCount() == null) {
                hotel1.setHouse1TotalCount(0);
            }
            if (hotel1.getHouse1ShowCount() == null) {
                hotel1.setHouse1ShowCount(0);
            }
            hotel.setHouse1TotalCount(hotel1.getHouse1TotalCount() + house1Add);
            hotel.setHouse1ShowCount(hotel1.getHouse1ShowCount() + house1Add);
        }
        if (hotel.getHouse2TotalCount() != null) {
            Integer house2Add = hotel.getHouse2TotalCount();
            if (hotel1.getHouse2TotalCount() == null) {
                hotel1.setHouse2TotalCount(0);
            }
            if (hotel1.getHouse2ShowCount() == null) {
                hotel1.setHouse2ShowCount(0);
            }
            hotel.setHouse2TotalCount(hotel1.getHouse2TotalCount() + house2Add);
            hotel.setHouse2ShowCount(hotel1.getHouse2ShowCount() + house2Add);
        }
        if (hotel.getHouse3TotalCount() != null) {
            Integer house3Add = hotel.getHouse3TotalCount();
            if (hotel1.getHouse3TotalCount() == null) {
                hotel1.setHouse3TotalCount(0);
            }
            if (hotel1.getHouse3ShowCount() == null) {
                hotel1.setHouse3ShowCount(0);
            }
            hotel.setHouse3TotalCount(hotel1.getHouse3TotalCount() + house3Add);
            hotel.setHouse3ShowCount(hotel1.getHouse3ShowCount() + house3Add);
        }
        if (hotel.getHouse4TotalCount() != null) {
            Integer house4Add = hotel.getHouse4TotalCount();
            if (hotel1.getHouse4TotalCount() == null) {
                hotel1.setHouse4TotalCount(0);
            }
            if (hotel1.getHouse4ShowCount() == null) {
                hotel1.setHouse4ShowCount(0);
            }
            hotel.setHouse4TotalCount(hotel1.getHouse4TotalCount() + house4Add);
            hotel.setHouse4ShowCount(hotel1.getHouse4ShowCount() + house4Add);
        }
        if (hotel.getHouse5TotalCount() != null) {
            Integer house5Add = hotel.getHouse5TotalCount();
            if (hotel1.getHouse5TotalCount() == null) {
                hotel1.setHouse5TotalCount(0);
            }
            if (hotel1.getHouse5ShowCount() == null) {
                hotel1.setHouse5ShowCount(0);
            }
            hotel.setHouse5TotalCount(hotel1.getHouse5TotalCount() + house5Add);
            hotel.setHouse5ShowCount(hotel1.getHouse5ShowCount() + house5Add);
        }
        if (hotel.getHouse6TotalCount() != null) {
            Integer house6Add = hotel.getHouse6TotalCount();
            if (hotel1.getHouse6TotalCount() == null) {
                hotel1.setHouse6TotalCount(0);
            }
            if (hotel1.getHouse6ShowCount() == null) {
                hotel1.setHouse6ShowCount(0);
            }
            hotel.setHouse6TotalCount(hotel1.getHouse6TotalCount() + house6Add);
            hotel.setHouse6ShowCount(hotel1.getHouse6ShowCount() + house6Add);
        }
        try {
            hotelMapper.updateById(hotel);
        } catch (Exception e) {
            throw new Exception();
        }
        return JsonResult.ok();
    }

    /**
     * 验证酒店名称或者别名是否已经存在(新增或者修改酒店信息的时候调用)
     *
     * @param hotel
     * @return
     */
    @Override
    public JsonResult verifyThatTheHotelNameOrAliasExists(Hotel hotel) {
        QueryWrapper qw = new QueryWrapper();
        if (StringUtils.isNotBlank(hotel.getHotelName())) {
            qw.eq("hotel_name", hotel.getHotelName());
            if (StringUtils.isNotBlank(hotel.getId().toString())) {
                //如果参数中包含酒店id，则为更新判断,否则为新增判断
                qw.ne("id", hotel.getId());
            }
            List list = hotelMapper.selectList(qw);
            if (list.size() > 0) {
                return JsonResult.fail("酒店名称已存在");
            }
        }
        qw.clear();
        if (StringUtils.isNotBlank(hotel.getHotelOtherName())) {
            qw.eq("hotel_other_name", hotel.getHotelOtherName());
            if (StringUtils.isNotBlank(hotel.getId().toString())) {
                //如果参数中包含酒店id，则为更新判断,否则为新增判断
                qw.ne("id", hotel.getId());
            }
            List list = hotelMapper.selectList(qw);
            if (list.size() > 0) {
                return JsonResult.fail("酒店别名已存在");
            }
        }
        return JsonResult.ok();
    }
}
