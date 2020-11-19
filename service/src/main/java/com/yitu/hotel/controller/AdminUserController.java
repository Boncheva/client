package com.yitu.hotel.controller;

import com.yitu.hotel.dto.adminUser.AdminUserDto;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.service.AdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 用户登录
     *
     * @param adminUserDto
     * @param request
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:54
     */
    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResult login(AdminUserDto adminUserDto, HttpServletRequest request) {
        return adminUserService.login(adminUserDto, request);
    }

    /**
     * 用户退出
     *
     * @param adminUserDto
     * @param request
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:54
     */
    @ApiOperation(value = "用户退出")
    @RequestMapping(value = "signOut", method = RequestMethod.POST)
    public JsonResult signOut(AdminUserDto adminUserDto, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return adminUserService.signOut(token);
    }

}
