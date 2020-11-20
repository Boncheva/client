package com.yitu.hotel.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yitu.hotel.dto.common.PageDto;
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
@ApiModel("订单表")
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private long hotelId;

    /**
     * 房型：1-普通房间、2-货车司机专用、3-其他
     */
    @TableField("house_type")
    private int houseType;

    /**
     * 用户id
     */
    @TableField("user_id")
    private long userId;

    /**
     * 用户类型：0香港入境普通市民、1机场国际航班人员、2跨境货车司机、3港口入境船员
     */
    @TableField("user_type")
    private int userType;

    /**
     * 价格
     */
    @TableField("price")
    private String price;

    /**
     * 入住日期
     */
    @TableField("checkin_date")
    private LocalDate checkinDate;

    /**
     * 状态: 0-预订待审核、1-审核未通过、2-已预订、3-入住、4-爽约、5-退房、9-取消
     */
    @TableField("status")
    private int status;

    /**
     * 提交时间
     */
    @TableField("add_date")
    private LocalDateTime addDate;

    /**
     * 实际入住时间
     */
    @TableField("real_checkin_date")
    private LocalDateTime realCheckinDate;

    /**
     * 取消时间（用户未入住前，主动退房）
     */
    @TableField("cancel_date")
    private LocalDateTime cancelDate;

    /**
     * 更新时间
     */
    @TableField("modify_date")
    private LocalDateTime modifyDate;

    /**
     * 是否删除：0-未删除、1-已删除
     */
    @TableField("deleted")
    private int deleted;

    /**
     * 操作人
     */
    @TableField("operate_user")
    private String operateUser;

    /**
     * 操作时间
     */
    @TableField("operate_date")
    private LocalDateTime operateDate;

    /**
     * 退房时间
     */
    @TableField("checkout_date")
    private LocalDateTime checkoutDate;

    /**
     * 入住房号
     */
    @TableField("room_num")
    private String roomNum;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 审核时间
     */
    @TableField("check_date")
    private LocalDateTime checkDate;

    /**
     * 审核人
     */
    @TableField("check_user")
    private String checkUser;

    /**
     * 审核原因
     */
    @TableField("check_reason")
    private String checkReason;

    /**
     * 来源：0用户、1酒店、2导入
     */
    @TableField("from_type")
    private int fromType;

    /**
     * 导入原始备注
     */
    @TableField("ori_remark")
    private String oriRemark;

}
