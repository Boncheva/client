package com.yitu.hotel.controller;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.hotel.HotelDto;
import com.yitu.hotel.dto.order.OrderInfoDto;
import com.yitu.hotel.entity.hotel.Hotel;
import com.yitu.hotel.exception.CustomException;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.order.OrderInfo;
import com.yitu.hotel.service.OrderService;
import com.yitu.hotel.vo.hotel.HotelVo;
import com.yitu.hotel.vo.order.OrderInfoVo;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取酒店订单列表
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult<com.github.pagehelper.PageInfo < com.yitu.hotel.entity.order.OrderInfo>>
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    @ApiOperation(value = "获取酒店订单列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JsonResult<PageInfo<OrderInfoVo>> orderInfoList(OrderInfoDto orderInfoDto) {
        PageInfo<OrderInfoVo> pageInfo = orderService.orderInfoList(orderInfoDto);
        return JsonResult.ok(pageInfo);
    }

    /**
     * 根据订单id删除订单信息
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    @ApiOperation(value = "删除酒店")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public JsonResult deleteOrder(String id) {
        return orderService.deleteOrder(id);
    }

    /**
     * 根据订单id集合批量删除订单
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    @ApiOperation(value = "批量删除酒店")
    @RequestMapping(value = "deleteList", method = RequestMethod.POST)
    public JsonResult deleteOrderList(OrderInfoDto orderInfoDto) {
        return orderService.deleteOrderList(orderInfoDto);
    }


    /**
     * 获取酒店列表
     *
     * @param hotelDto
     * @return java.util.List<com.yitu.hotel.entity.hotel.Hotel>
     * @author zouhao
     * @date 2020/11/18 17:02
     */
    @ApiOperation(value = "获取酒店列表")
    @RequestMapping(value = "hotel/list", method = RequestMethod.POST)
    public List<HotelVo> getHotelList(HotelDto hotelDto) {
        return orderService.getHotelList(hotelDto);
    }

    /**
     * 导出订单信息，（条件和查询订单信息条件一致）
     *
     * @param request
     * @param response
     * @param orderInfoDto
     * @return void
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    @ApiOperation(value = "导出订单信息")
    @RequestMapping(value = "export", method = RequestMethod.GET)

    public void exportOrderListInfo(HttpServletRequest request, HttpServletResponse response, OrderInfoDto orderInfoDto) throws UnsupportedEncodingException {
        List<OrderInfoVo> orderInfoList = orderService.orderInfoListExcel(orderInfoDto);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download");

        String fileName = "预定订单.xlsx";
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("sheet1");
        sheet.setDefaultRowHeight((short) (2 * 256));//设置行高
        sheet.setColumnWidth(0, 4000);//设置列宽
        sheet.setColumnWidth(1, 5500);
        sheet.setColumnWidth(2, 5500);
        sheet.setColumnWidth(3, 5500);
        sheet.setColumnWidth(11, 3000);
        sheet.setColumnWidth(12, 3000);
        sheet.setColumnWidth(13, 3000);
        XSSFFont font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 16);

        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("姓名 ");
        cell = row.createCell(1);
        cell.setCellValue("性别 ");
        cell = row.createCell(2);
        cell.setCellValue("年龄");
        cell = row.createCell(3);
        cell.setCellValue("预定酒店");
        cell = row.createCell(4);
        cell.setCellValue("区域");
        cell = row.createCell(5);
        cell.setCellValue("房号 ");
        cell = row.createCell(6);
        cell.setCellValue("备注 ");
        cell = row.createCell(7);
        cell.setCellValue("入住日期 ");

        XSSFRow rows;
        XSSFCell cells;

        for (int i = 0; i < orderInfoList.size(); i++) {
            // 第三步：在这个sheet页里创建一行
            rows = sheet.createRow(i + 1);
            // 第四步：在该行创建一个单元格
            cells = rows.createCell(0);
            // 第五步：在该单元格里设置值
            cells.setCellValue(orderInfoList.get(i).getUserName());
            cells = rows.createCell(1);
            cells.setCellValue("0".equals(orderInfoList.get(i).getSex()) ? "男" : "女");
            cells = rows.createCell(2);
            cells.setCellValue(orderInfoList.get(i).getAge());
            cells = rows.createCell(3);
            cells.setCellValue(orderInfoList.get(i).getHotelName());
            cells = rows.createCell(4);
            cells.setCellValue(orderInfoList.get(i).getDistrict());
            cells = rows.createCell(5);
            cells.setCellValue(orderInfoList.get(i).getRoomNum());
            cells = rows.createCell(6);
            cells.setCellValue(orderInfoList.get(i).getRemark());
            cells = rows.createCell(7);
            cells.setCellValue(orderInfoList.get(i).getRealCheckinDate());
        }
        try {
            OutputStream out = response.getOutputStream();
            wb.write(out);
            out.close();
            wb.close();
        } catch (IOException e) {
            throw new CustomException("导出失败");
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
    @ApiOperation(value = "批量上传订单信息")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public JsonResult uploadOrderListInfo(List<MultipartFile> file) {
        orderService.uploadOrderListInfo(file);
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
    @ApiOperation(value = "获取订单详情")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public JsonResult getOrderDetails(String id) {
        return orderService.getOrderDetails(id);
    }

    /**
     * 根据订单id修改订单信息
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    @ApiOperation(value = "更新订单信息")
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public JsonResult updateOrder(OrderInfoDto orderInfoDto) {
        return orderService.updateOrder(orderInfoDto);
    }

    /**
     * 根据订单id集合，批量转移订单
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    @ApiOperation(value = "批量转移订单信息")
    @RequestMapping(value = "mass/transfer", method = RequestMethod.POST)
    public JsonResult massTransfer(OrderInfoDto orderInfoDto) {
        return orderService.massTransfer(orderInfoDto);
    }


}

