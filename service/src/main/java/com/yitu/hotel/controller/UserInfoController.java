package com.yitu.hotel.controller;

import com.github.pagehelper.PageInfo;
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


    /**
     * 获取用户列表
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "user/list", method = RequestMethod.POST)
    public JsonResult getUserInfoList(User user) {
        PageInfo<User> pageInfo = userInfoService.getUserInfoList(user);
        return JsonResult.ok(pageInfo);
    }

    /**
     * 根据条件获取区域列表(省市区)
     *
     * @param dgtxPlaces
     * @return
     */
    @ApiOperation(value = "获取区域列表")
    @RequestMapping(value = "area/list", method = RequestMethod.POST)
    public JsonResult getAreaList(DgtxPlaces dgtxPlaces) {
        List<DgtxPlaces> dgtxPlacesList = userInfoService.getAreaList(dgtxPlaces);
        return JsonResult.ok(dgtxPlacesList);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "user/info", method = RequestMethod.GET)
    public JsonResult getUserInfo(String userId) {
        User userInfo = userInfoService.getUserInfo(userId);
        return JsonResult.ok(userInfo);
    }

    /**
     * 根据用户id重置用户密码
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "重置用户密码")
    @RequestMapping(value = "resetpwd", method = RequestMethod.POST)
    public JsonResult restPwd(User user) {
        return userInfoService.restPwd(user);
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public JsonResult deleteUser(String userId) {
        return userInfoService.deleteUser(userId);
    }
}
