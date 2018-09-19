package com.zhlx.cemp.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private String status;

    /**
     * 姓名
     */
    private String name;

    /**
     * 职位
     */
    private String position;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 手机
     */
    private String mobilephone;

    /**
     * 身份证号码
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 登录次数
     */
    @Column(name = "login_times")
    private Integer loginTimes;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Integer createdBy;

    /**
     * 修改时间
     */
    @Column(name = "modified_time")
    private Date modifiedTime;

    /**
     * 修改人
     */
    @Column(name = "modified_by")
    private Integer modifiedBy;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取职位
     *
     * @return position - 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取电话
     *
     * @return telephone - 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话
     *
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取手机
     *
     * @return mobilephone - 手机
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * 设置手机
     *
     * @param mobilephone 手机
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * 获取身份证号码
     *
     * @return id_no - 身份证号码
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置身份证号码
     *
     * @param idNo 身份证号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取登录次数
     *
     * @return login_times - 登录次数
     */
    public Integer getLoginTimes() {
        return loginTimes;
    }

    /**
     * 设置登录次数
     *
     * @param loginTimes 登录次数
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_time - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取修改时间
     *
     * @return modified_time - 修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifiedTime 修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取修改人
     *
     * @return modified_by - 修改人
     */
    public Integer getModifiedBy() {
        return modifiedBy;
    }

    /**
     * 设置修改人
     *
     * @param modifiedBy 修改人
     */
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
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