package com.zhlx.cemp.cmd;

public class GetCompanyCmd {

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    public GetCompanyCmd() {
    }

    public GetCompanyCmd(Integer id) {
        this.id = id;
    }

    public GetCompanyCmd(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
