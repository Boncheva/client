package com.yitu.hotel.dto.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("政府每日安置人员情况")
public class GovPersonLogDto {
    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * 上报日期
     */
    private String logDate;

    /**
     * 酒店id
     */
    private int hotelId;

    /**
     * 安置人员数
     */
    private int personNum;

    /**
     * 0 - 未上报， 1 - 保存， 2 - 已上报（不可修改）
     */
    private boolean personStatus;

    /**
     * 修改政府用户id
     */
    private int updateUserId;

    /**
     * 修改时间
     */
    private String updateTime;
}
