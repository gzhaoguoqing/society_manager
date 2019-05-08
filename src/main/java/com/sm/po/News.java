package com.sm.po;

import java.util.Date;

public class News {
    private String id;

    private String title;

    private String content;

    private Date date;

    private String authorId;

    private Integer clicks;

    private Integer important;

    private String importantImgPath;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getImportant() {
        return important;
    }

    public void setImportant(Integer important) {
        this.important = important;
    }

    public String getImportantImgPath() {
        return importantImgPath;
    }

    public void setImportantImgPath(String importantImgPath) {
        this.importantImgPath = importantImgPath == null ? null : importantImgPath.trim();
    }
}