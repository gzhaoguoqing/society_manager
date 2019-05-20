package com.sm.service;

import com.sm.bo.InfoBO;
import com.sm.bo.TopicBO;
import com.sm.po.Info;
import com.sm.po.Topic;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface TopicService {
    public void add(Topic topic);

    public void deleteByIds(List<String> ids);

    public void updateById(Topic topic);

    public TopicBO getById(String id);

    public List<TopicBO> getByPage(QueryEntry qry);

    public long getCount();
}
