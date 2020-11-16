package com.yitu.hotel.model.entity;

/**
 * @description:
 * @author: zouhao
 * @Date: 2020/11/16
 * @time: 16:32
 */
public class Page {

    public Integer pageNum = 1;

    public Integer pageSize = 10;

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
