package com.yitu.hotel.dto.adminUser;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel(value = "token信息存储")
public class TokenDto {

    private static final long serialVersionUID = 1L;

    private int id;

    private int userId;

    private int buildTime;

    private String token;
}
