package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public Boolean getAreaType() {
        return areaType;
    }

    public void setAreaType(Boolean areaType) {
        this.areaType = areaType;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
            "id=" + id +
            ", mobile=" + mobile +
            ", passwd=" + passwd +
            ", userName=" + userName +
            ", roleType=" + roleType +
            ", addDate=" + addDate +
            ", modifyDate=" + modifyDate +
            ", loginDate=" + loginDate +
            ", deleted=" + deleted +
            ", areaType=" + areaType +
        "}";
    }
}
