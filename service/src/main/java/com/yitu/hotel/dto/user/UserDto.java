package com.yitu.hotel.dto.user;

import com.yitu.hotel.dto.common.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("用户")
public class UserDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 目的地省
     */
    private String province;

    /**
     * 目的地市
     */
    private String city;

    /**
     * 目的地区
     */
    private String area;

    /**
     * 核酸报告文件路径
     */
    private String reportPath;

    /**
     * 是否填报
     */
    private int fillStatus;

    /**
     * 核酸状态：0阴性、1阳性
     */
    private int hsCheckStatus;

    /**
     * 用户类型：0香港入境普通市民、1机场国际航班人员、2跨境货车司机、3港口入境船员
     */
    private int userType;

    /**
     * 核算报告是否上传 0未上传、1已上传
     */
    private String IsSubmit;

    /**
     * 身份证或者名字
     */
    private String idOrName;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 确认密码
     */
    private String verifyPasswd;
}
