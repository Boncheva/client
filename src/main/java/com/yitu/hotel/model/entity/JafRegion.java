package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 区/街道/社区信息坐标
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getBound() {
        return bound;
    }

    public void setBound(String bound) {
        this.bound = bound;
    }
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = mapx;
    }
    public String getMapy() {
        return mapy;
    }

    public void setMapy(String mapy) {
        this.mapy = mapy;
    }
    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    public Integer getAreaMark() {
        return areaMark;
    }

    public void setAreaMark(Integer areaMark) {
        this.areaMark = areaMark;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "JafRegion{" +
            "id=" + id +
            ", createTime=" + createTime +
            ", createBy=" + createBy +
            ", updateTime=" + updateTime +
            ", updateBy=" + updateBy +
            ", name=" + name +
            ", description=" + description +
            ", parentId=" + parentId +
            ", bound=" + bound +
            ", longitude=" + longitude +
            ", latitude=" + latitude +
            ", mapx=" + mapx +
            ", mapy=" + mapy +
            ", sortId=" + sortId +
            ", parentName=" + parentName +
            ", sequence=" + sequence +
            ", areaMark=" + areaMark +
            ", tag=" + tag +
        "}";
    }
}
