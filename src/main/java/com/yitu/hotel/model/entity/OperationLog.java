package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getReqApi() {
        return reqApi;
    }

    public void setReqApi(String reqApi) {
        this.reqApi = reqApi;
    }
    public String getReqParams() {
        return reqParams;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
            "id=" + id +
            ", ip=" + ip +
            ", userId=" + userId +
            ", userName=" + userName +
            ", type=" + type +
            ", reqApi=" + reqApi +
            ", reqParams=" + reqParams +
            ", date=" + date +
            ", remark=" + remark +
            ", name=" + name +
        "}";
    }
}
