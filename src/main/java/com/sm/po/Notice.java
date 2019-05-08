package com.sm.po;

import java.util.Date;

public class Notice {
    private String id;

    private String title;

    private String content;

    private Date date;

    private String authorId;

    private String filePaths;

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

    public String getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String filePaths) {
        this.filePaths = filePaths == null ? null : filePaths.trim();
    }
}