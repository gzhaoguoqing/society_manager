package com.sm.controller;

import com.sm.bo.UserBO;
import com.sm.po.User;
import com.sm.service.UserService;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
        result.setData(userService.getByPage(qry, infoId));
        return result;
    }

    @PostMapping
    public ResultEntry add(User user) {
        userService.add(user);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable String ids) {
        userService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(User user) {
        userService.updateById(user);
        return new ResultEntry();
    }
}
