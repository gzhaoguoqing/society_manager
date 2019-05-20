package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.TopicBO;
import com.sm.client.TopicExample;
import com.sm.dao.TopicMapper;
import com.sm.po.Topic;
import com.sm.service.PostService;
import com.sm.service.TopicService;
import com.sm.service.UserService;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Override
    public void add(Topic topic) {
        topicMapper.insert(topic);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        TopicExample example = new TopicExample();
        example.createCriteria().andIdIn(ids);
        topicMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Topic topic) {
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public TopicBO getById(String id) {
        return new TopicBO(topicMapper.selectByPrimaryKey(id), userService, postService);
    }

    @Override
    public List<TopicBO> getByPage(QueryEntry qry) {
        if (qry.getPage() != null && qry.getSize() != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        TopicExample example = new TopicExample();
        example.setOrderByClause("date_ desc");
        List<Topic> topicList = topicMapper.selectByExample(example);
        List<TopicBO> topicBOList = new ArrayList<>();
        for (Topic topic : topicList) {
            topicBOList.add(new TopicBO(topic, userService, postService));
        }
        return topicBOList;
    }

    @Override
    public long getCount() {
        return topicMapper.countByExample(null);
    }
}
