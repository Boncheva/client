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
 * 酒店可用房源日志表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
    public Integer getHouse1Count() {
        return house1Count;
    }

    public void setHouse1Count(Integer house1Count) {
        this.house1Count = house1Count;
    }
    public Integer getHouse2Count() {
        return house2Count;
    }

    public void setHouse2Count(Integer house2Count) {
        this.house2Count = house2Count;
    }
    public Integer getHouse3Count() {
        return house3Count;
    }

    public void setHouse3Count(Integer house3Count) {
        this.house3Count = house3Count;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Boolean getFill() {
        return isFill;
    }

    public void setFill(Boolean isFill) {
        this.isFill = isFill;
    }
    public Integer getOccupancyToday() {
        return occupancyToday;
    }

    public void setOccupancyToday(Integer occupancyToday) {
        this.occupancyToday = occupancyToday;
    }
    public Integer getCheckOutToday() {
        return checkOutToday;
    }

    public void setCheckOutToday(Integer checkOutToday) {
        this.checkOutToday = checkOutToday;
    }
    public Boolean getHouseFill() {
        return isHouseFill;
    }

    public void setHouseFill(Boolean isHouseFill) {
        this.isHouseFill = isHouseFill;
    }
    public Boolean getPeopleFill() {
        return isPeopleFill;
    }

    public void setPeopleFill(Boolean isPeopleFill) {
        this.isPeopleFill = isPeopleFill;
    }
    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }
    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "HotelLog{" +
            "id=" + id +
            ", hotelId=" + hotelId +
            ", logDate=" + logDate +
            ", house1Count=" + house1Count +
            ", house2Count=" + house2Count +
            ", house3Count=" + house3Count +
            ", remark=" + remark +
            ", isFill=" + isFill +
            ", occupancyToday=" + occupancyToday +
            ", checkOutToday=" + checkOutToday +
            ", isHouseFill=" + isHouseFill +
            ", isPeopleFill=" + isPeopleFill +
            ", controlNumber=" + controlNumber +
            ", addDate=" + addDate +
        "}";
    }
}
