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
 * 酒店基础表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("hotel")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 酒店名称
     */
    @TableField("hotel_name")
    private String hotelName;

    /**
     * 别名
     */
    @TableField("hotel_other_name")
    private String hotelOtherName;

    /**
     * 酒店类型id（多种以,进行分隔）
     */
    @TableField("hotel_types")
    private String hotelTypes;

    /**
     * 详细地址
     */
    @TableField("address")
    private String address;

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
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 添加时间
     */
    @TableField("add_date")
    private LocalDateTime addDate;

    /**
     * 更新时间
     */
    @TableField("modify_date")
    private LocalDateTime modifyDate;

    /**
     * 是否删除: 0-未删除、1-已删除
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 是否展示 0-展示、1-不展示
     */
    @TableField("notshow")
    private Boolean notshow;

    /**
     * 酒店登陆账号
     */
    @TableField("hotel_username")
    private String hotelUsername;

    /**
     * 酒店登陆密码
     */
    @TableField("hotel_password")
    private String hotelPassword;

    /**
     * 酒店图片url
     */
    @TableField("url")
    private String url;

    /**
     * 房源数最后同步时间
     */
    @TableField("last_synch_date")
    private LocalDateTime lastSynchDate;

    /**
     * 管控时间
     */
    @TableField("control_date")
    private String controlDate;

    /**
     * 可预约日期
     */
    @TableField("reserve_date")
    private String reserveDate;

    /**
     * 区政府是否上报
     */
    @TableField("is_report")
    private Integer isReport;

    /**
     * 1-深圳房源 2-珠海房源 3-其他城市
     */
    @TableField("area_type")
    private Integer areaType;

    /**
     * 房型4总间数
     */
    @TableField("house4_total_count")
    private Integer house4TotalCount;

    /**
     * 房型4可预约数
     */
    @TableField("house4_show_count")
    private Integer house4ShowCount;

    /**
     * 房型4可用数
     */
    @TableField("house4_count")
    private Integer house4Count;

    /**
     * 房型4管控数
     */
    @TableField("house4_control_count")
    private Integer house4ControlCount;

    /**
     * 房型4价格
     */
    @TableField("house4_price")
    private String house4Price;

    /**
     * 房型4备注
     */
    @TableField("house4_remark")
    private String house4Remark;

    /**
     * 房型5总间数
     */
    @TableField("house5_total_count")
    private Integer house5TotalCount;

    /**
     * 房型5可预约数
     */
    @TableField("house5_show_count")
    private Integer house5ShowCount;

    /**
     * 房型5可用数
     */
    @TableField("house5_count")
    private Integer house5Count;

    /**
     * 房型5管控数
     */
    @TableField("house5_control_count")
    private Integer house5ControlCount;

    /**
     * 房型5价格
     */
    @TableField("house5_price")
    private String house5Price;

    /**
     * 房型5备注
     */
    @TableField("house5_remark")
    private String house5Remark;

    /**
     * 房型6总间数
     */
    @TableField("house6_total_count")
    private Integer house6TotalCount;

    /**
     * 房型6可预约数
     */
    @TableField("house6_show_count")
    private Integer house6ShowCount;

    /**
     * 房型6可用数
     */
    @TableField("house6_count")
    private Integer house6Count;

    /**
     * 房型6管控数
     */
    @TableField("house6_control_count")
    private Integer house6ControlCount;

    /**
     * 房型6价格
     */
    @TableField("house6_price")
    private String house6Price;

    /**
     * 房型6备注
     */
    @TableField("house6_remark")
    private String house6Remark;

    @TableField(exist = false)
    private Integer todayOrderCount;
    @TableField(exist = false)
    private Integer todayCheckInCount;
    @TableField(exist = false)
    private Integer todayCheckOutCount;
    @TableField(exist = false)
    private Integer todayRemindCount;

    @TableField(exist = false)
    private List<Config> configList;

    public List<Config> getConfigList() {
        return configList;
    }

    public void setConfigList(List<Config> configList) {
        this.configList = configList;
    }

    public Integer getTodayOrderCount() {
        return todayOrderCount;
    }

    public void setTodayOrderCount(Integer todayOrderCount) {
        this.todayOrderCount = todayOrderCount;
    }

    public Integer getTodayCheckInCount() {
        return todayCheckInCount;
    }

    public void setTodayCheckInCount(Integer todayCheckInCount) {
        this.todayCheckInCount = todayCheckInCount;
    }

    public Integer getTodayCheckOutCount() {
        return todayCheckOutCount;
    }

    public void setTodayCheckOutCount(Integer todayCheckOutCount) {
        this.todayCheckOutCount = todayCheckOutCount;
    }

    public Integer getTodayRemindCount() {
        return todayRemindCount;
    }

    public void setTodayRemindCount(Integer todayRemindCount) {
        this.todayRemindCount = todayRemindCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelOtherName() {
        return hotelOtherName;
    }

    public void setHotelOtherName(String hotelOtherName) {
        this.hotelOtherName = hotelOtherName;
    }

    public String getHotelTypes() {
        return hotelTypes;
    }

    public void setHotelTypes(String hotelTypes) {
        this.hotelTypes = hotelTypes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getNotshow() {
        return notshow;
    }

    public void setNotshow(Boolean notshow) {
        this.notshow = notshow;
    }

    public String getHotelUsername() {
        return hotelUsername;
    }

    public void setHotelUsername(String hotelUsername) {
        this.hotelUsername = hotelUsername;
    }

    public String getHotelPassword() {
        return hotelPassword;
    }

    public void setHotelPassword(String hotelPassword) {
        this.hotelPassword = hotelPassword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getLastSynchDate() {
        return lastSynchDate;
    }

    public void setLastSynchDate(LocalDateTime lastSynchDate) {
        this.lastSynchDate = lastSynchDate;
    }

    public String getControlDate() {
        return controlDate;
    }

    public void setControlDate(String controlDate) {
        this.controlDate = controlDate;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public Integer getHouse4TotalCount() {
        return house4TotalCount;
    }

    public void setHouse4TotalCount(Integer house4TotalCount) {
        this.house4TotalCount = house4TotalCount;
    }

    public Integer getHouse4ShowCount() {
        return house4ShowCount;
    }

    public void setHouse4ShowCount(Integer house4ShowCount) {
        this.house4ShowCount = house4ShowCount;
    }

    public Integer getHouse4Count() {
        return house4Count;
    }

    public void setHouse4Count(Integer house4Count) {
        this.house4Count = house4Count;
    }

    public Integer getHouse4ControlCount() {
        return house4ControlCount;
    }

    public void setHouse4ControlCount(Integer house4ControlCount) {
        this.house4ControlCount = house4ControlCount;
    }

    public String getHouse4Price() {
        return house4Price;
    }

    public void setHouse4Price(String house4Price) {
        this.house4Price = house4Price;
    }

    public String getHouse4Remark() {
        return house4Remark;
    }

    public void setHouse4Remark(String house4Remark) {
        this.house4Remark = house4Remark;
    }

    public Integer getHouse5TotalCount() {
        return house5TotalCount;
    }

    public void setHouse5TotalCount(Integer house5TotalCount) {
        this.house5TotalCount = house5TotalCount;
    }

    public Integer getHouse5ShowCount() {
        return house5ShowCount;
    }

    public void setHouse5ShowCount(Integer house5ShowCount) {
        this.house5ShowCount = house5ShowCount;
    }

    public Integer getHouse5Count() {
        return house5Count;
    }

    public void setHouse5Count(Integer house5Count) {
        this.house5Count = house5Count;
    }

    public Integer getHouse5ControlCount() {
        return house5ControlCount;
    }

    public void setHouse5ControlCount(Integer house5ControlCount) {
        this.house5ControlCount = house5ControlCount;
    }

    public String getHouse5Price() {
        return house5Price;
    }

    public void setHouse5Price(String house5Price) {
        this.house5Price = house5Price;
    }

    public String getHouse5Remark() {
        return house5Remark;
    }

    public void setHouse5Remark(String house5Remark) {
        this.house5Remark = house5Remark;
    }

    public Integer getHouse6TotalCount() {
        return house6TotalCount;
    }

    public void setHouse6TotalCount(Integer house6TotalCount) {
        this.house6TotalCount = house6TotalCount;
    }

    public Integer getHouse6ShowCount() {
        return house6ShowCount;
    }

    public void setHouse6ShowCount(Integer house6ShowCount) {
        this.house6ShowCount = house6ShowCount;
    }

    public Integer getHouse6Count() {
        return house6Count;
    }

    public void setHouse6Count(Integer house6Count) {
        this.house6Count = house6Count;
    }

    public Integer getHouse6ControlCount() {
        return house6ControlCount;
    }

    public void setHouse6ControlCount(Integer house6ControlCount) {
        this.house6ControlCount = house6ControlCount;
    }

    public String getHouse6Price() {
        return house6Price;
    }

    public void setHouse6Price(String house6Price) {
        this.house6Price = house6Price;
    }

    public String getHouse6Remark() {
        return house6Remark;
    }

    public void setHouse6Remark(String house6Remark) {
        this.house6Remark = house6Remark;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName=" + hotelName +
                ", hotelOtherName=" + hotelOtherName +
                ", hotelTypes=" + hotelTypes +
                ", address=" + address +
                ", contractUser=" + contractUser +
                ", contractMobile=" + contractMobile +
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
                ", occupancyToday=" + occupancyToday +
                ", checkOutToday=" + checkOutToday +
                ", house3Price=" + house3Price +
                ", house3Remark=" + house3Remark +
                ", remark=" + remark +
                ", addDate=" + addDate +
                ", modifyDate=" + modifyDate +
                ", deleted=" + deleted +
                ", notshow=" + notshow +
                ", hotelUsername=" + hotelUsername +
                ", hotelPassword=" + hotelPassword +
                ", url=" + url +
                ", lastSynchDate=" + lastSynchDate +
                ", controlDate=" + controlDate +
                ", reserveDate=" + reserveDate +
                ", isReport=" + isReport +
                ", areaType=" + areaType +
                ", house4TotalCount=" + house4TotalCount +
                ", house4ShowCount=" + house4ShowCount +
                ", house4Count=" + house4Count +
                ", house4ControlCount=" + house4ControlCount +
                ", house4Price=" + house4Price +
                ", house4Remark=" + house4Remark +
                ", house5TotalCount=" + house5TotalCount +
                ", house5ShowCount=" + house5ShowCount +
                ", house5Count=" + house5Count +
                ", house5ControlCount=" + house5ControlCount +
                ", house5Price=" + house5Price +
                ", house5Remark=" + house5Remark +
                ", house6TotalCount=" + house6TotalCount +
                ", house6ShowCount=" + house6ShowCount +
                ", house6Count=" + house6Count +
                ", house6ControlCount=" + house6ControlCount +
                ", house6Price=" + house6Price +
                ", house6Remark=" + house6Remark +
                "}";
    }
}
