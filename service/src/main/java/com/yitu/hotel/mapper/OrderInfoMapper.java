package com.yitu.hotel.mapper;

import com.yitu.hotel.model.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    List<OrderInfo> orderInfoList(OrderInfo orderInfo);
}
