package com.yitu.hotel.dto.adminUser;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.lang.String;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel(value = "系统用户列表")
public class AdminUserDto {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private long id;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户密码
     */
    private String passwd;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 角色类型：0公安、1卫健委、2社区、3管理员、9超级管理员
     */
    private int roleType;

    /**
     * 添加时间
     */
    private String addDate;

    /**
     * 更新时间
     */
    private String modifyDate;

    /**
     * 最后登录时间
     */
    private String loginDate;

    /**
     * 是否删除: 0-未删除、1-已删除
     */
    private int deleted;

    /**
     * 城市：1深圳、2珠海
     */
    private boolean areaType;
}
