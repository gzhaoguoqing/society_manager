package com.sm.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.util.StringUtil;
import com.sm.po.News;
import com.sm.po.Notice;
import com.sm.service.InfoService;
import com.sm.service.UserService;
import com.sm.util.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class NoticeBO {
    private String id;

    private String title;

    private String content;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private UserBO author;

    private String[] filePaths;

    private InfoBO association;

    public NoticeBO() {

    }

    public NoticeBO(Notice notice, UserService userService, InfoService infoService) {
        parse(notice, userService, infoService);
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

    public String[] getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String[] filePaths) {
        this.filePaths = filePaths;
    }

    public InfoBO getAssociation() {
        return association;
    }

    public void setAssociation(InfoBO association) {
        this.association = association;
    }

    public void parse(Notice notice, UserService userService, InfoService infoService) {
        if (notice == null) {
            return;
        }
        BeanUtils.copyProperties(notice, this);
        this.author = userService.getById(notice.getAuthorId());
        if (notice.getFilePaths() != null && StringUtils.isNotBlank(notice.getFilePaths())) {
            this.filePaths = notice.getFilePaths().split(",");
        }
        if (StringUtil.isNotEmpty(notice.getAssociationId())) {
            this.association = infoService.getById(notice.getAssociationId(), false);
        }
    }
}