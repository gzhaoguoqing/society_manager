package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sm.po.Info;
import com.sm.po.User;
import com.sm.service.InfoService;
import com.sm.service.RoleService;
import com.sm.service.impl.InfoServiceImpl;
import com.sm.service.impl.RoleServiceImpl;
import com.sm.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private List<InfoBO> associationIds = new ArrayList<>();

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

    public List<InfoBO> getAssociationIds() {
        return associationIds;
    }


    public void parse(User user, InfoService infoService, RoleService roleService) {
        if (user == null) {
            return;
        }
        BeanUtils.copyProperties(user, this);
        String associationIds = user.getAssociationIds();
        if (Utils.isNotBlank(associationIds)) {
            String[] split = associationIds.split(",");
            List<InfoBO> infoBOList = this.getAssociationIds();
            for (String str : split) {
                InfoBO infoBO = infoService.getById(str);
                if (infoBO != null) {
                    infoBOList.add(infoBO);
                }
            }
        }
        String roleId = user.getRoleId();
        if (Utils.isNotBlank(roleId)) {
            RoleBO role = roleService.getById(roleId);
            this.setRole(role);
        }
    }
}