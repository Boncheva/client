package com.yitu.hotel.vo.adminUser;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("token信息")
public class TokenVo {

    private static final long serialVersionUID = 1L;

    private int id;

    private int userId;

    private int buildTime;

    private String token;
}
