package com.yitu.hotel.controller;

import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.DgtxPlaces;
import com.yitu.hotel.model.entity.User;
import com.yitu.hotel.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userInfo")
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    //    @PostMapping(value = "user/list")
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "user/list", method = RequestMethod.POST)
    public JsonResult getUserInfoList(User user) {
        List<User> userInfoList = userInfoService.getUserInfoList(user);
        return JsonResult.ok(userInfoList);
    }

    //    @PostMapping(value = "area/list")
    @ApiOperation(value = "获取区域列表")
    @RequestMapping(value = "area/list", method = RequestMethod.POST)
    public JsonResult getAreaList(DgtxPlaces dgtxPlaces) {
        List<DgtxPlaces> dgtxPlacesList = userInfoService.getAreaList(dgtxPlaces);
        return JsonResult.ok(dgtxPlacesList);
    }

    //    @GetMapping(value = "user/info")
    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "user/info", method = RequestMethod.GET)
    public JsonResult getUserInfo(String userId) {
        User userInfo = userInfoService.getUserInfo(userId);
        return JsonResult.ok(userInfo);
    }

    //    @PostMapping(value = "/resetpwd")
    @ApiOperation(value = "重置用户密码")
    @RequestMapping(value = "resetpwd", method = RequestMethod.POST)
    public JsonResult restPwd(User user) {
        return userInfoService.restPwd(user);
    }

    //    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public JsonResult deleteUser(String userId) {
        return userInfoService.deleteUser(userId);
    }
}
