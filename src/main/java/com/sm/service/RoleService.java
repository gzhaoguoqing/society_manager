package com.sm.service;

import com.sm.bo.RoleBO;
import com.sm.po.Role;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface RoleService {
    public void add(Role role);

    public void deleteByIds(List<String> ids);

    public void updateById(Role role);

    public RoleBO getById(String id);

    public List<RoleBO> getByPage(QueryEntry qry);
}
