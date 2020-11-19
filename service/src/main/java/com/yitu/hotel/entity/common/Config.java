package com.yitu.hotel.entity.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("配置信息")
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
}
