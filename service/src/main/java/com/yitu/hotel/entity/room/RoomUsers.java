package com.yitu.hotel.entity.room;

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
@ApiModel("房间用户表")
@TableName("room_users")
public class RoomUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 证件类型：1.身份证，2.港澳通行证，3.护照，4.回乡证
     */
    @TableField("cert_type")
    private int certType;

    /**
     * 证件号码
     */
    @TableField("cert_no")
    private String certNo;

    /**
     * 年龄
     */
    @TableField("age")
    private int age;

    /**
     * 是否主申请人：0否、1是
     */
    @TableField("main_request")
    private int mainRequest;

    /**
     * 类型：0登记、1订单
     */
    @TableField("type")
    private int type;

    /**
     * 主申请人用户id
     */
    @TableField("user_id")
    private long userId;

    /**
     * 订单id
     */
    @TableField("order_id")
    private long orderId;

    /**
     * 核酸检测时间
     */
    @TableField("hs_check_date")
    private LocalDateTime hsCheckDate;

    /**
     * 核酸状态：0阴性、1阳性
     */
    @TableField("hs_check_status")
    private int hsCheckStatus;

    /**
     * 核酸报告文件路径
     */
    @TableField("report_path")
    private String reportPath;

    /**
     * 核酸人工审核状态：0待审核、1审核通过、2审核不通过
     */
    @TableField("check_rg_status")
    private int checkRgStatus;

    /**
     * 核酸人工审核原因
     */
    @TableField("check_rg_reason")
    private String checkRgReason;

    /**
     * 核酸人工审核时间
     */
    @TableField("check_rg_date")
    private LocalDateTime checkRgDate;

    /**
     * 核酸人工审核人
     */
    @TableField("check_rg_user")
    private String checkRgUser;

    /**
     * 更新时间
     */
    @TableField("modify_date")
    private LocalDateTime modifyDate;

    /**
     * 公安审核状态：0待审核、1审核通过、2审核不通过
     */
    @TableField("check_status")
    private int checkStatus;

    /**
     * 公安审核原因
     */
    @TableField("check_reason")
    private String checkReason;

    /**
     * 公安审核时间
     */
    @TableField("check_date")
    private LocalDateTime checkDate;

    /**
     * 公安审核人
     */
    @TableField("check_user")
    private String checkUser;
}
