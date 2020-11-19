package com.yitu.hotel.service;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.hotel.HotelDto;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.vo.hotel.HotelVo;

import java.util.List;

public interface HotelService {

    /**
     * 获取字典数据（酒店类型，来源等等）
     *
     * @param
     * @return com.yitu.hotel.model.JsonResult<java.util.List < java.lang.String>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    List<String> districtList();

    /**
     * 根据区域获取该区域街道列表
     *
     * @param district
     * @return com.yitu.hotel.model.JsonResult<java.util.List < java.lang.String>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    List<String> streetList(String district);

    /**
     * 根据查询条件获取酒店列表
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult<com.github.pagehelper.PageInfo < com.yitu.hotel.entity.hotel.Hotel>>
     * @author zouhao
     * @date 2020/11/18 10:56
     */
    JsonResult<PageInfo<HotelVo>> hotelInfoList(HotelDto hotelDto);

    /**
     * 新增酒店信息
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:56
     */
    JsonResult insertHotel(HotelDto hotelDto) throws Exception;

    /**
     * 根据酒店信息id修改酒店信息
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:59
     */
    JsonResult updateHotel(HotelDto hotelDto) throws Exception;

    /**
     * 根据酒店id删除酒店信息
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    JsonResult deleteHotel(String id) throws Exception;

    /**
     * 根据酒店id分配房源
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    JsonResult allocationOfHousing(HotelDto hotelDto) throws Exception;

    /**
     * 验证酒店名称或者别名是否已经存在(新增或者修改酒店信息的时候调用)
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    JsonResult verifyThatTheHotelNameOrAliasExists(HotelDto hotelDto);
}
