package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.hotel.HotelDto;
import com.yitu.hotel.dto.order.OrderInfoDto;
import com.yitu.hotel.enums.fromTypeCode;
import com.yitu.hotel.enums.houseTypeCode;
import com.yitu.hotel.enums.orderStatusCode;
import com.yitu.hotel.exception.CustomException;
import com.yitu.hotel.mapper.HotelMapper;
import com.yitu.hotel.mapper.OrderInfoMapper;
import com.yitu.hotel.mapper.UserMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.hotel.Hotel;
import com.yitu.hotel.entity.order.OrderInfo;
import com.yitu.hotel.entity.user.User;
import com.yitu.hotel.service.OrderService;
import com.yitu.hotel.vo.hotel.HotelVo;
import com.yitu.hotel.vo.order.OrderInfoVo;
import com.yitu.hotel.vo.user.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HotelMapper hotelMapper;

    /**
     * 获取酒店订单列表
     *
     * @param orderInfoDto
     * @return com.github.pagehelper.PageInfo<com.yitu.hotel.vo.order.OrderInfoVo>
     * @author zouhao
     * @date 2020/11/18 16:04
     */
    @Override
    public PageInfo<OrderInfoVo> orderInfoList(OrderInfoDto orderInfoDto) {
        PageHelper.startPage(orderInfoDto.getPageNum(), orderInfoDto.getPageSize());
        List<OrderInfoVo> list = orderInfoMapper.orderInfoList(orderInfoDto);
        PageInfo<OrderInfoVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 根据订单id删除订单信息
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    @Override
    public JsonResult deleteOrder(String id) {
        int i = orderInfoMapper.deleteById(id);
        if (i <= 0) {
            throw new CustomException("系统错误，删除失败");
        }
        return JsonResult.ok();
    }

    /**
     * 根据订单id集合批量删除订单
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    @Override
    public JsonResult deleteOrderList(OrderInfoDto orderInfoDto) {
        if (orderInfoDto.getIdList() != null && orderInfoDto.getIdList().size() > 0) {
            QueryWrapper qw = new QueryWrapper();
            qw.in("id", orderInfoDto.getIdList());
            int i = orderInfoMapper.delete(qw);
            if (i <= 0) {
                throw new CustomException("系统错误，批量删除失败");
            }
            return JsonResult.ok();
        } else {
            throw new CustomException("请选择要删除的订单信息");
        }
    }

    /**
     * 批量上传订单信息
     *
     * @param file
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    @Override
    @Transactional
    public JsonResult uploadOrderListInfo(List<MultipartFile> file) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dTf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        NumberFormat nf = NumberFormat.getInstance();
        XSSFWorkbook wb = null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String, String>> list = null;
        MultipartFile orderListFile = file.get(0);
        String filename = orderListFile.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID() + suffixName;
        File dest = new File(this.getClass().getClassLoader().getResource("").getPath() + "\\" + filename);
        try {
            orderListFile.transferTo(dest);
            FileInputStream is = new FileInputStream(dest);
            wb = new XSSFWorkbook(is);
        } catch (FileNotFoundException e) {
            log.error("文件不存在", e);
            throw new CustomException("文件不存在");
        } catch (IOException e) {
            log.error("系统错误，上传失败", e);
            throw new CustomException("系统错误，上传失败");
        }
        sheet = wb.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            if (StringUtils.isBlank(row.getCell(0).toString())) {
                throw new CustomException("第" + i + "行，酒店id不能为空");
            }
            double numericCellValue = 0;
            try {
                numericCellValue = row.getCell(0).getNumericCellValue();
            } catch (IllegalStateException ex) {
                throw new CustomException("第" + i + "行，酒店参数有误，必须为纯数字");
            }
            Hotel hotel = hotelMapper.selectById(Long.valueOf(nf.format(numericCellValue)));
            if (hotel == null) {
                throw new CustomException("第" + i + "行，酒店不存在");
            }
            if (hotel.getDeleted()) {
                throw new CustomException("第" + i + "行，酒店已删除");
            }
            Long hotelId = Long.valueOf(nf.format(numericCellValue));

            if (StringUtils.isBlank(row.getCell(1).toString())) {
                throw new CustomException("第" + i + "行，房间类型不能为空");
            }
            Integer in = 0;
            try {
                in = Integer.parseInt(row.getCell(1).toString());
            } catch (NumberFormatException ex) {
                throw new CustomException("第" + i + "行，房间类型有误，必须为纯数字");
            }
            String type = houseTypeCode.getType(in);
            if (type == null) {
                throw new CustomException("第" + i + "行，房间类型不存在");
            }
            Integer houseType = in;

            //用户id验证
            if (StringUtils.isBlank(row.getCell(2).toString())) {
                throw new CustomException("第" + i + "行，用户id不能为空");
            }
            long l;
            try {
                l = Long.parseLong(row.getCell(2).toString());
            } catch (NumberFormatException ex) {
                throw new CustomException("第" + i + "行，用户id必须为纯数字");
            }
            User user = userMapper.selectById(l);
            if (user == null) {
                throw new CustomException("第" + i + "行，用户不存在");
            }
            if (user.getDeleted() == 1) {
                throw new CustomException("第" + i + "行，用户已删除");
            }
            Long userId = l;

            //价格验证
            if (StringUtils.isBlank(row.getCell(3).toString())) {
                throw new CustomException("第" + i + "行，房间价格不能为空");
            }
            double v;
            try {
                v = Double.parseDouble(row.getCell(3).toString());
            } catch (NumberFormatException ex) {
                throw new CustomException("第" + i + "行，房间价格必须为数字");
            }
            String price = String.valueOf(v);

            //入住日期验证
            if (StringUtils.isBlank(row.getCell(4).toString())) {
                throw new CustomException("第" + i + "行，入住日期不能为空");
            }
            LocalDate localDate;
            try {
                localDate = LocalDate.parse(row.getCell(4).toString(), df);
            } catch (DateTimeParseException ex) {
                throw new CustomException("第" + i + "行，入住日期格式不正确");
            }
            LocalDate checkinDate = localDate;

            //状态验证
            if (StringUtils.isBlank(row.getCell(5).toString())) {
                throw new CustomException("第" + i + "行，状态不能为空");
            }
            Integer i1;
            try {
                i1 = Integer.parseInt(row.getCell(5).toString());
            } catch (NumberFormatException ex) {
                throw new CustomException("第" + i + "行，状态必须为数字");
            }
            String s = orderStatusCode.getStatus(i1);
            if (s == null) {
                throw new CustomException("第" + i + "行，状态不存在");
            }
            int status = i1;

            //房号验证
            if (StringUtils.isBlank(row.getCell(6).toString())) {
                throw new CustomException("第" + i + "行，房间号不能为空");
            }
            String roomNum = row.getCell(6).toString();
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setHotelId(hotelId);
            orderInfo.setHouseType(houseType);
            orderInfo.setStatus(status);
            orderInfo.setUserId(userId);
            orderInfo.setPrice(price);
            orderInfo.setCheckinDate(checkinDate);
            orderInfo.setRoomNum(roomNum);
            //来源为导入
            orderInfo.setFromType(2);
            orderInfo.setAddDate(LocalDateTime.now());
            orderInfo.setDeleted(0);
            int insert = orderInfoMapper.insert(orderInfo);
            if (insert <= 0) {
                throw new CustomException("插入数据失败");
            }
        }
        return JsonResult.ok();
    }

    /**
     * 根据订单id获取订单详情
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    @Override
    public JsonResult getOrderDetails(String id) {
        OrderInfo orderInfo = orderInfoMapper.selectById(id);
        Long userId = orderInfo.getUserId();
        Long hotelId = orderInfo.getHotelId();
        //根据用户id查询用户详情
        User user = userMapper.selectById(userId);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        //根据酒店id查询酒店详情
        Hotel hotel = hotelMapper.selectById(hotelId);
        HotelVo hotelVo = new HotelVo();
        BeanUtils.copyProperties(hotel, hotelVo);
        Map<String, Object> map = new HashMap<>();
        map.put("userInfo", userVo);
        map.put("hotelInfo", hotelVo);
        return JsonResult.ok(map);
    }

    /**
     * 根据订单id修改订单信息
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    @Override
    public JsonResult updateOrder(OrderInfoDto orderInfoDto) {
        LocalDate checkinDate = null;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (orderInfoDto.getId() == 0) {
            throw new CustomException("参数有误");
        }
        String houseType = houseTypeCode.getType(orderInfoDto.getHouseType());
        if (houseType == null) {
            throw new CustomException("房间类型不存在");
        }
        if (StringUtils.isBlank(orderInfoDto.getCheckinDate())) {
            throw new CustomException("入住时间不能为空");
        } else {
            try {
                checkinDate = LocalDate.parse(orderInfoDto.getCheckinDate(), dateTimeFormatter);
            } catch (DateTimeParseException ex) {
                throw new CustomException("入住时间格式有误");
            }
        }
        if (StringUtils.isBlank(orderInfoDto.getPrice())) {
            throw new CustomException("房间价格不能为空");
        } else {
            try {
                Integer.parseInt(orderInfoDto.getPrice());
            } catch (NumberFormatException ex) {
                throw new CustomException("房间价格不是数字");
            }
        }
        String status = orderStatusCode.getStatus(orderInfoDto.getStatus());
        if (status == null) {
            throw new CustomException("状态类型不存在");
        }
        if (StringUtils.isBlank(orderInfoDto.getRoomNum())) {
            throw new CustomException("入住房号不能为空");
        }
        String type = fromTypeCode.getFromType(orderInfoDto.getFromType());
        if (type == null) {
            throw new CustomException("来源不存在");
        }
        OrderInfo orderInfo = orderInfoMapper.selectById(orderInfoDto.getId());
        if (orderInfo == null || orderInfo.getDeleted() == 1) {
            throw new CustomException("该订单不存在");
        }
        orderInfo = new OrderInfo();
        orderInfo.setId(orderInfoDto.getId());
        orderInfo.setHouseType(orderInfoDto.getHouseType());
        orderInfo.setCheckinDate(checkinDate);
        orderInfo.setPrice(orderInfoDto.getPrice());
        orderInfo.setStatus(orderInfoDto.getStatus());
        orderInfo.setDeleted(orderInfoDto.getDeleted());
        orderInfo.setRoomNum(orderInfoDto.getRoomNum());
        orderInfo.setFromType(orderInfoDto.getFromType());
        orderInfo.setRemark(orderInfoDto.getRemark());
        int i = orderInfoMapper.updateById(orderInfo);
        if (i <= 0) {
            throw new CustomException("修改失败，系统错误");
        }
        return JsonResult.ok();
    }

    /**
     * 根据订单id集合，批量转移订单
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    @Override
    public JsonResult massTransfer(OrderInfoDto orderInfoDto) {
        if (orderInfoDto.getIdList() != null && orderInfoDto.getIdList().size() > 0) {
            QueryWrapper qw = new QueryWrapper();
            qw.in("id", orderInfoDto.getIdList());
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setHotelId(Long.valueOf(orderInfoDto.getHotelId()));
            orderInfoMapper.update(orderInfo, qw);
            return JsonResult.ok();
        } else {
            throw new CustomException("参数有误");
        }
    }

    /**
     * 导出订单信息，（条件和查询订单信息条件一致）
     *
     * @param orderInfoDto
     * @return java.util.List<com.yitu.hotel.vo.order.OrderInfoVo>
     * @author zouhao
     * @date 2020/11/18 16:06
     */
    @Override
    public List<OrderInfoVo> orderInfoListExcel(OrderInfoDto orderInfoDto) {
        return orderInfoMapper.orderInfoList(orderInfoDto);
    }

    /**
     * 获取酒店列表
     *
     * @param hotelDto
     * @return java.util.List<com.yitu.hotel.entity.hotel.Hotel>
     * @author zouhao
     * @date 2020/11/18 17:02
     */
    @Override
    public List<HotelVo> getHotelList(HotelDto hotelDto) {
        return hotelMapper.hotelInfoList(hotelDto);
    }
}
