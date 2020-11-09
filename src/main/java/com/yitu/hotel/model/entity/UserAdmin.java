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
@TableName("user_admin")
public class UserAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("passwd")
    private String passwd;

    /**
     * 用户头像
     */
    @TableField("user_pic")
    private String userPic;

    /**
     * 区域信息
     */
    @TableField("region_name")
    private String regionName;

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
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserAdmin{" +
            "id=" + id +
            ", userName=" + userName +
            ", passwd=" + passwd +
            ", userPic=" + userPic +
            ", regionName=" + regionName +
            ", modifyDate=" + modifyDate +
            ", loginDate=" + loginDate +
            ", deleted=" + deleted +
        "}";
    }
}
