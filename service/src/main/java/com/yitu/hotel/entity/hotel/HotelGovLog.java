package com.yitu.hotel.entity.hotel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("政府管控，每日酒店房源信息")
@TableName("hotel_gov_log")
public class HotelGovLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private long hotelId;

    /**
     * 酒店对应区划分
     */
    @TableField("district")
    private String district;

    /**
     * 统计上报日期
     */
    @TableField("log_date")
    private LocalDate logDate;

    /**
     * 房型1管控数
     */
    @TableField("house1_control_count")
    private int house1ControlCount;

    /**
     * 房型2管控数
     */
    @TableField("house2_control_count")
    private int house2ControlCount;

    /**
     * 房型3管控数
     */
    @TableField("house3_control_count")
    private int house3ControlCount;

    /**
     * 0 - 未上报， 1 - 保存， 2 - 已上报（不可修改）
     */
    @TableField("gov_status")
    private Boolean govStatus;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改政府用户id
     */
    @TableField("update_user_id")
    private int updateUserId;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 房型4管控数
     */
    @TableField("house4_control_count")
    private int house4ControlCount;

    /**
     * 房型5管控数
     */
    @TableField("house5_control_count")
    private int house5ControlCount;

    /**
     * 房型6管控数
     */
    @TableField("house6_control_count")
    private int house6ControlCount;

}
