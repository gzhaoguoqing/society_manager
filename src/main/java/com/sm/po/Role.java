package com.sm.po;

public class Role {
    private String id;

    private String name;

    private String permissionIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds == null ? null : permissionIds.trim();
    }
}