package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Entity
@Table(name = "event", schema = "churchsys", catalog = "")
public class EventEntity {
    private int eventId;
    private Integer numOfSlot;
    private Integer eventStatus;
    private Date examDate;
    private Integer subId;
    private Integer typeId;
    private Date startDate;
    private Integer churchId;

    @Id
    @Column(name = "eventId")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
    @Column(name = "churchId")
    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (eventId != that.eventId) return false;
        if (numOfSlot != null ? !numOfSlot.equals(that.numOfSlot) : that.numOfSlot != null) return false;
        if (eventStatus != null ? !eventStatus.equals(that.eventStatus) : that.eventStatus != null) return false;
        if (examDate != null ? !examDate.equals(that.examDate) : that.examDate != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + (numOfSlot != null ? numOfSlot.hashCode() : 0);
        result = 31 * result + (eventStatus != null ? eventStatus.hashCode() : 0);
        result = 31 * result + (examDate != null ? examDate.hashCode() : 0);
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (churchId != null ? churchId.hashCode() : 0);
        return result;
    }
}
