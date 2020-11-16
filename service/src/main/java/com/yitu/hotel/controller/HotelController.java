package com.yitu.hotel.controller;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.Hotel;
import com.yitu.hotel.service.HotelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
@CrossOrigin
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @ApiOperation(value = "获取区域列表")
    @RequestMapping(value = "district/list", method = RequestMethod.GET)
    public JsonResult<List<String>> districtList() {
        List<String> districtList = hotelService.districtList();
        return JsonResult.ok(districtList);
    }

    @ApiOperation(value = "获取街道街道")
    @RequestMapping(value = "street/list", method = RequestMethod.GET)
    public JsonResult<List<String>> streetList(String district) {
        List<String> streetList = hotelService.streetList(district);
        return JsonResult.ok(streetList);
    }

    @ApiOperation(value = "获取酒店列表")
    @RequestMapping(value = "info/list", method = RequestMethod.POST)
    public JsonResult<PageInfo<Hotel>> hotelInfoList(Hotel hotel) {
        PageInfo<Hotel> hotelInfoList = hotelService.hotelInfoList(hotel);
        return JsonResult.ok(hotelInfoList);
    }

    @ApiOperation(value = "新增酒店")
    @RequestMapping(value = "info/add", method = RequestMethod.POST)
    public JsonResult insertHotel(Hotel hotel) {
        try {
            return hotelService.insertHotel(hotel);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    @ApiOperation(value = "修改酒店")
    @RequestMapping(value = "info/update", method = RequestMethod.POST)
//    @PostMapping("info/update")
    public JsonResult updateHotel(Hotel hotel) {
        try {
            return hotelService.updateHotel(hotel);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }


    //    @GetMapping("info/delete")
    @ApiOperation(value = "删除酒店")
    @RequestMapping(value = "info/delete", method = RequestMethod.GET)
    public JsonResult deleteHotel(String id) {
        try {
            return hotelService.deleteHotel(id);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "house/allocation", method = RequestMethod.POST)
    public JsonResult allocationOfHousing(Hotel hotel) {
        try {
            return hotelService.allocationOfHousing(hotel);
        } catch (Exception e) {
            return JsonResult.fail(null);
        }
    }

}
