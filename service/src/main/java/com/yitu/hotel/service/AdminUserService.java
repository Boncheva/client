package com.yitu.hotel.service;

import com.yitu.hotel.dto.adminUser.AdminUserDto;
import com.yitu.hotel.model.JsonResult;

import javax.servlet.http.HttpServletRequest;

public interface AdminUserService {
    /**
     * 用户登录
     *
     * @param adminUserDto
     * @param request
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 10:54
     */
    JsonResult login(AdminUserDto adminUserDto, HttpServletRequest request);

    /**
     * 用户退出
     * @param token
     * @return com.yitu.hotel.model.JsonResult
     * @author zouhao
     * @date 2020/11/18 18:50
     */
    JsonResult signOut(String token);
}
