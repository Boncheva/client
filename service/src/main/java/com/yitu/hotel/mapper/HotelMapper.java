package com.yitu.hotel.mapper;

import com.yitu.hotel.dto.hotel.HotelDto;
import com.yitu.hotel.entity.hotel.Hotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yitu.hotel.vo.hotel.HotelVo;

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

    /**
     * 获取区域列表
     * @param
     * @return java.util.List<java.lang.String>
     * @author zouhao
     * @date 2020/11/18 18:39
     */
    List<String> selectListGroupBydistrict();

    /**
     * 根据区域获取该区域街道列表
     * @param district
     * @return java.util.List<java.lang.String>
     * @author zouhao
     * @date 2020/11/18 18:39
     */
    List<String> selectListGroupByStreet(String district);

    /**
     * 根据查询条件获取酒店列表
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult<com.github.pagehelper.PageInfo < com.yitu.hotel.entity.hotel.Hotel>>
     * @author zouhao
     * @date 2020/11/18 10:56
     */
    List<HotelVo> hotelInfoList(HotelDto hotelDto);
}
