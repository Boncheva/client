package com.yitu.hotel.vo.hotel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel(value = "酒店信息")
public class HotelVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private long id;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 别名
     */
    private String hotelOtherName;

    /**
     * 酒店类型id（多种以,进行分隔）
     */
    private String hotelTypes;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contractUser;

    /**
     * 联系电话
     */
    private String contractMobile;

    /**
     * 区
     */
    private String district;

    /**
     * 街道
     */
    private String street;

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加时间
     */
    private String addDate;


    /**
     * 是否删除: 0-未删除、1-已删除
     */
    private boolean deleted;

    /**
     * 是否展示 0-展示、1-不展示
     */
    private boolean notshow;

    /**
     * 酒店登陆账号
     */
    private String hotelUsername;

    /**
     * 酒店登陆密码
     */
    private String hotelPassword;

    /**
     * 管控时间
     */
    private String controlDate;

    /**
     * 可预约日期
     */
    private String reserveDate;

    /**
     * 区政府是否上报
     */
    private int isReport;

    /**
     * 1-深圳房源 2-珠海房源 3-其他城市
     */
    private int areaType;

    /**
     * 今日预定数
     */
    private int todayOrderCount;

    /**
     * 今日入住数
     */
    private int todayCheckInCount;

    /**
     * 今日退房数
     */
    private int todayCheckOutCount;

    /**
     * 今日剩余数
     */
    private int todayRemindCount;

}
