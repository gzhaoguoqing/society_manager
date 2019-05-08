package com.sm.bo;

import com.sm.po.Info;
import com.sm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

public class InfoBO {
    private String id;

    private String name;

    private String info;

    private UserBO charity;

    public InfoBO() {

    }

    public InfoBO(Info info, UserService userService) {
        parse(info, userService);
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public UserBO getCharity() {
        return charity;
    }

    public void setCharityId(UserBO charity) {
        this.charity = charity;
    }

    public void parse(Info info, UserService userService) {
        if (info == null) {
            return;
        }
        BeanUtils.copyProperties(info, this);
        UserBO charity = userService.getById(info.getCharityId());
        this.charity = charity;
    }
}