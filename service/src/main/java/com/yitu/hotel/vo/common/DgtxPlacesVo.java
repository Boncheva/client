package com.yitu.hotel.vo.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel(value = "省市区")
public class DgtxPlacesVo {

    private static final long serialVersionUID = 1L;

    private int id;

    private int parentId;

    private String cname;

    private int ctype;
}
