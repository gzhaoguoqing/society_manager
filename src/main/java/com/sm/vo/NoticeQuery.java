package com.sm.vo;

public class NoticeQuery extends QueryEntry {
    private String title;

    private String associationId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssociationId() {
        return associationId;
    }

    public void setAssociationId(String associationId) {
        this.associationId = associationId;
    }
}
