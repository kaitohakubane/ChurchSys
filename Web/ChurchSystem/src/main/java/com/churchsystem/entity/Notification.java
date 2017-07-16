package com.churchsystem.entity;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;

import java.sql.Timestamp;

/**
 * Created by hungmcse61561-admin on 7/16/2017.
 */
public class Notification {

    private String avatar;
    private String sender;
    private String information;
    private String link;
    private String time;

    public Notification(String avatar, String sender, String information, String link, String time) {
        this.avatar = avatar;
        this.sender = sender;
        this.information = information;
        this.link = link;
        this.time = time;
    }

    public Notification(NotificationEntity entity){
        this.avatar=entity.getAvatar();
        this.sender=entity.getSender();
        this.information=entity.getInformation();
        if(entity.getType()== ParamConstant.YOUTUBE_TYPE){
            this.link= PageConstant.ROOT_PATH_URL+"?"+ParamConstant.STREAM_LINK+"="+entity.getLink();
        }else{
            this.link=entity.getLink();
        }
        this.time=entity.getTime().toString();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
