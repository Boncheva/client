package com.yitu.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitu.hotel.mapper.HotelMapper;
import com.yitu.hotel.mapper.OrderInfoMapper;
import com.yitu.hotel.mapper.UserMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.Hotel;
import com.yitu.hotel.model.entity.OrderInfo;
import com.yitu.hotel.model.entity.User;
import com.yitu.hotel.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public PageInfo<OrderInfo> orderInfoList(OrderInfo orderInfo) {
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfo> list = orderInfoMapper.orderInfoList(orderInfo);
        PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(list);
        return pageInfo;
    }

    @Override
    public JsonResult deleteOrder(String id) {
        try {
            orderInfoMapper.deleteById(id);
        } catch (RuntimeException e) {
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult deleteOrderList(OrderInfo orderInfo) {
        QueryWrapper qw = new QueryWrapper();
        qw.in("id", orderInfo.getIdList());
        try {
            orderInfoMapper.delete(qw);
        } catch (RuntimeException e) {
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }

    @Override
    @Transactional
    public JsonResult uploadOrderListInfo(List<MultipartFile> file) throws RuntimeException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dTf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        NumberFormat nf = NumberFormat.getInstance();
        XSSFWorkbook wb = null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String, String>> list = null;
        String cellData = null;
        MultipartFile orderListFile = file.get(0);
        String filename = orderListFile.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID() + suffixName;
        File dest = new File("C:\\Users\\1\\Documents\\upload\\" + filename);
        try {
            orderListFile.transferTo(dest);
            FileInputStream is = new FileInputStream(dest);
            wb = new XSSFWorkbook(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        List<OrderInfo> orderInfoList = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            try {
                Long hotelId = Long.valueOf(nf.format(row.getCell(0).getNumericCellValue()).replace(",", ""));
                Integer houseType = Integer.parseInt(nf.format(row.getCell(1).getNumericCellValue()).replace(",", ""));
                Long userId = Long.valueOf(nf.format(row.getCell(2).getNumericCellValue()).replace(",", ""));
                Integer userType = Integer.valueOf(nf.format(row.getCell(3).getNumericCellValue()).replace(",", ""));
                String price = String.valueOf(row.getCell(4));
                LocalDate checkinDate = null;
                LocalDateTime addDate = null;
                LocalDateTime realCheckinDate = null;
                LocalDateTime cancelDate = null;
                LocalDateTime modifyDate = null;
                LocalDateTime operateDate = null;
                LocalDateTime checkoutDate = null;
                LocalDateTime checkDate = null;
                if (StringUtils.isNotBlank(row.getCell(5).toString())) {
                    checkinDate = LocalDate.parse(String.valueOf(row.getCell(5)), df);
                }
                if (StringUtils.isNotBlank(row.getCell(7).toString())) {
                    addDate = LocalDateTime.parse(String.valueOf(row.getCell(7)), dTf);
                }
                if (StringUtils.isNotBlank(row.getCell(8).toString())) {
                    realCheckinDate = LocalDateTime.parse(String.valueOf(row.getCell(8)), dTf);
                }
                if (StringUtils.isNotBlank(row.getCell(9).toString())) {
                    cancelDate = LocalDateTime.parse(String.valueOf(row.getCell(9)), dTf);
                }
                if (StringUtils.isNotBlank(row.getCell(10).toString())) {
                    modifyDate = LocalDateTime.parse(String.valueOf(row.getCell(10)), dTf);
                }
                if (StringUtils.isNotBlank(row.getCell(13).toString())) {
                    operateDate = LocalDateTime.parse(String.valueOf(row.getCell(13)), dTf);
                }
                if (StringUtils.isNotBlank(row.getCell(14).toString())) {
                    checkoutDate = LocalDateTime.parse(String.valueOf(row.getCell(14)), dTf);
                }
                if (StringUtils.isNotBlank(row.getCell(17).toString())) {
                    checkDate = LocalDateTime.parse(String.valueOf(row.getCell(17)), dTf);
                }
                Integer status = Integer.valueOf(nf.format(row.getCell(6).getNumericCellValue()).replace(",", ""));
                Integer deleted = Integer.valueOf(String.valueOf(row.getCell(11)));
                String operateUser = String.valueOf(row.getCell(12));
                String roomNum = String.valueOf(row.getCell(15));
                String remark = String.valueOf(row.getCell(16));
                String checkUser = String.valueOf(row.getCell(18));
                String checkReason = String.valueOf(row.getCell(19));
                Integer fromType = Integer.valueOf(String.valueOf(row.getCell(20)));
                String oriRemark = String.valueOf(row.getCell(21));
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setId(new Date().getTime());
                orderInfo.setHotelId(hotelId);
                orderInfo.setHouseType(houseType);
                orderInfo.setUserId(userId);
                orderInfo.setUserType(userType);
                orderInfo.setPrice(price);
//                orderInfo.setCheckinDate(checkinDate);
                orderInfo.setAddDate(addDate);
                orderInfo.setRealCheckinDate(realCheckinDate);
                orderInfo.setCancelDate(cancelDate);
                orderInfo.setModifyDate(modifyDate);
                orderInfo.setOperateDate(operateDate);
                orderInfo.setCheckDate(checkDate);
                orderInfo.setCheckoutDate(checkoutDate);
                orderInfo.setStatus(status);
                orderInfo.setDeleted(deleted);
                orderInfo.setOperateUser(operateUser);
                orderInfo.setRoomNum(roomNum);
                orderInfo.setRemark(remark);
                orderInfo.setCheckUser(checkUser);
                orderInfo.setCheckReason(checkReason);
                orderInfo.setFromType(fromType);
                orderInfo.setOriRemark(oriRemark);
                orderInfoMapper.insert(orderInfo);
            } catch (RuntimeException e) {
                throw new RuntimeException("导入失败");
            }
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult getOrderDetails(String id) {
        OrderInfo orderInfo = orderInfoMapper.selectById(id);
        Long userId = orderInfo.getUserId();
        Long hotelId = orderInfo.getHotelId();
        User user = userMapper.selectById(userId);
        Hotel hotel = hotelMapper.selectById(hotelId);
        Map<String, Object> map = new HashMap<>();
        map.put("userInfo", user);
        map.put("hotelInfo", hotel);
        return JsonResult.ok(map);
    }

    @Override
    public JsonResult updateOrder(OrderInfo orderInfo) {
        try {
            orderInfoMapper.updateById(orderInfo);
        } catch (Exception e) {
            return JsonResult.fail(null);
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult massTransfer(OrderInfo orderInfo) {
        QueryWrapper qw = new QueryWrapper();
        qw.in("id", orderInfo.getIdList());
        try {
            orderInfoMapper.update(orderInfo, qw);
        } catch (Exception e) {
            return JsonResult.fail(null);
        }
        return JsonResult.ok();
    }

    @Override
    public List<OrderInfo> orderInfoListExcel(OrderInfo orderInfo) {
        return orderInfoMapper.orderInfoList(orderInfo);
    }
}
