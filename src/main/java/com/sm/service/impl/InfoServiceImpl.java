package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.InfoBO;
import com.sm.client.InfoExample;
import com.sm.dao.InfoMapper;
import com.sm.po.Info;
import com.sm.service.InfoService;
import com.sm.service.UserService;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private UserService userService;

    @Override
    public void add(Info info) {
        infoMapper.insert(info);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        InfoExample example = new InfoExample();
        example.createCriteria().andIdIn(ids);
        infoMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Info info) {
        infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public InfoBO getById(String id, boolean isContainCharity) {
        return new InfoBO(infoMapper.selectByPrimaryKey(id), userService, isContainCharity);
    }

    @Override
    public List<InfoBO> getByPage(QueryEntry qry) {
        if (qry != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        List<Info> infos = infoMapper.selectByExample(null);
        List<InfoBO> infoBOs = new ArrayList<>();
        for (Info info : infos) {
            infoBOs.add(new InfoBO(info, userService, true));
        }
        return infoBOs;
    }

    @Override
    public long getCount() {
        return infoMapper.countByExample(null);
    }
}
