package com.yitu.hotel.entity.hotel;

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
@ApiModel("酒店调控日志表")
@TableName("hotel_control_log")
public class HotelControlLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private long hotelId;

    /**
     * 酒店名称
     */
    @TableField("hotel_name")
    private String hotelName;

    /**
     * 详细地址
     */
    @TableField("address")
    private String address;

    /**
     * 区
     */
    @TableField("district")
    private String district;

    /**
     * 街道
     */
    @TableField("street")
    private String street;

    /**
     * 房型1总间数
     */
    @TableField("house1_total_count")
    private int house1TotalCount;

    /**
     * 房型1可预约数
     */
    @TableField("house1_show_count")
    private int house1ShowCount;

    /**
     * 房型1可用数
     */
    @TableField("house1_count")
    private int house1Count;

    /**
     * 房型1管控数
     */
    @TableField("house1_control_count")
    private int house1ControlCount;

    /**
     * 房型1价格
     */
    @TableField("house1_price")
    private String house1Price;

    /**
     * 房型1备注
     */
    @TableField("house1_remark")
    private String house1Remark;

    /**
     * 房型2总间数
     */
    @TableField("house2_total_count")
    private int house2TotalCount;

    /**
     * 房型2可预约数
     */
    @TableField("house2_show_count")
    private int house2ShowCount;

    /**
     * 房型2可用数
     */
    @TableField("house2_count")
    private int house2Count;

    /**
     * 房型2管控数
     */
    @TableField("house2_control_count")
    private int house2ControlCount;

    /**
     * 房型2价格
     */
    @TableField("house2_price")
    private String house2Price;

    /**
     * 房型2备注
     */
    @TableField("house2_remark")
    private String house2Remark;

    /**
     * 房型3总间数
     */
    @TableField("house3_total_count")
    private int house3TotalCount;

    /**
     * 房型3可预约数
     */
    @TableField("house3_show_count")
    private int house3ShowCount;

    /**
     * 房型3可用数
     */
    @TableField("house3_count")
    private int house3Count;

    /**
     * 房型3管控数
     */
    @TableField("house3_control_count")
    private int house3ControlCount;

    /**
     * 房型3价格
     */
    @TableField("house3_price")
    private String house3Price;

    /**
     * 房型3备注
     */
    @TableField("house3_remark")
    private String house3Remark;

    /**
     * 添加时间
     */
    @TableField("operate_date")
    private LocalDateTime operateDate;

    /**
     * 添加人
     */
    @TableField("operate_user")
    private String operateUser;

    /**
     * 操作方式：0批量、1单个
     */
    @TableField("operate_type")
    private int operateType;

    /**
     * 联系人
     */
    @TableField("contract_user")
    private String contractUser;

    /**
     * 联系电话
     */
    @TableField("contract_mobile")
    private String contractMobile;

    /**
     * 城市：1-深圳房源 2-珠海房源
     */
    @TableField("area_type")
    private int areaType;

}
