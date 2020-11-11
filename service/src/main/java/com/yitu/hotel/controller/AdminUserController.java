package com.yitu.hotel.controller;

import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.AdminUser;
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

    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResult login(AdminUser adminUser, HttpServletRequest request) {
        return adminUserService.login(adminUser, request);
    }

    @ApiOperation(value = "用户退出")
    @RequestMapping(value = "signOut", method = RequestMethod.POST)
    public JsonResult signOut(AdminUser adminUser, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return adminUserService.signOut(token);
    }

}
