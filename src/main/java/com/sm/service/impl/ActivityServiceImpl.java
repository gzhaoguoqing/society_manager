package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sm.bo.ActivityBO;
import com.sm.client.ActivityExample;
import com.sm.dao.ActivityMapper;
import com.sm.po.Activity;
import com.sm.service.ActivityService;
import com.sm.service.UserService;
import com.sm.vo.QueryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserService userService;

    @Override
    public void add(Activity activity) {
        activityMapper.insert(activity);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        ActivityExample example = new ActivityExample();
        example.createCriteria().andIdIn(ids);
        activityMapper.deleteByExample(example);
    }

    @Override
    public void updateById(Activity activity) {
        activityMapper.updateByPrimaryKeySelective(activity);
    }

    @Override
    public ActivityBO getById(String id) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        if (activity != null && activity.getApplyStartTime().getTime() == activity.getApplyEndTime().getTime()) {
            activity.setApplyStartTime(null);
            activity.setApplyEndTime(null);
        }
        return new ActivityBO(activity, userService);
    }

    @Override
    public List<ActivityBO> getByPage(QueryEntry qry) {
        if (qry.getPage() != null && qry.getSize() != null) {
            PageHelper.startPage(qry.getPage(), qry.getSize());
        }
        ActivityExample example = new ActivityExample();
        example.setOrderByClause("apply_start_time_ desc");
        List<Activity> activities = activityMapper.selectByExample(example);
        ArrayList<ActivityBO> activityBOS = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.getApplyStartTime().getTime() == activity.getApplyEndTime().getTime()) {
                activity.setApplyStartTime(null);
                activity.setApplyEndTime(null);
            }
            activityBOS.add(new ActivityBO(activity, userService));
        }
        return activityBOS;
    }

    @Override
    public long getCount() {
        return activityMapper.countByExample(null);
    }
}
