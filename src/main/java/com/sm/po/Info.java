package com.sm.po;

public class Info {
    private String id;

    private String name;

    private String info;

    private String charityId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getCharityId() {
        return charityId;
    }

    public void setCharityId(String charityId) {
        this.charityId = charityId == null ? null : charityId.trim();
    }
}