package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.UserBO;
import com.sm.client.UserExample;
import com.sm.dao.InfoMapper;
import com.sm.dao.RoleMapper;
import com.sm.dao.UserMapper;
import com.sm.po.Role;
import com.sm.po.User;
import com.sm.service.InfoService;
import com.sm.service.RoleService;
import com.sm.service.UserService;
import com.sm.util.StringUtils;
import com.sm.util.Utils;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private InfoService infoService;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public void add(User user) {
        userMapper.insert(user);
        Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
    }

    @Override
    public void deleteByIds(List<String> ids) {
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(ids);
        userMapper.deleteByExample(example);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional
    public void resetPwd(List<String> ids) {
        for (String id : ids) {
            User dbUser = userMapper.selectByPrimaryKey(id);
            dbUser.setPassword(Utils.md5(dbUser.getNumber()));
            userMapper.updateByPrimaryKey(dbUser);
        }
    }

    @Override
    public UserBO getById(String id) {
        return new UserBO(userMapper.selectByPrimaryKey(id), infoService, roleService);
    }

    @Override
    public UserBO getByNumber(String number) {
        UserExample example = new UserExample();
        example.createCriteria().andNumberEqualTo(number);
        List<User> users = userMapper.selectByExample(example);
        return new UserBO(users.isEmpty() ? null : users.get(0), infoService, roleService);
    }

    @Override
    public List<UserBO> getByPage(QueryEntry qry, String infoId) {
        if (qry != null && qry.getPage() != null && qry.getSize() != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        UserExample example = new UserExample();
        example.setOrderByClause("number_");
        if (StringUtils.isNotBlank(infoId)) {
            example.createCriteria().andAssociationIdsLike(infoId);
        }
        List<User> users = userMapper.selectByExample(example);
        List<UserBO> userBOs = new ArrayList<>();
        for (User user : users) {
            userBOs.add(new UserBO(user, infoService, roleService));
        }
        return userBOs;
    }

    @Override
    public long getCount(String infoId) {
        UserExample example = new UserExample();
        if (StringUtils.isNotBlank(infoId)) {
            example.createCriteria().andAssociationIdsLike(infoId);
        }
        return userMapper.countByExample(example);
    }
}
