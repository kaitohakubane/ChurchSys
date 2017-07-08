package com.churchsystem.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by hungmcse61561-admin on 7/7/2017.
 */
public class ClassDisplayEntity {
    private int eventId;
    private String eventName;
    private Date startDate;
    private String typeName;
    private String subName;
    private Time startTime;
    private Time endTime;

    public ClassDisplayEntity() {
    }

    public ClassDisplayEntity(int eventId, String eventName, Date startDate, String typeName, String subName, Time startTime, Time endTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.startDate = startDate;
        this.typeName = typeName;
        this.subName = subName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
