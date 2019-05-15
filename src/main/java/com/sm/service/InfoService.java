package com.sm.service;

import com.sm.bo.InfoBO;
import com.sm.po.Info;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface InfoService {
    public void add(Info info);

    public void deleteByIds(List<String> ids);

    public void updateById(Info info);

    public InfoBO getById(String id, boolean isContainCharity);

    public List<InfoBO> getByPage(QueryEntry qry);

    public long getCount();
}
