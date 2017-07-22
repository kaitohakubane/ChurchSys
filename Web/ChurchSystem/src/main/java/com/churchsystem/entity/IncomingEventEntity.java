package com.churchsystem.entity;

import java.sql.Date;
import java.sql.Time;

public class IncomingEventEntity {
    private int eventId;
    private String eventName;
    private int churchId;
    private String churchName;
    private int subId;
    private String subName;
    private Date slotDate;
    private Time startTime;
    private Time endTime;

    public IncomingEventEntity() {
    }

    public IncomingEventEntity(int eventId, String eventName, int churchId, String churchName, int subId, String subName,
                               Date slotDate, Time startTime, Time endTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.churchId = churchId;
        this.churchName = churchName;
        this.subId = subId;
        this.subName = subName;
        this.slotDate = slotDate;
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

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
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
