package com.yitu.hotel.controller;

import com.yitu.hotel.mapper.TokenMapper;
import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.AdminUser;
import com.yitu.hotel.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("login")
    public JsonResult login(AdminUser adminUser, HttpServletRequest request) {
        return adminUserService.login(adminUser, request);
    }

    @RequestMapping("signOut")
    public JsonResult signOut(AdminUser adminUser, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return adminUserService.signOut(token);
    }

}
