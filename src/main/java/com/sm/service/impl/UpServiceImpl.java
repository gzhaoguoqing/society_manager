package com.sm.service.impl;

import com.sm.bo.UpBO;
import com.sm.client.UpExample;
import com.sm.dao.UpMapper;
import com.sm.po.Up;
import com.sm.service.UpService;
import com.sm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpServiceImpl implements UpService {
    @Autowired
    private UpMapper upMapper;

    @Autowired
    private UserService userService;

    @Override
    public void add(Up up) {
        upMapper.insert(up);
    }

    @Override
    public List<UpBO> getByPostId(String postId) {
        UpExample example = new UpExample();
        example.createCriteria().andPostIdEqualTo(postId);
        List<Up> ups = upMapper.selectByExample(example);
        List<UpBO> upBOList = new ArrayList<>();
        for (Up up : ups) {
            upBOList.add(new UpBO(up, userService));
        }
        return upBOList;
    }

    @Override
    public boolean existUp(Up up) {
        UpExample example = new UpExample();
        example.createCriteria().andPostIdEqualTo(up.getPostId()).andAuthorIdEqualTo(up.getAuthorId());
        long count = upMapper.countByExample(example);
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }
}
