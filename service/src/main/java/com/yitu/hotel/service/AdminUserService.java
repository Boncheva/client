package com.yitu.hotel.service;

import com.yitu.hotel.model.JsonResult;
import com.yitu.hotel.model.entity.AdminUser;

import javax.servlet.http.HttpServletRequest;

public interface AdminUserService {
    JsonResult login(AdminUser adminUser, HttpServletRequest request);

    JsonResult signOut(String token);
}
