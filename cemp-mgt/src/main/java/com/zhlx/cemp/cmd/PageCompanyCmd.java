package com.zhlx.cemp.cmd;

import com.zhlx.cemp.page.Page;

import java.util.Date;

public class PageCompanyCmd {

    /**
     * 分页对象
     */
    private Page page = new Page();

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间开始
     */
    private Date createdTimeStart;

    /**
     * 创建时间结束
     */
    private Date createdTimeEnd;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedTimeStart() {
        return createdTimeStart;
    }

    public void setCreatedTimeStart(Date createdTimeStart) {
        this.createdTimeStart = createdTimeStart;
    }

    public Date getCreatedTimeEnd() {
        return createdTimeEnd;
    }

    public void setCreatedTimeEnd(Date createdTimeEnd) {
        this.createdTimeEnd = createdTimeEnd;
    }
}
