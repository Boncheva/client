package com.yitu.hotel.entity.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel("区、街道、社区信息坐标")
@TableName("jaf_region")
public class JafRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 创建方式
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 更新方式
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 单位名称
     */
    @TableField("name")
    private String name;

    /**
     * 区域描述
     */
    @TableField("description")
    private String description;

    /**
     * 上级区域ID
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 分界
     */
    @TableField("bound")
    private String bound;

    /**
     * 经度
     */
    @TableField("longitude")
    private String longitude;

    /**
     * 纬度
     */
    @TableField("latitude")
    private String latitude;

    /**
     * 经度
     */
    @TableField("mapx")
    private String mapx;

    /**
     * 纬度
     */
    @TableField("mapy")
    private String mapy;

    /**
     * 顺序排名
     */
    @TableField("sort_id")
    private Integer sortId;

    /**
     * 上级区域名称
     */
    @TableField("parent_name")
    private String parentName;

    /**
     * 顺序
     */
    @TableField("sequence")
    private Integer sequence;

    /**
     * 区域标志
     */
    @TableField("area_mark")
    private Integer areaMark;

    /**
     * 备注
     */
    @TableField("tag")
    private String tag;
}
