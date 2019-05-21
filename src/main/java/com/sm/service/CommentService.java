package com.sm.service;

import com.sm.bo.CommentBO;
import com.sm.bo.InfoBO;
import com.sm.po.Comment;
import com.sm.po.Info;
import com.sm.vo.CommentQuery;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface CommentService {
    public void add(Comment comment);

    public void deleteByIds(List<String> ids);

    public void updateById(Comment comment);

    public CommentBO getById(String id);

    public List<CommentBO> getByPage(String postId);

    public long getCount(String postId);
}
