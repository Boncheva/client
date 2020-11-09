package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 政府管控 - 每日酒店房源信息
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("hotel_gov_log")
public class HotelGovLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private Long hotelId;

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
    private Integer house1ControlCount;

    /**
     * 房型2管控数
     */
    @TableField("house2_control_count")
    private Integer house2ControlCount;

    /**
     * 房型3管控数
     */
    @TableField("house3_control_count")
    private Integer house3ControlCount;

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
    private Integer updateUserId;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 房型4管控数
     */
    @TableField("house4_control_count")
    private Integer house4ControlCount;

    /**
     * 房型5管控数
     */
    @TableField("house5_control_count")
    private Integer house5ControlCount;

    /**
     * 房型6管控数
     */
    @TableField("house6_control_count")
    private Integer house6ControlCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
    public Integer getHouse1ControlCount() {
        return house1ControlCount;
    }

    public void setHouse1ControlCount(Integer house1ControlCount) {
        this.house1ControlCount = house1ControlCount;
    }
    public Integer getHouse2ControlCount() {
        return house2ControlCount;
    }

    public void setHouse2ControlCount(Integer house2ControlCount) {
        this.house2ControlCount = house2ControlCount;
    }
    public Integer getHouse3ControlCount() {
        return house3ControlCount;
    }

    public void setHouse3ControlCount(Integer house3ControlCount) {
        this.house3ControlCount = house3ControlCount;
    }
    public Boolean getGovStatus() {
        return govStatus;
    }

    public void setGovStatus(Boolean govStatus) {
        this.govStatus = govStatus;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getHouse4ControlCount() {
        return house4ControlCount;
    }

    public void setHouse4ControlCount(Integer house4ControlCount) {
        this.house4ControlCount = house4ControlCount;
    }
    public Integer getHouse5ControlCount() {
        return house5ControlCount;
    }

    public void setHouse5ControlCount(Integer house5ControlCount) {
        this.house5ControlCount = house5ControlCount;
    }
    public Integer getHouse6ControlCount() {
        return house6ControlCount;
    }

    public void setHouse6ControlCount(Integer house6ControlCount) {
        this.house6ControlCount = house6ControlCount;
    }

    @Override
    public String toString() {
        return "HotelGovLog{" +
            "id=" + id +
            ", hotelId=" + hotelId +
            ", district=" + district +
            ", logDate=" + logDate +
            ", house1ControlCount=" + house1ControlCount +
            ", house2ControlCount=" + house2ControlCount +
            ", house3ControlCount=" + house3ControlCount +
            ", govStatus=" + govStatus +
            ", createTime=" + createTime +
            ", updateUserId=" + updateUserId +
            ", updateTime=" + updateTime +
            ", house4ControlCount=" + house4ControlCount +
            ", house5ControlCount=" + house5ControlCount +
            ", house6ControlCount=" + house6ControlCount +
        "}";
    }
}
