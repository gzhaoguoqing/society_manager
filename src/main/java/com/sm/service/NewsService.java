package com.sm.service;

import com.sm.bo.NewsBO;
import com.sm.po.News;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface NewsService {
    public void add(News news);

    public void deleteByIds(List<String> ids);

    public void updateById(News news);

    public NewsBO getById(String id);

    public List<NewsBO> getByPage(QueryEntry qry);

    public List<NewsBO> getImportant(Integer size);

    public long getCount();
}
