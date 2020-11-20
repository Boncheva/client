package com.yitu.hotel.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yitu.hotel.dto.common.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("用户表")
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

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
    private int sex;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private String birthday;

    /**
     * 年龄
     */
    @TableField("age")
    private int age;

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
    private int certType;

    /**
     * 证件号码
     */
    @TableField("cert_no")
    private String certNo;

    /**
     * 入境口岸
     */
    @TableField("port_type")
    private int portType;

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
    private int baseIllnessType;

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
    private int shyCount;

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
    private int deleted;

    /**
     * 是否填报
     */
    @TableField("fill_status")
    private int fillStatus;

    /**
     * 核酸检测时间
     */
    @TableField("hs_check_date")
    private LocalDateTime hsCheckDate;

    /**
     * 核酸状态：0阴性、1阳性
     */
    @TableField("hs_check_status")
    private int hsCheckStatus;

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
    private int checkStatus;

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
    private int hsRgCheckStatus;

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
    private int sqCheckStatus;

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
    private int fromType;

    /**
     * 用户类型：0香港入境普通市民、1机场国际航班人员、2跨境货车司机、3港口入境船员
     */
    @TableField("user_type")
    private int userType;
}
