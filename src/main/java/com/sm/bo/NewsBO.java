package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sm.po.News;
import com.sm.po.User;
import com.sm.service.UserService;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class NewsBO {
    private String id;

    private String title;

    private String content;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private UserBO author;

    private Integer clicks;

    private Integer important;

    private String importantImgPath;

    public NewsBO() {

    }

    public NewsBO(News news, UserService userService) {
        parse(news, userService);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserBO getAuthor() {
        return author;
    }

    public void setAuthor(UserBO author) {
        this.author = author;
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

    public void parse(News news, UserService userService) {
        if (news == null) {
            return;
        }
        BeanUtils.copyProperties(news, this);
        this.author = userService.getById(news.getAuthorId());
    }
}