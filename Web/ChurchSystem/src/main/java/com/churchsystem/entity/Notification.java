package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
public class Notification {
    private String content;
    private int type;
    private String link;

    public Notification() {
    }

    public Notification(String content, int type, String link) {
        this.content = content;
        this.type = type;
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
