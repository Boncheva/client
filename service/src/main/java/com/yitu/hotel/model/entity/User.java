package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("user")
public class User extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标识号
     */
    @TableField("id_code")
    private String idCode;

    /**
     * 用户密码
     */
    @TableField("passwd")
    private String passwd;

    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 性别：0-男、1-女
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private String birthday;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 香港手机号码
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 内地手机号
     */
    @TableField("mobile2")
    private String mobile2;

    /**
     * 国籍（地区）
     */
    @TableField("nationality")
    private String nationality;

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
     * 入境口岸
     */
    @TableField("port_type")
    private Integer portType;

    /**
     * 目的地省
     */
    @TableField("province")
    private String province;

    /**
     * 目的地市
     */
    @TableField("city")
    private String city;

    /**
     * 目的地区
     */
    @TableField("area")
    private String area;

    /**
     * 详细地址
     */
    @TableField("address")
    private String address;

    /**
     * 过去14天内至今旅居的国家和地区
     */
    @TableField("area_14day_in")
    private String area14dayIn;

    /**
     * 核酸报告文件路径
     */
    @TableField("report_path")
    private String reportPath;

    /**
     * 入境事由
     */
    @TableField("enter_reason")
    private String enterReason;

    /**
     * 基础性疾病其他
     */
    @TableField("base_illness")
    private String baseIllness;

    /**
     * 基础性疾病类型
     */
    @TableField("base_illness_type")
    private Integer baseIllnessType;

    /**
     * 特殊需求服务
     */
    @TableField("special_demand")
    private String specialDemand;

    /**
     * 民族
     */
    @TableField("nation")
    private String nation;

    /**
     * 宗教信仰
     */
    @TableField("faith")
    private String faith;

    /**
     * 爽约次数
     */
    @TableField("shy_count")
    private Integer shyCount;

    /**
     * 注册时间
     */
    @TableField("reg_date")
    private LocalDateTime regDate;

    /**
     * 更新时间
     */
    @TableField("modify_date")
    private LocalDateTime modifyDate;

    /**
     * 最后登录时间
     */
    @TableField("login_date")
    private LocalDateTime loginDate;

    /**
     * 是否删除: 0-未删除、1-已删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 是否填报
     */
    @TableField("fill_status")
    private Integer fillStatus;

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
     * 境内紧急联系人姓名
     */
    @TableField("contract_user")
    private String contractUser;

    /**
     * 境内紧急联系人手机号
     */
    @TableField("contract_mobile")
    private String contractMobile;

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

    /**
     * 核酸人工审核状态：0待审核、1审核通过、2审核不通过
     */
    @TableField("hs_rg_check_status")
    private Integer hsRgCheckStatus;

    /**
     * 核酸人工审核原因
     */
    @TableField("hs_rg_check_reason")
    private String hsRgCheckReason;

    /**
     * 核酸人工审核时间
     */
    @TableField("hs_rg_check_date")
    private LocalDateTime hsRgCheckDate;

    /**
     * 核酸人工审核人
     */
    @TableField("hs_rg_check_user")
    private String hsRgCheckUser;

    /**
     * 社区审核状态：0待审核、1审核通过、2审核不通过
     */
    @TableField("sq_check_status")
    private Integer sqCheckStatus;

    /**
     * 社区审核原因
     */
    @TableField("sq_check_reason")
    private String sqCheckReason;

    /**
     * 社区审核时间
     */
    @TableField("sq_check_date")
    private LocalDateTime sqCheckDate;

    /**
     * 社区审核人
     */
    @TableField("sq_check_user")
    private String sqCheckUser;

    /**
     * 城市：1深圳、2珠海
     */
    @TableField("area_type")
    private Boolean areaType;

    /**
     * 来源类型：0一码通海关推送、1一码通粤省事补登、2手机端注册
     */
    @TableField("from_type")
    private Integer fromType;

    /**
     * 用户类型：0香港入境普通市民、1机场国际航班人员、2跨境货车司机、3港口入境船员
     */
    @TableField("user_type")
    private Integer userType;

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    @TableField(exist = false)
    private String isSubmit;

    @TableField(exist = false)
    private String idOrName;

    public String getIdOrName() {
        return idOrName;
    }

    public void setIdOrName(String idOrName) {
        this.idOrName = idOrName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public Integer getPortType() {
        return portType;
    }

    public void setPortType(Integer portType) {
        this.portType = portType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea14dayIn() {
        return area14dayIn;
    }

    public void setArea14dayIn(String area14dayIn) {
        this.area14dayIn = area14dayIn;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getEnterReason() {
        return enterReason;
    }

    public void setEnterReason(String enterReason) {
        this.enterReason = enterReason;
    }

    public String getBaseIllness() {
        return baseIllness;
    }

    public void setBaseIllness(String baseIllness) {
        this.baseIllness = baseIllness;
    }

    public Integer getBaseIllnessType() {
        return baseIllnessType;
    }

    public void setBaseIllnessType(Integer baseIllnessType) {
        this.baseIllnessType = baseIllnessType;
    }

    public String getSpecialDemand() {
        return specialDemand;
    }

    public void setSpecialDemand(String specialDemand) {
        this.specialDemand = specialDemand;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getFaith() {
        return faith;
    }

    public void setFaith(String faith) {
        this.faith = faith;
    }

    public Integer getShyCount() {
        return shyCount;
    }

    public void setShyCount(Integer shyCount) {
        this.shyCount = shyCount;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getFillStatus() {
        return fillStatus;
    }

    public void setFillStatus(Integer fillStatus) {
        this.fillStatus = fillStatus;
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

    public Integer getHsRgCheckStatus() {
        return hsRgCheckStatus;
    }

    public void setHsRgCheckStatus(Integer hsRgCheckStatus) {
        this.hsRgCheckStatus = hsRgCheckStatus;
    }

    public String getHsRgCheckReason() {
        return hsRgCheckReason;
    }

    public void setHsRgCheckReason(String hsRgCheckReason) {
        this.hsRgCheckReason = hsRgCheckReason;
    }

    public LocalDateTime getHsRgCheckDate() {
        return hsRgCheckDate;
    }

    public void setHsRgCheckDate(LocalDateTime hsRgCheckDate) {
        this.hsRgCheckDate = hsRgCheckDate;
    }

    public String getHsRgCheckUser() {
        return hsRgCheckUser;
    }

    public void setHsRgCheckUser(String hsRgCheckUser) {
        this.hsRgCheckUser = hsRgCheckUser;
    }

    public Integer getSqCheckStatus() {
        return sqCheckStatus;
    }

    public void setSqCheckStatus(Integer sqCheckStatus) {
        this.sqCheckStatus = sqCheckStatus;
    }

    public String getSqCheckReason() {
        return sqCheckReason;
    }

    public void setSqCheckReason(String sqCheckReason) {
        this.sqCheckReason = sqCheckReason;
    }

    public LocalDateTime getSqCheckDate() {
        return sqCheckDate;
    }

    public void setSqCheckDate(LocalDateTime sqCheckDate) {
        this.sqCheckDate = sqCheckDate;
    }

    public String getSqCheckUser() {
        return sqCheckUser;
    }

    public void setSqCheckUser(String sqCheckUser) {
        this.sqCheckUser = sqCheckUser;
    }

    public Boolean getAreaType() {
        return areaType;
    }

    public void setAreaType(Boolean areaType) {
        this.areaType = areaType;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", idCode=" + idCode +
                ", passwd=" + passwd +
                ", userName=" + userName +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", age=" + age +
                ", mobile=" + mobile +
                ", mobile2=" + mobile2 +
                ", nationality=" + nationality +
                ", certType=" + certType +
                ", certNo=" + certNo +
                ", portType=" + portType +
                ", province=" + province +
                ", city=" + city +
                ", area=" + area +
                ", address=" + address +
                ", area14dayIn=" + area14dayIn +
                ", reportPath=" + reportPath +
                ", enterReason=" + enterReason +
                ", baseIllness=" + baseIllness +
                ", baseIllnessType=" + baseIllnessType +
                ", specialDemand=" + specialDemand +
                ", nation=" + nation +
                ", faith=" + faith +
                ", shyCount=" + shyCount +
                ", regDate=" + regDate +
                ", modifyDate=" + modifyDate +
                ", loginDate=" + loginDate +
                ", deleted=" + deleted +
                ", fillStatus=" + fillStatus +
                ", hsCheckDate=" + hsCheckDate +
                ", hsCheckStatus=" + hsCheckStatus +
                ", contractUser=" + contractUser +
                ", contractMobile=" + contractMobile +
                ", checkStatus=" + checkStatus +
                ", checkReason=" + checkReason +
                ", checkDate=" + checkDate +
                ", checkUser=" + checkUser +
                ", hsRgCheckStatus=" + hsRgCheckStatus +
                ", hsRgCheckReason=" + hsRgCheckReason +
                ", hsRgCheckDate=" + hsRgCheckDate +
                ", hsRgCheckUser=" + hsRgCheckUser +
                ", sqCheckStatus=" + sqCheckStatus +
                ", sqCheckReason=" + sqCheckReason +
                ", sqCheckDate=" + sqCheckDate +
                ", sqCheckUser=" + sqCheckUser +
                ", areaType=" + areaType +
                ", fromType=" + fromType +
                ", userType=" + userType +
                "}";
    }
}
