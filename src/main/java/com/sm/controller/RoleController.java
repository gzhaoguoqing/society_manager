package com.sm.controller;

import com.sm.bo.RoleBO;
import com.sm.po.Role;
import com.sm.service.RoleService;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResultEntry<List<RoleBO>> list(QueryEntry qry) {
        ResultEntry<List<RoleBO>> result = new ResultEntry<>();
        result.setData(roleService.getByPage(qry));
        return result;
    }

    @PostMapping
    public ResultEntry add(Role role) {
        roleService.add(role);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(String ids) {
        roleService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(Role role) {
        roleService.updateById(role);
        return new ResultEntry();
    }
}
