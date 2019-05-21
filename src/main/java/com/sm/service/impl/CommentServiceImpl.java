package com.sm.service.impl;

import com.sm.bo.CommentBO;
import com.sm.client.CommentExample;
import com.sm.dao.CommentMapper;
import com.sm.po.Comment;
import com.sm.service.CommentService;
import com.sm.service.PostService;
import com.sm.service.UserService;
import com.sm.vo.CommentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;

    @Override
    public void add(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        CommentExample example = new CommentExample();
        example.createCriteria().andIdIn(ids);
        commentMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public CommentBO getById(String id) {
        return new CommentBO(commentMapper.selectByPrimaryKey(id), userService);
    }

    @Override
    public List<CommentBO> getByPage(String postId) {
        CommentExample example = new CommentExample();
        example.createCriteria().andPostIdEqualTo(postId);
        example.setOrderByClause("date_ asc");
        List<Comment> comments = commentMapper.selectByExample(example);
        List<CommentBO> commentBOList = new ArrayList<>();
        for (Comment comment : comments) {
            commentBOList.add(new CommentBO(comment, userService));
        }
        return commentBOList;
    }

    @Override
    public long getCount(String postId) {
        CommentExample example = new CommentExample();
        example.createCriteria().andPostIdEqualTo(postId);
        return commentMapper.countByExample(example);
    }
}
