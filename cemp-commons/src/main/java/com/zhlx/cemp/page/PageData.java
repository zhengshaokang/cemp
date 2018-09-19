package com.zhlx.cemp.page;

import java.io.Serializable;
import java.util.List;

/**
 * 作用：分页数据
 * 
 */
public class PageData<E> implements Serializable {

    private static final long serialVersionUID = -7987759131336215737L;

    /**
     * 数据列表
     */
    private List<E> dataList;

    /**
     * 分页对象
     */
    private Page page;

    public PageData() {}

    public PageData(List<E> dataList, Page page) {
        super();
        this.dataList = dataList;
        this.page = page;
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

}
