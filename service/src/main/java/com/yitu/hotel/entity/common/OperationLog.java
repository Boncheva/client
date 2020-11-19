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
@ApiModel("操作日志表")
@TableName("operation_log")
public class OperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录表主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * IP
     */
    @TableField("ip")
    private String ip;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 操作类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 请求uri
     */
    @TableField("req_api")
    private String reqApi;

    /**
     * 请求参数
     */
    @TableField("req_params")
    private String reqParams;

    /**
     * 请求时间
     */
    @TableField("date")
    private LocalDateTime date;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    @TableField("name")
    private String name;

}
