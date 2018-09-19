package com.zhlx.cemp.dto;

public class ListUserMenuDto {
    /**
     * 唯一标识
     */
    private String id;

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

    /**
     * 级别
     */
    private Short level;

    /**
     * 排序
     */
    private Short sort;

    /**
     * 链接
     */
    private String link;

    /**
     * 菜单相关的URI
     */
    private String uris;

    /**
     * 菜单打开方式：_self,_blank,_parent,_top，默认是_self
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 删除标志（0：未删除；1：已删除）
     */
    private String deleted;

    /**
     * 获取唯一标识
     *
     * @return id - 唯一标识
     */
    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识
     *
     * @param id 唯一标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取父唯一标识
     *
     * @return parent_id - 父唯一标识
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父唯一标识
     *
     * @param parentId 父唯一标识
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
     * 获取类型（1：管理员；2：用户）
     *
     * @return type - 类型（1：管理员；2：用户）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型（1：管理员；2：用户）
     *
     * @param type 类型（1：管理员；2：用户）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取级别
     *
     * @return level - 级别
     */
    public Short getLevel() {
        return level;
    }

    /**
     * 设置级别
     *
     * @param level 级别
     */
    public void setLevel(Short level) {
        this.level = level;
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
     * 获取链接
     *
     * @return link - 链接
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置链接
     *
     * @param link 链接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取菜单相关的URI
     *
     * @return uris - 菜单相关的URI
     */
    public String getUris() {
        return uris;
    }

    /**
     * 设置菜单相关的URI
     *
     * @param uris 菜单相关的URI
     */
    public void setUris(String uris) {
        this.uris = uris;
    }

    /**
     * 获取菜单打开方式：_self,_blank,_parent,_top，默认是_self
     *
     * @return target - 菜单打开方式：_self,_blank,_parent,_top，默认是_self
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置菜单打开方式：_self,_blank,_parent,_top，默认是_self
     *
     * @param target 菜单打开方式：_self,_blank,_parent,_top，默认是_self
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
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