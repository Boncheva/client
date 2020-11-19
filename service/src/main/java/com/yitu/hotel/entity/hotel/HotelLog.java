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
@ApiModel("酒店可用房源日志表")
@TableName("hotel_log")
public class HotelLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private Long hotelId;

    /**
     * 统计日期
     */
    @TableField("log_date")
    private LocalDate logDate;

    /**
     * 房型1空闲数
     */
    @TableField("house1_count")
    private Integer house1Count;

    /**
     * 房型2空闲数
     */
    @TableField("house2_count")
    private Integer house2Count;

    /**
     * 房型3空闲数
     */
    @TableField("house3_count")
    private Integer house3Count;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 是否存在房源信息
     */
    @TableField("is_fill")
    private Boolean isFill;

    /**
     * 今日入住房数
     */
    @TableField("occupancy_today")
    private Integer occupancyToday;

    /**
     * 今日退房房数
     */
    @TableField("check_out_today")
    private Integer checkOutToday;

    /**
     * 明日房源信息是否填报 0:未填报 1:已填报
     */
    @TableField("is_house_fill")
    private Boolean isHouseFill;

    /**
     * 今日入住人员信息是否填报 0:未填报 1:已填报
     */
    @TableField("is_people_fill")
    private Boolean isPeopleFill;

    /**
     * 管控后可用房间总数
     */
    @TableField("control_number")
    private Integer controlNumber;

    /**
     * 酒店添加时间
     */
    @TableField("add_date")
    private LocalDateTime addDate;

}
