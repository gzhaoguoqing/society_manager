package com.sm.service;

import com.sm.bo.ActivityBO;
import com.sm.bo.InfoBO;
import com.sm.po.Activity;
import com.sm.po.Info;
import com.sm.vo.ActivityQuery;
import com.sm.vo.QueryEntry;

import java.util.List;

public interface ActivityService {
    public void add(Activity activity);

    public void deleteByIds(List<String> ids);

    public void updateById(Activity activity);

    public ActivityBO getById(String id);

    public List<ActivityBO> getByPage(ActivityQuery qry);

    public long getCount(ActivityQuery qry);
}
