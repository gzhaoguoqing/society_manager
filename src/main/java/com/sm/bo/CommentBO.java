package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sm.po.Comment;
import com.sm.service.PostService;
import com.sm.service.UserService;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CommentBO {
    private String id;

    private String content;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private UserBO author;

    private String postId;

    public CommentBO() {

    }

    public CommentBO(Comment comment, UserService userService) {
        parse(comment, userService);
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void parse(Comment comment, UserService userService) {
        if (comment == null) {
            return;
        }
        BeanUtils.copyProperties(comment, this);
        UserBO userBO = userService.getById(comment.getAuthorId());
        this.author = userBO;
    }
}