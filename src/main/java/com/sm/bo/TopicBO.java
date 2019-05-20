package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sm.po.Topic;
import com.sm.service.PostService;
import com.sm.service.UserService;
import com.sm.util.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class TopicBO {
    private String id;

    private String content;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private UserBO author;

    private String labels;

    private Long postNum;

    public TopicBO() {

    }

    public TopicBO(Topic topic, UserService userService, PostService postService) {
        parse(topic, userService, postService);
    }

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

    public UserBO getAuthor() {
        return author;
    }

    public void setAuthor(UserBO author) {
        this.author = author;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Long getPostNum() {
        return postNum;
    }

    public void setPostNum(Long postNum) {
        this.postNum = postNum;
    }

    public void parse(Topic topic, UserService userService, PostService postService) {
        if (topic == null) {
            return;
        }
        BeanUtils.copyProperties(topic, this);
        UserBO userBO = userService.getById(topic.getAuthorId());
        this.author = userBO;
        this.postNum = postService.getCount(topic.getId());
    }
}