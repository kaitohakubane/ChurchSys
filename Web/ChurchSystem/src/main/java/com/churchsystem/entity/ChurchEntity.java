package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by hungmcse61561-admin on 6/12/2017.
 */
@Entity
@Table(name = "church", schema = "churchsys", catalog = "")
public class ChurchEntity {
    private int churchId;
    private String churchName;
    private Double longitude;
    private Double latitude;
    private String tel;
    private String mail;
    private Time startTime;
    private Time endTime;
    private String description;
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
    @Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "startTime")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
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
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (streamLink != null ? !streamLink.equals(that.streamLink) : that.streamLink != null) return false;
        if (streamStatus != null ? !streamStatus.equals(that.streamStatus) : that.streamStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = churchId;
        result = 31 * result + (churchName != null ? churchName.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (streamLink != null ? streamLink.hashCode() : 0);
        result = 31 * result + (streamStatus != null ? streamStatus.hashCode() : 0);
        return result;
    }
}
