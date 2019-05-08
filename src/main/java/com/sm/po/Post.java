package com.sm.po;

import java.util.Date;

public class Post {
    private String id;

    private String content;

    private Date date;

    private String authorId;

    private String topicIds;

    private String imgPaths;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(String topicIds) {
        this.topicIds = topicIds == null ? null : topicIds.trim();
    }

    public String getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(String imgPaths) {
        this.imgPaths = imgPaths == null ? null : imgPaths.trim();
    }
}