package com.zhlx.cemp.dto;

import java.io.Serializable;

public class ListCommonDataDto implements Serializable {

    private static final long serialVersionUID = -2415029396111842709L;

    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 排序
     */
    private Short sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标志（0：未删除；1：已删除）
     */
    private String deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

}
