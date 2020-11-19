package com.yitu.hotel.vo.common;

import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/18
 */
@Data
public class PageVo {

    Integer pageNum;

    Integer PageSize;

    long total;
}
