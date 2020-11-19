package com.yitu.hotel.dto.order;

import com.yitu.hotel.dto.common.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel(value = "订单信息")
public class OrderInfoDto extends PageDto {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String id;

    /**
     * 酒店id
     */

    private String hotelId;

    /**
     * 房型：1-普通房间、2-货车司机专用、3-其他
     */

    private String houseType;

    /**
     * 用户id
     */

    private long userId;

    /**
     * 用户类型：0香港入境普通市民、1机场国际航班人员、2跨境货车司机、3港口入境船员
     */

    private int userType;

    /**
     * 价格
     */

    private String price;

    /**
     * 入住日期
     */

    private String checkinDate;

    /**
     * 状态: 0-预订待审核、1-审核未通过、2-已预订、3-入住、4-爽约、5-退房、9-取消
     */

    private String status;

    /**
     * 提交时间
     */

    private String addDate;

    /**
     * 实际入住时间
     */
    private String realCheckinDate;

    /**
     * 取消时间（用户未入住前，主动退房）
     */

    private String cancelDate;

    /**
     * 更新时间
     */

    private String modifyDate;

    /**
     * 是否删除：0-未删除、1-已删除
     */

    private String deleted;

    /**
     * 操作人
     */

    private String operateUser;

    /**
     * 操作时间
     */

    private String operateDate;

    /**
     * 退房时间
     */

    private String checkoutDate;

    /**
     * 入住房号
     */

    private String roomNum;

    /**
     * 备注
     */

    private String remark;

    /**
     * 审核时间
     */

    private String checkDate;

    /**
     * 审核人
     */

    private String checkUser;

    /**
     * 审核原因
     */

    private String checkReason;

    /**
     * 来源：0用户、1酒店、2导入
     */

    private String fromType;

    /**
     * 导入原始备注
     */
    private String oriRemark;

    private String userName;

    private String sex;

    private String age;

    private String hotelName;

    private String district;

    private String street;

    private String portType;

    private String hotelType;

    private List idList;

}
