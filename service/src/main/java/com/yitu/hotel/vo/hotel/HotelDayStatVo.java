package com.yitu.hotel.vo.hotel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("酒店每天统计")
public class HotelDayStatVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private long id;

    /**
     * 酒店id
     */
    private long hotelId;

    /**
     * 统计日期
     */
    private String statDate;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 区
     */
    private String district;

    /**
     * 街道
     */
    private String street;

    /**
     * 房型1总间数
     */
    private int house1TotalCount;

    /**
     * 房型1可预约数
     */
    private int house1ShowCount;

    /**
     * 房型1可用数
     */
    private int house1Count;

    /**
     * 房型1管控数
     */
    private int house1ControlCount;

    /**
     * 房型1价格
     */
    private String house1Price;

    /**
     * 房型1备注
     */
    private String house1Remark;

    /**
     * 房型2总间数
     */
    private int house2TotalCount;

    /**
     * 房型2可预约数
     */
    private int house2ShowCount;

    /**
     * 房型2可用数
     */
    private int house2Count;

    /**
     * 房型2管控数
     */
    private int house2ControlCount;

    /**
     * 房型2价格
     */
    private String house2Price;

    /**
     * 房型2备注
     */
    private String house2Remark;

    /**
     * 房型3总间数
     */
    private int house3TotalCount;

    /**
     * 房型3可预约数
     */
    private int house3ShowCount;

    /**
     * 房型3可用数
     */
    private int house3Count;

    /**
     * 房型3管控数
     */
    private int house3ControlCount;

    /**
     * 今日入住房数
     */
    private int occupancyToday;

    /**
     * 今日退房房数
     */
    private int checkOutToday;

    /**
     * 房型3价格
     */
    private String house3Price;

    /**
     * 房型3备注
     */
    private String house3Remark;

    /**
     * 添加时间
     */
    private String addDate;

    /**
     * 是否展示 0-展示、1-不展示
     */
    private boolean notshow;

    /**
     * 城市：1-深圳房源 2-珠海房源
     */
    private int areaType;
}
