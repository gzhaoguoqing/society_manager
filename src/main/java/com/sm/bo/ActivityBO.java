package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sm.po.Activity;
import com.sm.service.UserService;
import com.sm.util.StringUtils;
import com.sm.vo.Applicant;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityBO {
    private String id;

    private String title;

    private String content;

    private UserBO author;

    private String[] filePaths;

    private List<Applicant> participantors = new ArrayList<>();

    private Integer applyUp;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyStartTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyEndTime;

    private String[] labels;

    public ActivityBO() {

    }

    public ActivityBO(Activity activity, UserService userService) {
        parse(activity, userService);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public UserBO getAuthor() {
        return author;
    }

    public void setAuthor(UserBO author) {
        this.author = author;
    }

    public String[] getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String[] filePaths) {
        this.filePaths = filePaths;
    }

    public List<Applicant> getParticipantors() {
        return participantors;
    }

    public void setParticipantors(List<Applicant> participantors) {
        this.participantors = participantors;
    }

    public Integer getApplyUp() {
        return applyUp;
    }

    public void setApplyUp(Integer applyUp) {
        this.applyUp = applyUp;
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public void parse(Activity activity, UserService userService) {
        if (activity == null) {
            return;
        }
        BeanUtils.copyProperties(activity, this);
        this.author = userService.getById(activity.getAuthorId());
        if (StringUtils.isNotBlank(activity.getFilePaths())) {
            this.filePaths = activity.getFilePaths().split(",");
        }
        if (StringUtils.isNotBlank(activity.getParticipantors())) {
            String[] applicants = activity.getParticipantors().split(";");
            for (String str : applicants) {
                String[] prop = str.split(",");
                Applicant applicant = new Applicant();
                applicant.setNumber(prop[0]);
                applicant.setName(prop[1]);
                applicant.setSex(Integer.parseInt(prop[2]));
                applicant.setClasses(prop[3]);
                applicant.setPhone(prop[4]);
                applicant.setActivityId(activity.getId());
                this.participantors.add(applicant);
            }
        }
        if (StringUtils.isNotBlank(activity.getLabels())) {
            this.labels = activity.getLabels().split(",");
        }
    }
}