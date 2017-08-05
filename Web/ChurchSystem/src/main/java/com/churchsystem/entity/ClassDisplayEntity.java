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
    private int cateId;
    private Time startTime;
    private Time endTime;
    private String conductorName;
    private String roomName;
    private int userStatus;

    public ClassDisplayEntity() {
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public ClassDisplayEntity(int eventId, String eventName, Date startDate, String typeName, String subName, int cateId, Time startTime, Time endTime, String conductorName, String roomName, int userStatus) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.startDate = startDate;
        this.typeName = typeName;
        this.subName = subName;
        this.cateId = cateId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.conductorName = conductorName;
        this.roomName = roomName;
        this.userStatus = userStatus;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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
