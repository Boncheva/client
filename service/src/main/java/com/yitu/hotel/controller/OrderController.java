package com.yitu.hotel.controller;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.OrderInfo;
import com.yitu.hotel.service.OrderService;
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
     * @param orderInfo
     * @return
     */
    @ApiOperation(value = "获取酒店订单列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JsonResult<PageInfo<OrderInfo>> orderInfoList(OrderInfo orderInfo) {
        PageInfo<OrderInfo> pageInfo = orderService.orderInfoList(orderInfo);
        return JsonResult.ok(pageInfo);
    }

    /**
     * 根据订单id删除订单信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除酒店")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public JsonResult deleteOrder(String id) {
        return orderService.deleteOrder(id);
    }

    /**
     * 根据订单id集合批量删除订单
     *
     * @param orderInfo
     * @return
     */
    @ApiOperation(value = "批量删除酒店")
    @RequestMapping(value = "deleteList", method = RequestMethod.POST)
    public JsonResult deleteOrderList(OrderInfo orderInfo) {
        return orderService.deleteOrderList(orderInfo);
    }

    /**
     * 导出订单信息，（条件和查询订单信息条件一致）
     *
     * @param request
     * @param response
     * @param orderInfo
     * @throws UnsupportedEncodingException
     */
    @ApiOperation(value = "导出订单信息")
    @RequestMapping(value = "export", method = RequestMethod.GET)
    public void exportOrderListInfo(HttpServletRequest request, HttpServletResponse response, OrderInfo orderInfo) throws UnsupportedEncodingException {
        List<OrderInfo> orderInfoList = orderService.orderInfoListExcel(orderInfo);
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
            if ("0".equals(orderInfoList.get(i).getSex())) {
                cells.setCellValue("男");
            } else {
                cells.setCellValue("女");
            }
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 批量上传订单信息
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "批量上传订单信息")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public JsonResult uploadOrderListInfo(List<MultipartFile> file) {
        try {
            orderService.uploadOrderListInfo(file);
        } catch (RuntimeException e) {
            return JsonResult.fail("上传失败");
        }
        return JsonResult.ok();
    }

    /**
     * 根据订单id获取订单详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取订单详情")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public JsonResult getOrderDetails(String id) {
        return orderService.getOrderDetails(id);
    }

    /**
     * 根据订单id修改订单信息
     *
     * @param orderInfo
     * @return
     */
    @ApiOperation(value = "更新订单信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public JsonResult updateOrder(OrderInfo orderInfo) {
        return orderService.updateOrder(orderInfo);
    }

    /**
     * 根据订单id集合，批量转移订单
     *
     * @param orderInfo
     * @return
     */
    @ApiOperation(value = "批量转移订单信息")
    @RequestMapping(value = "mass/transfer", method = RequestMethod.POST)
    public JsonResult massTransfer(OrderInfo orderInfo) {
        return orderService.massTransfer(orderInfo);
    }


}

