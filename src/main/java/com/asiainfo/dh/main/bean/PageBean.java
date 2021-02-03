package com.asiainfo.dh.main.bean;

public class PageBean<T> {

    private T bean;
    private int pageNum;
    private int pageSize;

    public PageBean(){}

    public PageBean(T bean, int pageNum, int pageSize) {
        this.bean = bean;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

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
