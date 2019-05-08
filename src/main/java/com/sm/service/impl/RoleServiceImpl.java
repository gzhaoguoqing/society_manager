package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.RoleBO;
import com.sm.client.RoleExample;
import com.sm.dao.RoleMapper;
import com.sm.po.Role;
import com.sm.service.PermissionService;
import com.sm.service.RoleService;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionService permissionService;

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdIn(ids);
        roleMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public RoleBO getById(String id) {
        return new RoleBO(roleMapper.selectByPrimaryKey(id), permissionService);
    }

    @Override
    public List<RoleBO> getByPage(QueryEntry qry) {
        PageHelper.startPage(qry.getPage(), qry.getSize());
        List<Role> roles = roleMapper.selectByExample(null);
        List<RoleBO> roleBOs = new ArrayList<>();
        for (Role role : roles) {
            roleBOs.add(new RoleBO(role, permissionService));
        }
        return roleBOs;
    }
}
