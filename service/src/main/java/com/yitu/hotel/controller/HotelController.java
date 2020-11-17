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

    /**
     * 获取区域列表
     *
     * @return
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
     * @return
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
     * @param hotel
     * @return
     */
    @ApiOperation(value = "获取酒店列表")
    @RequestMapping(value = "info/list", method = RequestMethod.POST)
    public JsonResult<PageInfo<Hotel>> hotelInfoList(Hotel hotel) {
        PageInfo<Hotel> hotelInfoList = hotelService.hotelInfoList(hotel);
        return JsonResult.ok(hotelInfoList);
    }

    /**
     * 新增酒店信息
     *
     * @param hotel
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "新增酒店")
    @RequestMapping(value = "info/add", method = RequestMethod.POST)
    public JsonResult insertHotel(Hotel hotel) {
        try {
            return hotelService.insertHotel(hotel);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 根据酒店信息id修改酒店信息
     *
     * @param hotel
     * @return
     */
    @ApiOperation(value = "修改酒店")
    @RequestMapping(value = "info/update", method = RequestMethod.POST)
    public JsonResult updateHotel(Hotel hotel) {
        try {
            return hotelService.updateHotel(hotel);
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 根据酒店id删除酒店信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除酒店")
    @RequestMapping(value = "info/delete", method = RequestMethod.GET)
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
     * @param hotel
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "house/allocation", method = RequestMethod.POST)
    public JsonResult allocationOfHousing(Hotel hotel) {
        try {
            return hotelService.allocationOfHousing(hotel);
        } catch (Exception e) {
            return JsonResult.fail(null);
        }
    }

    /**
     * 验证酒店名称或者别名是否已经存在(新增或者修改酒店信息的时候调用)
     *
     * @param hotel
     * @return
     */
    @RequestMapping(value = "verify/hotel", method = RequestMethod.POST)
    public JsonResult verifyThatTheHotelNameOrAliasExists(Hotel hotel) {
        return hotelService.verifyThatTheHotelNameOrAliasExists(hotel);
    }

}
