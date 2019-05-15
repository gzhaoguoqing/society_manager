package com.sm.bo;

import com.sm.po.Role;
import com.sm.service.PermissionService;
import com.sm.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleBO {
    private String id;

    private String name;

    private List<PermissionBO> permissions = new ArrayList<>();

    public RoleBO() {

    }

    public RoleBO(Role role, PermissionService permissionService) {
        parse(role, permissionService);
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

    public List<PermissionBO> getPermissions() {
        return permissions;
    }

    public void parse(Role role, PermissionService permissionService) {
        if (role == null) {
            return;
        }
        this.setId(role.getId());
        this.setName(getRoleChineseName(role.getName()));
        String permissionIds = role.getPermissionIds();
        if (StringUtils.isNotBlank(permissionIds)) {
            String[] split = permissionIds.split(",");
            List<PermissionBO> permissionBOs = this.getPermissions();
            for (String str : split) {
                PermissionBO permissionBO = permissionService.getById(str);
                if (permissionBO != null) {
                    permissionBOs.add(permissionBO);
                }
            }
        }
    }

    public static String getRoleChineseName(String name) {
        if ("admin".equals(name)) {
            return "管理员";
        } else if ("charge_user".equals(name)) {
            return "社团负责人";
        } else if ("ordinary_user".equals(name)) {
            return "普通成员";
        }
        return null;
    }
}