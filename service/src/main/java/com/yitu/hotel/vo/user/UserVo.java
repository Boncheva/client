package com.yitu.hotel.vo.user;

import com.yitu.hotel.vo.common.PageVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("用户")
public class UserVo extends PageVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private long id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 年龄
     */
    private int age;

    /**
     * 国籍（地区）
     */
    private String nationality;

    /**
     * 证件类型：1.身份证，2.港澳通行证，3.护照，4.回乡证
     */
    private int certType;

    /**
     * 证件号码
     */
    private String certNo;

    /**
     * 是否删除: 0-未删除、1-已删除
     */
    private int deleted;

    /**
     * 公安审核状态：0待审核、1审核通过、2审核不通过
     */
    private int checkStatus;

    /**
     * 公安审核时间
     */
    private LocalDateTime checkDate;

    /**
     * 公安审核原因
     */
    private String checkReason;

    /**
     * 公安审核人
     */
    private String checkUser;

    /**
     * 核酸人工审核状态：0待审核、1审核通过、2审核不通过
     */
    private int hsRgCheckStatus;

    /**
     * 核酸人工审核时间
     */
    private LocalDateTime hsRgCheckDate;

    /**
     * 核酸人工审核原因
     */
    private String hsRgCheckReason;

    /**
     * 核酸人工审核人
     */
    private String hsRgCheckUser;

    /**
     * 社区审核状态：0待审核、1审核通过、2审核不通过
     */
    private int sqCheckStatus;

    /**
     * 社区审核时间
     */
    private LocalDateTime sqCheckDate;

    /**
     * '社区审核原因'
     */
    private String sqCheckReason;

    /**
     * '社区审核人'
     */
    private String sqCheckUser;

    /**
     * 用户类型：0香港入境普通市民、1机场国际航班人员、2跨境货车司机、3港口入境船员
     */
    private int userType;

    /**
     * 来源类型：0一码通海关推送、1一码通粤省事补登、2手机端注册
     */
    private String fromType;
}
