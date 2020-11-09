package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("room_users")
public class RoomUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 证件类型：1.身份证，2.港澳通行证，3.护照，4.回乡证
     */
    @TableField("cert_type")
    private Integer certType;

    /**
     * 证件号码
     */
    @TableField("cert_no")
    private String certNo;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 是否主申请人：0否、1是
     */
    @TableField("main_request")
    private Integer mainRequest;

    /**
     * 类型：0登记、1订单
     */
    @TableField("type")
    private Integer type;

    /**
     * 主申请人用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 订单id
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 核酸检测时间
     */
    @TableField("hs_check_date")
    private LocalDateTime hsCheckDate;

    /**
     * 核酸状态：0阴性、1阳性
     */
    @TableField("hs_check_status")
    private Integer hsCheckStatus;

    /**
     * 核酸报告文件路径
     */
    @TableField("report_path")
    private String reportPath;

    /**
     * 核酸人工审核状态：0待审核、1审核通过、2审核不通过
     */
    @TableField("check_rg_status")
    private Integer checkRgStatus;

    /**
     * 核酸人工审核原因
     */
    @TableField("check_rg_reason")
    private String checkRgReason;

    /**
     * 核酸人工审核时间
     */
    @TableField("check_rg_date")
    private LocalDateTime checkRgDate;

    /**
     * 核酸人工审核人
     */
    @TableField("check_rg_user")
    private String checkRgUser;

    /**
     * 更新时间
     */
    @TableField("modify_date")
    private LocalDateTime modifyDate;

    /**
     * 公安审核状态：0待审核、1审核通过、2审核不通过
     */
    @TableField("check_status")
    private Integer checkStatus;

    /**
     * 公安审核原因
     */
    @TableField("check_reason")
    private String checkReason;

    /**
     * 公安审核时间
     */
    @TableField("check_date")
    private LocalDateTime checkDate;

    /**
     * 公安审核人
     */
    @TableField("check_user")
    private String checkUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getCertType() {
        return certType;
    }

    public void setCertType(Integer certType) {
        this.certType = certType;
    }
    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getMainRequest() {
        return mainRequest;
    }

    public void setMainRequest(Integer mainRequest) {
        this.mainRequest = mainRequest;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getHsCheckDate() {
        return hsCheckDate;
    }

    public void setHsCheckDate(LocalDateTime hsCheckDate) {
        this.hsCheckDate = hsCheckDate;
    }
    public Integer getHsCheckStatus() {
        return hsCheckStatus;
    }

    public void setHsCheckStatus(Integer hsCheckStatus) {
        this.hsCheckStatus = hsCheckStatus;
    }
    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }
    public Integer getCheckRgStatus() {
        return checkRgStatus;
    }

    public void setCheckRgStatus(Integer checkRgStatus) {
        this.checkRgStatus = checkRgStatus;
    }
    public String getCheckRgReason() {
        return checkRgReason;
    }

    public void setCheckRgReason(String checkRgReason) {
        this.checkRgReason = checkRgReason;
    }
    public LocalDateTime getCheckRgDate() {
        return checkRgDate;
    }

    public void setCheckRgDate(LocalDateTime checkRgDate) {
        this.checkRgDate = checkRgDate;
    }
    public String getCheckRgUser() {
        return checkRgUser;
    }

    public void setCheckRgUser(String checkRgUser) {
        this.checkRgUser = checkRgUser;
    }
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
    public String getCheckReason() {
        return checkReason;
    }

    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
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

    @Override
    public String toString() {
        return "RoomUsers{" +
            "id=" + id +
            ", userName=" + userName +
            ", certType=" + certType +
            ", certNo=" + certNo +
            ", age=" + age +
            ", mainRequest=" + mainRequest +
            ", type=" + type +
            ", userId=" + userId +
            ", orderId=" + orderId +
            ", hsCheckDate=" + hsCheckDate +
            ", hsCheckStatus=" + hsCheckStatus +
            ", reportPath=" + reportPath +
            ", checkRgStatus=" + checkRgStatus +
            ", checkRgReason=" + checkRgReason +
            ", checkRgDate=" + checkRgDate +
            ", checkRgUser=" + checkRgUser +
            ", modifyDate=" + modifyDate +
            ", checkStatus=" + checkStatus +
            ", checkReason=" + checkReason +
            ", checkDate=" + checkDate +
            ", checkUser=" + checkUser +
        "}";
    }
}
