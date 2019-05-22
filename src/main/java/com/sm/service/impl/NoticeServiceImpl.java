package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.NoticeBO;
import com.sm.client.NoticeExample;
import com.sm.dao.NoticeMapper;
import com.sm.po.Notice;
import com.sm.service.InfoService;
import com.sm.service.NoticeService;
import com.sm.service.UserService;
import com.sm.util.StringUtils;
import com.sm.vo.NoticeQuery;
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

    @Autowired
    private InfoService infoService;

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
        return new NoticeBO(noticeMapper.selectByPrimaryKey(id), userService, infoService);
    }

    @Override
    public List<NoticeBO> getByPage(NoticeQuery qry) {
        if (qry.getPage() != null && qry.getSize() != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        qry.setOrderByClause("date_ desc");
        List<Notice> notices = noticeMapper.selectByQuery(qry);
        ArrayList<NoticeBO> noticeBOS = new ArrayList<>();
        for (Notice notice : notices) {
            noticeBOS.add(new NoticeBO(notice, userService, infoService));
        }
        return noticeBOS;
    }

    @Override
    public long getCount(NoticeQuery qry) {
        return noticeMapper.countByQuery(qry);
    }
}
