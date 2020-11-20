package com.yitu.hotel.controller;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.hotel.HotelDto;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.service.HotelService;
import com.yitu.hotel.vo.hotel.HotelVo;
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

    /**
     * 获取字典数据（酒店类型，来源等等）
     *
     * @param
     * @return com.yitu.hotel.model.JsonResult<java.util.List < java.lang.String>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    @ApiOperation(value = "获取区域列表")
    @RequestMapping(value = "district/list", method = RequestMethod.GET)
    public JsonResult<List<String>> districtList() {
        List<String> districtList = hotelService.districtList();
        return JsonResult.ok(districtList);
    }

    /**
     * 根据区域获取该区域街道列表
     *
     * @param district
     * @return com.yitu.hotel.model.JsonResult<java.util.List < java.lang.String>>
     * @author zouhao
     * @date 2020/11/18 10:55
     */
    @ApiOperation(value = "获取街道街道")
    @RequestMapping(value = "street/list", method = RequestMethod.GET)
    public JsonResult<List<String>> streetList(String district) {
        List<String> streetList = hotelService.streetList(district);
        return JsonResult.ok(streetList);
    }

    /**
     * 根据查询条件获取酒店列表
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult<com.github.pagehelper.PageInfo < com.yitu.hotel.entity.hotel.Hotel>>
     * @author zouhao
     * @date 2020/11/18 10:56
     */
    @ApiOperation(value = "获取酒店列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JsonResult<PageInfo<HotelVo>> hotelInfoList(HotelDto hotelDto) {
        return hotelService.hotelInfoList(hotelDto);
    }

    /**
     * 新增酒店信息
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:56
     */
    @ApiOperation(value = "新增酒店")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public JsonResult insertHotel(HotelDto hotelDto) {
        try {
            return hotelService.insertHotel(hotelDto);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 根据酒店信息id修改酒店信息
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:59
     */
    @ApiOperation(value = "修改酒店")
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public JsonResult updateHotel(HotelDto hotelDto) {
        try {
            return hotelService.updateHotel(hotelDto);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 根据酒店id删除酒店信息
     *
     * @param id
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    @ApiOperation(value = "删除酒店")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public JsonResult deleteHotel(String id) {
        try {
            return hotelService.deleteHotel(id);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 根据酒店id分配房源
     *
     * @param hotelDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:00
     */
    @RequestMapping(value = "house/allocation", method = RequestMethod.POST)
    public JsonResult allocationOfHousing(HotelDto hotelDto) {
        try {
            return hotelService.allocationOfHousing(hotelDto);
        } catch (Exception e) {
            return JsonResult.fail(null);
        }
    }

}
