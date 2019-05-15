package com.sm.service;

import com.sm.bo.UserBO;
import com.sm.po.User;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface UserService {
    public void add(User user);

    public void deleteByIds(List<String> ids);

    public void updateById(User user);

    public void resetPwd(List<String> ids);

    public UserBO getById(String id);

    public UserBO getByNumber(String number);

    public List<UserBO> getByPage(QueryEntry qry, String infoId);

    public long getCount(String infoId);
}
