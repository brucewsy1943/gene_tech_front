package com.genetech.bean.dto;

/**
 * Created by Administrator on 2020/5/22.
 */
public class Pagenation {
    Integer pageNum;
    Integer pageSize;

    public Pagenation() {
    }

    public Pagenation(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
