package com.yitu.hotel.vo.common;


import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("操作日志")
public class OperationLogVo {

    private static final long serialVersionUID = 1L;

    /**
     * 记录表主键id
     */
    private long id;

    /**
     * IP
     */
    private String ip;

    /**
     * 用户id
     */
    private long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 操作类型
     */
    private int type;

    /**
     * 请求uri
     */
    private String reqApi;

    /**
     * 请求参数
     */
    private String reqParams;

    /**
     * 请求时间
     */
    private String date;

    /**
     * 备注
     */
    private String remark;

    private String name;
}
