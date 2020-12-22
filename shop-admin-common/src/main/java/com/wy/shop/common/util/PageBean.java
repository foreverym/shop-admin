package com.wy.shop.common.util;

import lombok.Data;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/14  11:25
 */
public class PageBean<T> {

    private Integer count;
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPages;
    private List<T> data;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return (count -1)/pageSize + 1;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
