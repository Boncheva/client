package com.yitu.hotel.dto.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel(value = "省市区列表")
public class DgtxPlacesDto {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int id;

    /**
     * 上级id
     */
    private int parentId;

    /**
     * 名称
     */
    private String cname;

    /**
     * 级别
     */
    private int ctype;
}
