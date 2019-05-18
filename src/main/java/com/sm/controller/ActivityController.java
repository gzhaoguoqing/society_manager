package com.sm.controller;

import com.sm.bo.ActivityBO;
import com.sm.bo.UserBO;
import com.sm.po.Activity;
import com.sm.service.ActivityService;
import com.sm.util.StringUtils;
import com.sm.util.Utils;
import com.sm.vo.Applicant;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    public ResultEntry<List<ActivityBO>> list(QueryEntry qry) {
        ResultEntry<List<ActivityBO>> result = new ResultEntry<>();
        result.setTotal(activityService.getCount());
        result.setData(activityService.getByPage(qry));
        return result;
    }

    @GetMapping("/{id}")
    public ResultEntry<ActivityBO> getById(@PathVariable String id) {
        ResultEntry<ActivityBO> result = new ResultEntry<>();
        result.setData(activityService.getById(id));
        return result;
    }

    @PostMapping
    public ResultEntry add(@RequestBody Activity activity) {
        UserBO loginedUser = (UserBO) SecurityUtils.getSubject().getPrincipal();
        activity.setAuthorId(loginedUser.getId());
        activity.setId(Utils.getUUID());
        activityService.add(activity);
        return new ResultEntry();
    }

    @DeleteMapping("/{ids}")
    public ResultEntry delete(@PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        activityService.deleteByIds(Arrays.asList(ids.split(",")));
        return new ResultEntry();
    }

    @PutMapping
    public ResultEntry update(@RequestBody Activity activity) {
        activityService.updateById(activity);
        return new ResultEntry();
    }

    @GetMapping("/applicant/{activityId}")
    public ResultEntry getApplicants(@PathVariable String activityId) {
        ResultEntry<List<Applicant>> result = new ResultEntry<>();
        result.setData(activityService.getById(activityId).getParticipantors());
        return result;
    }

    @PostMapping("/applicant")
    public ResultEntry apply(@RequestBody Applicant applicant) {
        ActivityBO activityBO = activityService.getById(applicant.getActivityId());
        List<Applicant> participantors = activityBO.getParticipantors();
        participantors.add(applicant);
        List<String> participantorStrList = new ArrayList<>();
        for (Applicant ap : participantors) {
            participantorStrList.add(Utils.getUUID() + "," + ap.getNumber() + "," + ap.getName() + ',' + ap.getSex()
                    + "," + ap.getClasses() + "," + ap.getPhone());
        }
        Activity activity = new Activity();
        activity.setId(activityBO.getId());
        activity.setParticipantors(StringUtils.join(participantorStrList, ";"));
        activityService.updateById(activity);
        return new ResultEntry();
    }

    @DeleteMapping("/applicant/{ids}")
    public ResultEntry deleteApplicant(String activityId, @PathVariable String ids) throws UnsupportedEncodingException {
        ids = URLDecoder.decode(ids, "utf-8");
        ActivityBO activityBO = activityService.getById(activityId);
        List<Applicant> applicantList = activityBO.getParticipantors();
        for (String id : ids.split(",")) {
            Iterator<Applicant> it = applicantList.iterator();
            while (it.hasNext()) {
                if (it.next().getId().equals(id)) {
                    it.remove();
                }
            }
        }
        List<String> participantorStrList = new ArrayList<>();
        for (Applicant ap : applicantList) {
            participantorStrList.add(ap.getId() + "," + ap.getNumber() + "," + ap.getName() + ',' + ap.getSex()
                    + "," + ap.getClasses() + "," + ap.getPhone());
        }
        Activity activity = new Activity();
        activity.setId(activityBO.getId());
        activity.setParticipantors(StringUtils.join(participantorStrList, ";"));
        activityService.updateById(activity);
        return new ResultEntry();
    }

    @PutMapping("/applicant")
    public ResultEntry updateApplicant(@RequestBody Applicant applicant) {
        ActivityBO activityBO = activityService.getById(applicant.getActivityId());
        List<Applicant> applicantList = activityBO.getParticipantors();
        for (Applicant apt : applicantList) {
            if (apt.getId().equals(applicant.getId())) {
                BeanUtils.copyProperties(applicant, apt);
                break;
            }
        }
        List<String> participantorStrList = new ArrayList<>();
        for (Applicant ap : applicantList) {
            participantorStrList.add(ap.getId() + "," + ap.getNumber() + "," + ap.getName() + ',' + ap.getSex()
                    + "," + ap.getClasses() + "," + ap.getPhone());
        }
        Activity activity = new Activity();
        activity.setId(activityBO.getId());
        activity.setParticipantors(StringUtils.join(participantorStrList, ";"));
        activityService.updateById(activity);
        return new ResultEntry();
    }
}
