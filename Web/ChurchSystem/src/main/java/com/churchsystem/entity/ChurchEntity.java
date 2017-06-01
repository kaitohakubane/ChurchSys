package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hungmcse61561-admin on 5/31/2017.
 */
@Entity
@Table(name = "church", schema = "churchsys", catalog = "")
public class ChurchEntity {
    private int churchId;
    private String churchName;
    private String longTitude;
    private String tel;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;
    private String lateTitude;
    private String streamLink;
    private Integer streamStatus;

    @Id
    @Column(name = "churchId")
    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "churchName")
    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    @Basic
    @Column(name = "longTitude")
    public String getLongTitude() {
        return longTitude;
    }

    public void setLongTitude(String longTitude) {
        this.longTitude = longTitude;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "startTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "lateTitude")
    public String getLateTitude() {
        return lateTitude;
    }

    public void setLateTitude(String lateTitude) {
        this.lateTitude = lateTitude;
    }

    @Basic
    @Column(name = "streamLink")
    public String getStreamLink() {
        return streamLink;
    }

    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }

    @Basic
    @Column(name = "streamStatus")
    public Integer getStreamStatus() {
        return streamStatus;
    }

    public void setStreamStatus(Integer streamStatus) {
        this.streamStatus = streamStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChurchEntity that = (ChurchEntity) o;

        if (churchId != that.churchId) return false;
        if (churchName != null ? !churchName.equals(that.churchName) : that.churchName != null) return false;
        if (longTitude != null ? !longTitude.equals(that.longTitude) : that.longTitude != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (lateTitude != null ? !lateTitude.equals(that.lateTitude) : that.lateTitude != null) return false;
        if (streamLink != null ? !streamLink.equals(that.streamLink) : that.streamLink != null) return false;
        if (streamStatus != null ? !streamStatus.equals(that.streamStatus) : that.streamStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = churchId;
        result = 31 * result + (churchName != null ? churchName.hashCode() : 0);
        result = 31 * result + (longTitude != null ? longTitude.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lateTitude != null ? lateTitude.hashCode() : 0);
        result = 31 * result + (streamLink != null ? streamLink.hashCode() : 0);
        result = 31 * result + (streamStatus != null ? streamStatus.hashCode() : 0);
        return result;
    }
}
