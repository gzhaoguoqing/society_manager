package com.sm.service;

import com.sm.bo.NoticeBO;
import com.sm.po.Notice;
import com.sm.vo.NoticeQuery;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface NoticeService {
    public void add(Notice notice);

    public void deleteByIds(List<String> ids);

    public void updateById(Notice notice);

    public NoticeBO getById(String id);

    public List<NoticeBO> getByPage(NoticeQuery qry);

    public long getCount(NoticeQuery qry);
}
