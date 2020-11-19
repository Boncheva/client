package com.yitu.hotel.entity.common;

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
@ApiModel("政府每日安置人员情况")
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

}
