package com.yitu.hotel.controller;

import com.github.pagehelper.PageInfo;
import com.yitu.hotel.dto.user.UserDto;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.entity.common.DgtxPlaces;
import com.yitu.hotel.service.UserInfoService;
import com.yitu.hotel.vo.user.UserVo;
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
     * @param userDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:08
     */
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JsonResult getUserInfoList(UserDto userDto) {
        PageInfo<UserVo> pageInfo = userInfoService.getUserInfoList(userDto);
        return JsonResult.ok(pageInfo);
    }

    /**
     * 根据条件获取区域列表(省市区)
     *
     * @param dgtxPlaces
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
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
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
     */
    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public JsonResult getUserInfo(String userId) {
        JsonResult<UserVo> jsonResult = userInfoService.getUserInfo(userId);
        return jsonResult;
    }

    /**
     * 根据用户id重置用户密码
     *
     * @param userDto
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
     */
    @ApiOperation(value = "重置用户密码")
    @RequestMapping(value = "resetpwd", method = RequestMethod.POST)
    public JsonResult restPwd(UserDto userDto) {
        JsonResult jsonResult = userInfoService.restPwd(userDto);
        return jsonResult;
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param userId
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 11:09
     */
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public JsonResult deleteUser(String userId) {
        return userInfoService.deleteUser(userId);
    }
}
