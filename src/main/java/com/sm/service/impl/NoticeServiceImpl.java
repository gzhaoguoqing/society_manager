package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.NoticeBO;
import com.sm.client.NoticeExample;
import com.sm.dao.NoticeMapper;
import com.sm.po.Notice;
import com.sm.service.NoticeService;
import com.sm.service.UserService;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private UserService userService;

    @Override
    public void add(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        NoticeExample example = new NoticeExample();
        example.createCriteria().andIdIn(ids);
        noticeMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Notice notice) {
        noticeMapper.updateByPrimaryKey(notice);
    }

    @Override
    public NoticeBO getById(String id) {
        return new NoticeBO(noticeMapper.selectByPrimaryKey(id), userService);
    }

    @Override
    public List<NoticeBO> getByPage(QueryEntry qry) {
        if (qry != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        NoticeExample example = new NoticeExample();
        example.setOrderByClause("date_ desc");
        List<Notice> notices = noticeMapper.selectByExample(example);
        ArrayList<NoticeBO> noticeBOS = new ArrayList<>();
        for (Notice notice : notices) {
            noticeBOS.add(new NoticeBO(notice, userService));
        }
        return noticeBOS;
    }

    @Override
    public long getCount() {
        return noticeMapper.countByExample(null);
    }
}
