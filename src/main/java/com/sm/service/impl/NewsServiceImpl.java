package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.NewsBO;
import com.sm.client.NewsExample;
import com.sm.dao.NewsMapper;
import com.sm.po.News;
import com.sm.service.NewsService;
import com.sm.service.UserService;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public void add(News news) {
        mapper.insert(news);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        NewsExample example = new NewsExample();
        example.createCriteria().andIdIn(ids);
        mapper.deleteByExample(example);
    }

    @Override
    public void updateById(News news) {
        mapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public NewsBO getById(String id) {
        return new NewsBO(mapper.selectByPrimaryKey(id), userService);
    }

    @Override
    public List<NewsBO> getByPage(QueryEntry qry) {
        if (qry != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        List<News> newses = mapper.selectByExample(null);
        ArrayList<NewsBO> newsBOs = new ArrayList<>();
        for (News news : newses) {
            newsBOs.add(new NewsBO(news, userService));
        }
        return newsBOs;
    }

    @Override
    public long getCount() {
        return mapper.countByExample(null);
    }
}
