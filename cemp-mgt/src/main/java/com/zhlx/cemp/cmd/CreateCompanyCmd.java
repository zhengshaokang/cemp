package com.zhlx.cemp.cmd;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCompanyCmd {

    /**
     * 名称
     */
    @NotNull
    @Length(max = 10)
    private String name;

    /**
     * 备注
     */
    @Length(max = 10)
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
