package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sm.po.Post;
import com.sm.service.*;
import com.sm.util.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostBO {
    private String id;

    private String content;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private UserBO author;

    private List<TopicBO> topics = new ArrayList<>();

    private String[] imgPaths;

    private List<UpBO> ups = new ArrayList<>();

    private List<CommentBO> comments = new ArrayList<>();

    public PostBO() {

    }

    public PostBO(Post post, UserService userService, UpService upService, TopicService topicService, CommentService commentService) {
        parse(post, userService, upService, topicService, commentService);
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

    public List<TopicBO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicBO> topics) {
        this.topics = topics;
    }

    public String[] getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(String[] imgPaths) {
        this.imgPaths = imgPaths;
    }

    public List<UpBO> getUps() {
        return ups;
    }

    public void setUps(List<UpBO> ups) {
        this.ups = ups;
    }

    public List<CommentBO> getComments() {
        return comments;
    }

    public void setComments(List<CommentBO> comments) {
        this.comments = comments;
    }

    private void parse(Post post, UserService userService, UpService upService, TopicService topicService, CommentService commentService) {
        if (post == null) {
            return;
        }
        BeanUtils.copyProperties(post, this);
        if (StringUtils.isNotBlank(post.getImgPaths())) {
            this.imgPaths = post.getImgPaths().split(",");
        }
        UserBO users = userService.getById(post.getAuthorId());
        this.author = users;
        List<UpBO> ups = upService.getByPostId(post.getId());
        this.ups = ups;
        this.comments = commentService.getByPage(post.getId());
        String[] topicIds = {};
        if (StringUtils.isNotBlank(post.getTopicIds())) {
            topicIds = post.getTopicIds().split(",");
        }
        for (String topicId : topicIds) {
            this.topics.add(topicService.getById(topicId));
        }
    }
}