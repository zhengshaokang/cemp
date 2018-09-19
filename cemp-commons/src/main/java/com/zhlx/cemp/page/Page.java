package com.zhlx.cemp.page;

import java.io.Serializable;

/**
 * 作用：分页对象
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 5517485298682715631L;

    /**
     * 当前页码，从1开始
     */
    private int pageNum = 1;

    /**
     * 页面记录数，如果设置为0，就不执行分页，返回全部结果
     */
    private int pageSize = 20;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 为了防止别人修改pageSize为很大来损耗服务器的性能所以限制一下最大的Pagesize
     */
    private static final int MAX_PAGE_SIZE = 100;

    public Page() {}

    public Page(int pageNum, int pageSize) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
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
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
