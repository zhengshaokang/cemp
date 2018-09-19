package com.zhlx.cemp.cmd;

public class DeleteCompanyCmd {

    /**
     * id
     */
    private Integer id;

    public DeleteCompanyCmd() {
    }

    public DeleteCompanyCmd(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
