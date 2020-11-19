package com.yitu.hotel.vo.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel(value = "字典信息")
public class ConfigVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int id;

    /**
     * 父类id
     */
    private int parentId;

    /**
     * 配置项名
     */
    private String itemName;

    /**
     * 配置项值
     */
    private String itemValue;
}
