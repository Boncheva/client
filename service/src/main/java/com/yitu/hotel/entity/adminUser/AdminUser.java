package com.yitu.hotel.entity.adminUser;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("用户信息")
@TableName("admin_user")
public class AdminUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 手机号码
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 用户密码
     */
    @TableField("passwd")
    private String passwd;

    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 角色类型：0公安、1卫健委、2社区、3管理员、9超级管理员
     */
    @TableField("role_type")
    private Integer roleType;

    /**
     * 添加时间
     */
    @TableField("add_date")
    private LocalDateTime addDate;

    /**
     * 更新时间
     */
    @TableField("modify_date")
    private LocalDateTime modifyDate;

    /**
     * 最后登录时间
     */
    @TableField("login_date")
    private LocalDateTime loginDate;

    /**
     * 是否删除: 0-未删除、1-已删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 城市：1深圳、2珠海
     */
    @TableField("area_type")
    private Boolean areaType;

}
