package com.yitu.hotel.mapper;

import com.yitu.hotel.dto.order.OrderInfoDto;
import com.yitu.hotel.entity.order.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yitu.hotel.vo.order.OrderInfoVo;

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

    /**
     * 获取酒店订单列表
     *
     * @param orderInfoDto
     * @return com.github.pagehelper.PageInfo<com.yitu.hotel.vo.order.OrderInfoVo>
     * @author zouhao
     * @date 2020/11/18 16:04
     */
    List<OrderInfoVo> orderInfoList(OrderInfoDto orderInfoDto);
}
