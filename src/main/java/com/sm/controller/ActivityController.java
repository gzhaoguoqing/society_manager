package com.sm.controller;

import com.sm.bo.ActivityBO;
import com.sm.bo.UserBO;
import com.sm.po.Activity;
import com.sm.service.ActivityService;
import com.sm.util.StringUtils;
import com.sm.util.Utils;
import com.sm.vo.ActivityQuery;
import com.sm.vo.Applicant;
import com.sm.vo.QueryEntry;
import com.sm.vo.ResultEntry;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
    public ResultEntry<List<ActivityBO>> list(ActivityQuery qry) {
        ResultEntry<List<ActivityBO>> result = new ResultEntry<>();
        result.setTotal(activityService.getCount(qry));
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
        if (loginedUser.getAssociations() != null && loginedUser.getAssociations().size() > 0) {
            activity.setAssociationId(loginedUser.getAssociations().get(0).getId());
        }
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

    @GetMapping("/applicant/export/{activityId}")
    public byte[] export(HttpServletResponse response, @PathVariable String activityId) throws IOException {
        String[] header = new String[] {"学号", "姓名", "性别", "班级", "电话"};
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(header);
        File file = new File(Utils.getTempDir() + "/export/报名信息.csv");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
        List<Applicant> participantors = activityService.getById(activityId).getParticipantors();
        for (Applicant applicant : participantors) {
            ArrayList<String> record = new ArrayList<>();
            record.add(applicant.getNumber());
            record.add(applicant.getName());
            record.add(applicant.getSex()==0 ? "男" : "女");
            record.add(applicant.getClasses());
            record.add(applicant.getPhone());
            csvPrinter.printRecord(record);
        }
        csvPrinter.flush();
        fileWriter.close();
        csvPrinter.close();

        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(file.getName(), "utf-8"));
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}
