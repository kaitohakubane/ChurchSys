package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by hungmcse61561-admin on 8/15/2017.
 */
@Entity
@Table(name = "event", schema = "churchsys", catalog = "")
public class EventEntity {
    private int eventId;
    private String eventName;
    private Integer numOfSlot;
    private Integer churchId;
    private Integer eventStatus;
    private Date examDate;
    private Integer subId;
    private Integer typeId;
    private Date startDate;
    private String description;
    private Boolean privacy;
    private Boolean isRegistered;
    private Timestamp createdTime;

    @Id
    @Column(name = "eventId")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "eventName")
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Basic
    @Column(name = "numOfSlot")
    public Integer getNumOfSlot() {
        return numOfSlot;
    }

    public void setNumOfSlot(Integer numOfSlot) {
        this.numOfSlot = numOfSlot;
    }

    @Basic
    @Column(name = "churchId")
    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "eventStatus")
    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    @Basic
    @Column(name = "examDate")
    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    @Basic
    @Column(name = "subId")
    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "typeId")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
    @Column(name = "privacy")
    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    @Basic
    @Column(name = "isRegistered")
    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    @Basic
    @Column(name = "createdTime")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (eventId != that.eventId) return false;
        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        if (numOfSlot != null ? !numOfSlot.equals(that.numOfSlot) : that.numOfSlot != null) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;
        if (eventStatus != null ? !eventStatus.equals(that.eventStatus) : that.eventStatus != null) return false;
        if (examDate != null ? !examDate.equals(that.examDate) : that.examDate != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (privacy != null ? !privacy.equals(that.privacy) : that.privacy != null) return false;
        if (isRegistered != null ? !isRegistered.equals(that.isRegistered) : that.isRegistered != null) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (numOfSlot != null ? numOfSlot.hashCode() : 0);
        result = 31 * result + (churchId != null ? churchId.hashCode() : 0);
        result = 31 * result + (eventStatus != null ? eventStatus.hashCode() : 0);
        result = 31 * result + (examDate != null ? examDate.hashCode() : 0);
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (privacy != null ? privacy.hashCode() : 0);
        result = 31 * result + (isRegistered != null ? isRegistered.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }
}
