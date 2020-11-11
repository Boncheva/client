package com.yitu.hotel.service;

import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<String> districtList();

    List<String> streetList(String district);

    List<Hotel> hotelInfoList(Hotel hotel);

    JsonResult insertHotel(Hotel hotel) throws Exception;

    JsonResult updateHotel(Hotel hotel) throws Exception;

    JsonResult deleteHotel(String id) throws Exception;

    JsonResult allocationOfHousing(Hotel hotel) throws Exception;
}