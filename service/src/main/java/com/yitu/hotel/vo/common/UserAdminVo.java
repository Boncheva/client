package com.yitu.hotel.vo.common;


import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("用户")
public class UserAdminVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String passwd;

    /**
     * 用户头像
     */
    private String userPic;

    /**
     * 区域信息
     */
    private String regionName;

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
    private boolean deleted;

}
