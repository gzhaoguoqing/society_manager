package com.sm.service;

import com.sm.bo.UpBO;
import com.sm.po.Up;

import java.util.List;

public interface UpService {
    public void add(Up up);

    public List<UpBO> getByPostId(String postId);
}
