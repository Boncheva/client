package com.yitu.hotel.entity.common;

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
@ApiModel("用户表")
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

}
