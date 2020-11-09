package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 酒店调控日志表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("hotel_control_log")
public class HotelControlLog implements Serializable {

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
     * 酒店名称
     */
    @TableField("hotel_name")
    private String hotelName;

    /**
     * 详细地址
     */
    @TableField("address")
    private String address;

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
    private Integer house1TotalCount;

    /**
     * 房型1可预约数
     */
    @TableField("house1_show_count")
    private Integer house1ShowCount;

    /**
     * 房型1可用数
     */
    @TableField("house1_count")
    private Integer house1Count;

    /**
     * 房型1管控数
     */
    @TableField("house1_control_count")
    private Integer house1ControlCount;

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
    private Integer house2TotalCount;

    /**
     * 房型2可预约数
     */
    @TableField("house2_show_count")
    private Integer house2ShowCount;

    /**
     * 房型2可用数
     */
    @TableField("house2_count")
    private Integer house2Count;

    /**
     * 房型2管控数
     */
    @TableField("house2_control_count")
    private Integer house2ControlCount;

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
    private Integer house3TotalCount;

    /**
     * 房型3可预约数
     */
    @TableField("house3_show_count")
    private Integer house3ShowCount;

    /**
     * 房型3可用数
     */
    @TableField("house3_count")
    private Integer house3Count;

    /**
     * 房型3管控数
     */
    @TableField("house3_control_count")
    private Integer house3ControlCount;

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
     * 添加时间
     */
    @TableField("operate_date")
    private LocalDateTime operateDate;

    /**
     * 添加人
     */
    @TableField("operate_user")
    private String operateUser;

    /**
     * 操作方式：0批量、1单个
     */
    @TableField("operate_type")
    private Integer operateType;

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
     * 城市：1-深圳房源 2-珠海房源
     */
    @TableField("area_type")
    private Integer areaType;

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
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public Integer getHouse1TotalCount() {
        return house1TotalCount;
    }

    public void setHouse1TotalCount(Integer house1TotalCount) {
        this.house1TotalCount = house1TotalCount;
    }
    public Integer getHouse1ShowCount() {
        return house1ShowCount;
    }

    public void setHouse1ShowCount(Integer house1ShowCount) {
        this.house1ShowCount = house1ShowCount;
    }
    public Integer getHouse1Count() {
        return house1Count;
    }

    public void setHouse1Count(Integer house1Count) {
        this.house1Count = house1Count;
    }
    public Integer getHouse1ControlCount() {
        return house1ControlCount;
    }

    public void setHouse1ControlCount(Integer house1ControlCount) {
        this.house1ControlCount = house1ControlCount;
    }
    public String getHouse1Price() {
        return house1Price;
    }

    public void setHouse1Price(String house1Price) {
        this.house1Price = house1Price;
    }
    public String getHouse1Remark() {
        return house1Remark;
    }

    public void setHouse1Remark(String house1Remark) {
        this.house1Remark = house1Remark;
    }
    public Integer getHouse2TotalCount() {
        return house2TotalCount;
    }

    public void setHouse2TotalCount(Integer house2TotalCount) {
        this.house2TotalCount = house2TotalCount;
    }
    public Integer getHouse2ShowCount() {
        return house2ShowCount;
    }

    public void setHouse2ShowCount(Integer house2ShowCount) {
        this.house2ShowCount = house2ShowCount;
    }
    public Integer getHouse2Count() {
        return house2Count;
    }

    public void setHouse2Count(Integer house2Count) {
        this.house2Count = house2Count;
    }
    public Integer getHouse2ControlCount() {
        return house2ControlCount;
    }

    public void setHouse2ControlCount(Integer house2ControlCount) {
        this.house2ControlCount = house2ControlCount;
    }
    public String getHouse2Price() {
        return house2Price;
    }

    public void setHouse2Price(String house2Price) {
        this.house2Price = house2Price;
    }
    public String getHouse2Remark() {
        return house2Remark;
    }

    public void setHouse2Remark(String house2Remark) {
        this.house2Remark = house2Remark;
    }
    public Integer getHouse3TotalCount() {
        return house3TotalCount;
    }

    public void setHouse3TotalCount(Integer house3TotalCount) {
        this.house3TotalCount = house3TotalCount;
    }
    public Integer getHouse3ShowCount() {
        return house3ShowCount;
    }

    public void setHouse3ShowCount(Integer house3ShowCount) {
        this.house3ShowCount = house3ShowCount;
    }
    public Integer getHouse3Count() {
        return house3Count;
    }

    public void setHouse3Count(Integer house3Count) {
        this.house3Count = house3Count;
    }
    public Integer getHouse3ControlCount() {
        return house3ControlCount;
    }

    public void setHouse3ControlCount(Integer house3ControlCount) {
        this.house3ControlCount = house3ControlCount;
    }
    public String getHouse3Price() {
        return house3Price;
    }

    public void setHouse3Price(String house3Price) {
        this.house3Price = house3Price;
    }
    public String getHouse3Remark() {
        return house3Remark;
    }

    public void setHouse3Remark(String house3Remark) {
        this.house3Remark = house3Remark;
    }
    public LocalDateTime getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(LocalDateTime operateDate) {
        this.operateDate = operateDate;
    }
    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }
    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
    public String getContractUser() {
        return contractUser;
    }

    public void setContractUser(String contractUser) {
        this.contractUser = contractUser;
    }
    public String getContractMobile() {
        return contractMobile;
    }

    public void setContractMobile(String contractMobile) {
        this.contractMobile = contractMobile;
    }
    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    @Override
    public String toString() {
        return "HotelControlLog{" +
            "id=" + id +
            ", hotelId=" + hotelId +
            ", hotelName=" + hotelName +
            ", address=" + address +
            ", district=" + district +
            ", street=" + street +
            ", house1TotalCount=" + house1TotalCount +
            ", house1ShowCount=" + house1ShowCount +
            ", house1Count=" + house1Count +
            ", house1ControlCount=" + house1ControlCount +
            ", house1Price=" + house1Price +
            ", house1Remark=" + house1Remark +
            ", house2TotalCount=" + house2TotalCount +
            ", house2ShowCount=" + house2ShowCount +
            ", house2Count=" + house2Count +
            ", house2ControlCount=" + house2ControlCount +
            ", house2Price=" + house2Price +
            ", house2Remark=" + house2Remark +
            ", house3TotalCount=" + house3TotalCount +
            ", house3ShowCount=" + house3ShowCount +
            ", house3Count=" + house3Count +
            ", house3ControlCount=" + house3ControlCount +
            ", house3Price=" + house3Price +
            ", house3Remark=" + house3Remark +
            ", operateDate=" + operateDate +
            ", operateUser=" + operateUser +
            ", operateType=" + operateType +
            ", contractUser=" + contractUser +
            ", contractMobile=" + contractMobile +
            ", areaType=" + areaType +
        "}";
    }
}
