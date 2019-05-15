package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sm.po.User;
import com.sm.service.InfoService;
import com.sm.service.RoleService;
import com.sm.util.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UserBO {
    private String id;

    private String number;

    private String name;

    private Integer sex;

    private String classes;

    private String contactWay;

    private RoleBO role;

    @JsonIgnore
    private String password;

    private List<InfoBO> associations = new ArrayList<>();

    public UserBO() {

    }

    public UserBO(User user, InfoService infoService, RoleService roleService) {
        parse(user, infoService, roleService);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public RoleBO getRole() {
        return role;
    }

    public void setRole(RoleBO role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public List<InfoBO> getAssociations() {
        return associations;
    }


    public void parse(User user, InfoService infoService, RoleService roleService) {
        if (user == null) {
            return;
        }
        BeanUtils.copyProperties(user, this);
        String associationIds = user.getAssociationIds();
        if (StringUtils.isNotBlank(associationIds)) {
            String[] split = associationIds.split(",");
            List<InfoBO> infoBOList = this.getAssociations();
            for (String str : split) {
                InfoBO infoBO = infoService.getById(str, false);
                if (infoBO != null) {
                    infoBOList.add(infoBO);
                }
            }
        }
        String roleId = user.getRoleId();
        if (StringUtils.isNotBlank(roleId)) {
            RoleBO role = roleService.getById(roleId);
            this.setRole(role);
        }
    }
}