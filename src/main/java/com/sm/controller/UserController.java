package com.sm.controller;

import com.sm.bo.UserBO;
import com.sm.po.User;
import com.sm.service.UserService;
import com.sm.util.Utils;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResultEntry<List<UserBO>> list(QueryEntry qry, @RequestParam(value="infoId", required = false) String infoId) {
        ResultEntry<List<UserBO>> result = new ResultEntry<>();
        result.setTotal(userService.getCount(infoId));
        result.setData(userService.getByPage(qry, infoId));
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody User user) {
        user.setId(Utils.getUUID());
        user.setPassword(Utils.md5(user.getNumber()));
        userService.add(user);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        userService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody User user) {
        userService.updateById(user);
        return new ResultEntry();
    }

    @PutMapping("/{ids}")
    public ResultEntry resetPwd(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        userService.resetPwd(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }
}
