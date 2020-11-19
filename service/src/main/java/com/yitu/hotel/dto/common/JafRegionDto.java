package com.yitu.hotel.dto.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("区、街道、社区信息坐标")
public class JafRegionDto {

    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建方式
     */
    private String createBy;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 更新方式
     */
    private String updateBy;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 区域描述
     */
    private String description;

    /**
     * 上级区域ID
     */
    private int parentId;

    /**
     * 分界
     */
    private String bound;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String mapx;

    /**
     * 纬度
     */
    private String mapy;

    /**
     * 顺序排名
     */
    private int sortId;

    /**
     * 上级区域名称
     */
    private String parentName;

    /**
     * 顺序
     */
    private int sequence;

    /**
     * 区域标志
     */
    private int areaMark;

    /**
     * 备注
     */
    private String tag;
}
