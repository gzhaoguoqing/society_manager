package com.sm.service;

import com.sm.bo.PermissionBO;
import com.sm.po.Permission;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface PermissionService {
    public void add(Permission permission);

    public void deleteByIds(List<String> ids);

    public void updateById(Permission permission);

    public PermissionBO getById(String id);

    public List<PermissionBO> getByPage(QueryEntry qry);
}
