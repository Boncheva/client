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
 * 政府每日安置人员情况
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("gov_person_log")
public class GovPersonLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 安置人员日志表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上报日期
     */
    @TableField("log_date")
    private LocalDate logDate;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private Integer hotelId;

    /**
     * 安置人员数
     */
    @TableField("person_num")
    private Integer personNum;

    /**
     * 0 - 未上报， 1 - 保存， 2 - 已上报（不可修改）
     */
    @TableField("person_status")
    private Boolean personStatus;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }
    public Boolean getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(Boolean personStatus) {
        this.personStatus = personStatus;
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

    @Override
    public String toString() {
        return "GovPersonLog{" +
            "id=" + id +
            ", logDate=" + logDate +
            ", hotelId=" + hotelId +
            ", personNum=" + personNum +
            ", personStatus=" + personStatus +
            ", updateUserId=" + updateUserId +
            ", updateTime=" + updateTime +
        "}";
    }
}
