package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.PermissionBO;
import com.sm.client.PermissionExample;
import com.sm.dao.PermissionMapper;
import com.sm.po.Permission;
import com.sm.service.PermissionService;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImp implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void add(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andIdIn(ids);
        permissionMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public PermissionBO getById(String id) {
        return new PermissionBO(permissionMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<PermissionBO> getByPage(QueryEntry qry) {
        if (qry != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        List<Permission> permissions = permissionMapper.selectByExample(null);
        List<PermissionBO> permissionBOs = new ArrayList<>();
        for (Permission permission : permissions) {
            permissionBOs.add(new PermissionBO(permission));
        }
        return permissionBOs;
    }
}
