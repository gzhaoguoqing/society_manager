package com.sm.bo;

import com.sm.po.Permission;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

public class PermissionBO {
    private String id;

    private String name;

    public PermissionBO() {

    }

    public PermissionBO(Permission permission) {
        parse(permission);
    }

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

    public void parse(Permission permission) {
        if (permission == null) {
            return;
        }
        BeanUtils.copyProperties(permission, this);
    }
}