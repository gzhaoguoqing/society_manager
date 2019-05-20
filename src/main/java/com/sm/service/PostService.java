package com.sm.service;

import com.sm.bo.InfoBO;
import com.sm.bo.PostBO;
import com.sm.po.Info;
import com.sm.po.Post;
import com.sm.vo.PostQuery;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface PostService {
    public void add(Post post);

    public void deleteByIds(List<String> ids);

    public void updateById(Post post);

    public PostBO getById(String id);

    public List<PostBO> getByPage(PostQuery qry);

    public long getCount(String topicId);
}
