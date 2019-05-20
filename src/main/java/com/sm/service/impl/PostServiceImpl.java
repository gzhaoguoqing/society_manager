package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.PostBO;
import com.sm.client.PostExample;
import com.sm.dao.PostMapper;
import com.sm.po.Post;
import com.sm.service.PostService;
import com.sm.service.TopicService;
import com.sm.service.UpService;
import com.sm.service.UserService;
import com.sm.vo.PostQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UpService upService;

    @Autowired
    private TopicService topicService;

    @Override
    public void add(Post post) {
        postMapper.insert(post);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        PostExample example = new PostExample();
        example.createCriteria().andIdIn(ids);
        postMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Post post) {
        postMapper.updateByPrimaryKeySelective(post);
    }

    @Override
    public PostBO getById(String id) {
        return new PostBO(postMapper.selectByPrimaryKey(id), userService, upService, topicService);
    }

    @Override
    public List<PostBO> getByPage(PostQuery qry) {
        if (qry.getPage() != null && qry.getSize() != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        PostExample example = new PostExample();
        example.createCriteria().andTopicIdsLike(qry.getTopicId());
        List<Post> postList = postMapper.selectByExample(example);
        List<PostBO> postBOList = new ArrayList<>();
        for (Post post : postList) {
            postBOList.add(new PostBO(post, userService, upService, topicService));
        }
        return postBOList;
    }

    @Override
    public long getCount(String topicId) {
        PostExample example = new PostExample();
        example.createCriteria().andTopicIdsLike("%" + topicId + "%");
        return postMapper.countByExample(example);
    }
}
