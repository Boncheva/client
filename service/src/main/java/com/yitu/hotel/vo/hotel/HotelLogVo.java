package com.yitu.hotel.vo.hotel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("酒店可用房源日志表")
public class HotelLogVo {

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
    private LocalDate logDate;

    /**
     * 房型1空闲数
     */
    private int house1Count;

    /**
     * 房型2空闲数
     */
    private int house2Count;

    /**
     * 房型3空闲数
     */
    private int house3Count;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否存在房源信息
     */
    private boolean isFill;

    /**
     * 今日入住房数
     */
    private int occupancyToday;

    /**
     * 今日退房房数
     */
    private int checkOutToday;

    /**
     * 明日房源信息是否填报 0:未填报 1:已填报
     */
    private boolean isHouseFill;

    /**
     * 今日入住人员信息是否填报 0:未填报 1:已填报
     */
    private boolean isPeopleFill;

    /**
     * 管控后可用房间总数
     */
    private int controlNumber;

    /**
     * 酒店添加时间
     */
    private LocalDateTime addDate;
}
