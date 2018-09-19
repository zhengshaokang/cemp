package com.zhlx.cemp.cmd;

public class ListUserMenuCmd {

    /**
     * 父唯一标识
     */
    private String parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型（1：管理员；2：用户）
     */
    private String type;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
}
