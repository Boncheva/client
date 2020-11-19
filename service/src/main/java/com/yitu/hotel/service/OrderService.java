package com.yitu.hotel.service;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.hotel.HotelDto;
import com.yitu.hotel.dto.order.OrderInfoDto;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.vo.hotel.HotelVo;
import com.yitu.hotel.vo.order.OrderInfoVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrderService {

    /**
     * 获取酒店订单列表
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult<com.github.pagehelper.PageInfo < com.yitu.hotel.entity.order.OrderInfo>>
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    PageInfo<OrderInfoVo> orderInfoList(OrderInfoDto orderInfoDto);

    /**
     * 根据订单id删除订单信息
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    JsonResult deleteOrder(String id);

    /**
     * 根据订单id集合批量删除订单
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:03
     */
    JsonResult deleteOrderList(OrderInfoDto orderInfoDto);

    /**
     * 批量上传订单信息
     *
     * @param file
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    JsonResult uploadOrderListInfo(List<MultipartFile> file) throws RuntimeException;

    /**
     * 根据订单id获取订单详情
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    JsonResult getOrderDetails(String id);

    /**
     * 根据订单id修改订单信息
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    JsonResult updateOrder(OrderInfoDto orderInfoDto);

    /**
     * 根据订单id集合，批量转移订单
     *
     * @param orderInfoDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:04
     */
    JsonResult massTransfer(OrderInfoDto orderInfoDto);

    List<OrderInfoVo> orderInfoListExcel(OrderInfoDto orderInfoDto);

    /**
     * 获取酒店列表
     *
     * @param hotelDto
     * @return java.util.List<com.yitu.hotel.entity.hotel.Hotel>
     * @author zouhao
     * @date 2020/11/18 17:02
     */
    List<HotelVo> getHotelList(HotelDto hotelDto);
}
