package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("order_info")
public class OrderInfo extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private Long hotelId;

    /**
     * 房型：1-普通房间、2-货车司机专用、3-其他
     */
    @TableField("house_type")
    private Integer houseType;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 用户类型：0香港入境普通市民、1机场国际航班人员、2跨境货车司机、3港口入境船员
     */
    @TableField("user_type")
    private Integer userType;

    /**
     * 价格
     */
    @TableField("price")
    private String price;

    /**
     * 入住日期
     */
    @TableField("checkin_date")
    private String checkinDate;

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    /**
     * 状态: 0-预订待审核、1-审核未通过、2-已预订、3-入住、4-爽约、5-退房、9-取消
     */
    @TableField("status")
    private Integer status;

    /**
     * 提交时间
     */
    @TableField("add_date")
    private LocalDateTime addDate;

    /**
     * 实际入住时间
     */
    @TableField("real_checkin_date")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    private Integer deleted;

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
    private Integer fromType;

    /**
     * 导入原始备注
     */
    @TableField("ori_remark")
    private String oriRemark;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String sex;

    @TableField(exist = false)
    private String age;

    @TableField(exist = false)
    private String hotelName;

    @TableField(exist = false)
    private String district;

    @TableField(exist = false)
    private String street;

    @TableField(exist = false)
    private String portType;

    @TableField(exist = false)
    private String hotelType;

    @TableField(exist = false)
    private List idList;


    public List getIdList() {
        return idList;
    }

    public void setIdList(List idList) {
        this.idList = idList;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public OrderInfo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

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

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    public LocalDateTime getRealCheckinDate() {
        return realCheckinDate;
    }

    public void setRealCheckinDate(LocalDateTime realCheckinDate) {
        this.realCheckinDate = realCheckinDate;
    }

    public LocalDateTime getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDateTime cancelDate) {
        this.cancelDate = cancelDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

    public LocalDateTime getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(LocalDateTime operateDate) {
        this.operateDate = operateDate;
    }

    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDateTime checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getCheckReason() {
        return checkReason;
    }

    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public String getOriRemark() {
        return oriRemark;
    }

    public void setOriRemark(String oriRemark) {
        this.oriRemark = oriRemark;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", houseType=" + houseType +
                ", userId=" + userId +
                ", userType=" + userType +
                ", price=" + price +
                ", checkinDate=" + checkinDate +
                ", status=" + status +
                ", addDate=" + addDate +
                ", realCheckinDate=" + realCheckinDate +
                ", cancelDate=" + cancelDate +
                ", modifyDate=" + modifyDate +
                ", deleted=" + deleted +
                ", operateUser=" + operateUser +
                ", operateDate=" + operateDate +
                ", checkoutDate=" + checkoutDate +
                ", roomNum=" + roomNum +
                ", remark=" + remark +
                ", checkDate=" + checkDate +
                ", checkUser=" + checkUser +
                ", checkReason=" + checkReason +
                ", fromType=" + fromType +
                ", oriRemark=" + oriRemark +
                "}";
    }
}
