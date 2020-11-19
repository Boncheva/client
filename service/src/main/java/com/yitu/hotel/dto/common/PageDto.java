package com.yitu.hotel.dto.common;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/17
 */
@Data
@ApiModel("分页基础类")
public class PageDto {

    @TableField(exist = false)
    public Integer pageNum;

    @TableField(exist = false)
    public Integer pageSize;

}
