package com.zhlx.cemp.cmd;

public class GetCommonDataCmd {

    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 代码
     */
    private String code;

    /**
     * 类型
     */
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
