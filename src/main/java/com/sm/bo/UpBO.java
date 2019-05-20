package com.sm.bo;

import com.sm.po.Up;
import com.sm.service.UserService;

public class UpBO {
    private UserBO author;

    private String postId;

    public UpBO() {

    }

    public UpBO(Up up, UserService userService) {
        parse(up, userService);
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
        this.postId = postId == null ? null : postId.trim();
    }

    public void parse(Up up, UserService userService) {
        if (up == null) {
            return;
        }
        this.postId = up.getPostId();
        UserBO userBO = userService.getById(up.getAuthorId());
        this.author = userBO;
    }
}