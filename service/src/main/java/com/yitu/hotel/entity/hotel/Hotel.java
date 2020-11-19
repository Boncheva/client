package com.yitu.hotel.entity.hotel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yitu.hotel.dto.common.PageDto;
import com.yitu.hotel.entity.common.Config;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("酒店信息")
@TableName("hotel")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 酒店名称
     */
    @TableField("hotel_name")
    private String hotelName;

    /**
     * 别名
     */
    @TableField("hotel_other_name")
    private String hotelOtherName;

    /**
     * 酒店类型id（多种以,进行分隔）
     */
    @TableField("hotel_types")
    private String hotelTypes;

    /**
     * 详细地址
     */
    @TableField("address")
    private String address;

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
     * 今日入住房数
     */
    @TableField("occupancy_today")
    private int occupancyToday;

    /**
     * 今日退房房数
     */
    @TableField("check_out_today")
    private int checkOutToday;

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
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 添加时间
     */
    @TableField("add_date")
    private LocalDateTime addDate;

    /**
     * 更新时间
     */
    @TableField("modify_date")
    private LocalDateTime modifyDate;

    /**
     * 是否删除: 0-未删除、1-已删除
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 是否展示 0-展示、1-不展示
     */
    @TableField("notshow")
    private Boolean notshow;

    /**
     * 酒店登陆账号
     */
    @TableField("hotel_username")
    private String hotelUsername;

    /**
     * 酒店登陆密码
     */
    @TableField("hotel_password")
    private String hotelPassword;

    /**
     * 酒店图片url
     */
    @TableField("url")
    private String url;

    /**
     * 房源数最后同步时间
     */
    @TableField("last_synch_date")
    private LocalDateTime lastSynchDate;

    /**
     * 管控时间
     */
    @TableField("control_date")
    private LocalDate controlDate;

    /**
     * 可预约日期
     */
    @TableField("reserve_date")
    private LocalDate reserveDate;

    /**
     * 区政府是否上报
     */
    @TableField("is_report")
    private int isReport;

    /**
     * 1-深圳房源 2-珠海房源 3-其他城市
     */
    @TableField("area_type")
    private int areaType;

    /**
     * 房型4总间数
     */
    @TableField("house4_total_count")
    private int house4TotalCount;

    /**
     * 房型4可预约数
     */
    @TableField("house4_show_count")
    private int house4ShowCount;

    /**
     * 房型4可用数
     */
    @TableField("house4_count")
    private int house4Count;

    /**
     * 房型4管控数
     */
    @TableField("house4_control_count")
    private int house4ControlCount;

    /**
     * 房型4价格
     */
    @TableField("house4_price")
    private String house4Price;

    /**
     * 房型4备注
     */
    @TableField("house4_remark")
    private String house4Remark;

    /**
     * 房型5总间数
     */
    @TableField("house5_total_count")
    private int house5TotalCount;

    /**
     * 房型5可预约数
     */
    @TableField("house5_show_count")
    private int house5ShowCount;

    /**
     * 房型5可用数
     */
    @TableField("house5_count")
    private int house5Count;

    /**
     * 房型5管控数
     */
    @TableField("house5_control_count")
    private int house5ControlCount;

    /**
     * 房型5价格
     */
    @TableField("house5_price")
    private String house5Price;

    /**
     * 房型5备注
     */
    @TableField("house5_remark")
    private String house5Remark;

    /**
     * 房型6总间数
     */
    @TableField("house6_total_count")
    private int house6TotalCount;

    /**
     * 房型6可预约数
     */
    @TableField("house6_show_count")
    private int house6ShowCount;

    /**
     * 房型6可用数
     */
    @TableField("house6_count")
    private int house6Count;

    /**
     * 房型6管控数
     */
    @TableField("house6_control_count")
    private int house6ControlCount;

    /**
     * 房型6价格
     */
    @TableField("house6_price")
    private String house6Price;

    /**
     * 房型6备注
     */
    @TableField("house6_remark")
    private String house6Remark;
}
