package com.yitu.hotel.vo.hotel;


import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("酒店调控日志")
public class HotelGovLogVo {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 酒店id
     */
    private long hotelId;

    /**
     * 酒店对应区划分
     */
    private String district;

    /**
     * 统计上报日期
     */
    private String logDate;

    /**
     * 房型1管控数
     */
    private int house1ControlCount;

    /**
     * 房型2管控数
     */
    private int house2ControlCount;

    /**
     * 房型3管控数
     */
    private int house3ControlCount;

    /**
     * 0 - 未上报， 1 - 保存， 2 - 已上报（不可修改）
     */
    private boolean govStatus;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改政府用户id
     */
    private int updateUserId;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 房型4管控数
     */
    private int house4ControlCount;

    /**
     * 房型5管控数
     */
    private int house5ControlCount;

    /**
     * 房型6管控数
     */
    private int house6ControlCount;
}
