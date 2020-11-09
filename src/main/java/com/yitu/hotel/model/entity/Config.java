package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 配置表
 * </p>
 *
 * @author MyBatisPlusGenerater
 * @since 2020-10-29
 */
@TableName("config")
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父类id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 配置项名
     */
    @TableField("item_name")
    private String itemName;

    /**
     * 配置项值
     */
    @TableField("item_value")
    private String itemValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public String toString() {
        return "Config{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", itemName=" + itemName +
            ", itemValue=" + itemValue +
        "}";
    }
}
