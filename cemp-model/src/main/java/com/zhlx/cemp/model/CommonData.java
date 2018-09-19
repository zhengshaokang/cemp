package com.zhlx.cemp.model;

import javax.persistence.*;

@Table(name = "common_data")
public class CommonData {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取代码
     *
     * @return code - 代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码
     *
     * @param code 代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取删除标志（0：未删除；1：已删除）
     *
     * @return deleted - 删除标志（0：未删除；1：已删除）
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * 设置删除标志（0：未删除；1：已删除）
     *
     * @param deleted 删除标志（0：未删除；1：已删除）
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}