package com.yitu.hotel.mapper;

import com.yitu.hotel.model.entity.Hotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 酒店基础表 Mapper 接口
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
public interface HotelMapper extends BaseMapper<Hotel> {

    List<String> selectListGroupBydistrict();

    List<String> selectListGroupByStreet(String district);

    List<Hotel> hotelInfoList
            (Hotel hotel);
}
