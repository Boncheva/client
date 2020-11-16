package com.yitu.hotel.service;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.OrderInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrderService {
    PageInfo<OrderInfo> orderInfoList(OrderInfo orderInfo);

    JsonResult deleteOrder(String id);

    JsonResult deleteOrderList(OrderInfo orderInfo);

    JsonResult uploadOrderListInfo(List<MultipartFile> file)throws RuntimeException;

    JsonResult getOrderDetails(String id);

    JsonResult updateOrder(OrderInfo orderInfo);

    JsonResult massTransfer(OrderInfo orderInfo);

    List<OrderInfo> orderInfoListExcel(OrderInfo orderInfo);
}
