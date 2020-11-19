package com.yitu.hotel.dto.room;

import com.yitu.hotel.dto.common.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("房间用户")
public class RoomUsersDto extends PageDto {

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
     * 证件类型：1.身份证，2.港澳通行证，3.护照，4.回乡证
     */
    private int certType;

    /**
     * 证件号码
     */
    private String certNo;

    /**
     * 年龄
     */
    private int age;

    /**
     * 是否主申请人：0否、1是
     */
    private int mainRequest;

    /**
     * 类型：0登记、1订单
     */
    private int type;

    /**
     * 主申请人用户id
     */
    private long userId;

    /**
     * 订单id
     */
    private long orderId;

    /**
     * 核酸检测时间
     */
    private String hsCheckDate;

    /**
     * 核酸状态：0阴性、1阳性
     */
    private int hsCheckStatus;

    /**
     * 核酸报告文件路径
     */
    private String reportPath;

    /**
     * 核酸人工审核状态：0待审核、1审核通过、2审核不通过
     */
    private int checkRgStatus;

    /**
     * 核酸人工审核原因
     */
    private String checkRgReason;

    /**
     * 核酸人工审核时间
     */
    private String checkRgDate;

    /**
     * 核酸人工审核人
     */
    private String checkRgUser;

    /**
     * 更新时间
     */
    private String modifyDate;

    /**
     * 公安审核状态：0待审核、1审核通过、2审核不通过
     */
    private int checkStatus;

    /**
     * 公安审核原因
     */
    private String checkReason;

    /**
     * 公安审核时间
     */
    private String checkDate;

    /**
     * 公安审核人
     */
    private String checkUser;
}
