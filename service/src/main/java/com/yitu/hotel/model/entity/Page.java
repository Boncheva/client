package com.yitu.hotel.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @description:
 * @author: zouhao
 * @Date: 2020/11/16
 * @time: 16:32
 */
public class Page {

    @TableField(exist = false)
    public Integer pageNum = 0;

    @TableField(exist = false)
    public Integer pageSize = 0;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
