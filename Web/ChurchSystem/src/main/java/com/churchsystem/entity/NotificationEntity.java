package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hungmcse61561-admin on 7/11/2017.
 */
@Entity
@Table(name = "notification", schema = "churchsys", catalog = "")
public class NotificationEntity {
    private int notificationId;
    private Integer userId;
    private Integer type;
    private String information;
    private String link;
    private Timestamp time;

    @Id
    @Column(name = "notificationId")
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificationEntity that = (NotificationEntity) o;

        if (notificationId != that.notificationId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = notificationId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
