package com.sm.po;

import java.util.Date;

public class Activity {
    private String id;

    private String title;

    private String content;

    private String authorId;

    private String filePaths;

    private String participantors;

    private Integer applyUp;

    private Date applyStartTime;

    private Date applyEndTime;

    private String labels;

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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public String getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String filePaths) {
        this.filePaths = filePaths == null ? null : filePaths.trim();
    }

    public String getParticipantors() {
        return participantors;
    }

    public void setParticipantors(String participantors) {
        this.participantors = participantors == null ? null : participantors.trim();
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

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels == null ? null : labels.trim();
    }
}