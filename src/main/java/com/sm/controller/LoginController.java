package com.sm.controller;

import com.sm.bo.UserBO;
import com.sm.service.UserService;
import com.sm.util.Utils;
import com.sm.vo.ResultEntry;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api"))
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultEntry<UserBO> login(String number, String password) {
        ResultEntry<UserBO> result = new ResultEntry<>();
        UsernamePasswordToken token = new UsernamePasswordToken(number, Utils.md5(password));
        try {
            SecurityUtils.getSubject().login(token);
            result.setData((UserBO) SecurityUtils.getSubject().getPrincipal());
        } catch (Exception e) {
            result.setCode(ResultEntry.LOGIN_ERROR);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @PostMapping("/logout")
    public ResultEntry<String> logout() {
        ResultEntry<String> result = new ResultEntry<>();
        SecurityUtils.getSubject().logout();
        return result;
    }

    @PostMapping("/login/user")
    public ResultEntry<UserBO> getLoginUser() {
        ResultEntry<UserBO> result = new ResultEntry<>();
        result.setData((UserBO) SecurityUtils.getSubject().getPrincipal());
        return result;
    }

}
