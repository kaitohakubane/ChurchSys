package com.churchsystem.entity;

import java.util.Date;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
public class CreatingEventEntity {
    private int eventId;
    private String eventName;
    private String subjectId;
    private String typeId;
    private String startDate;
    private String privacy;
    private String duration;

    public CreatingEventEntity(int eventId, String eventName, String subjectId, String typeId, String startDate, String privacy, String duration) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.subjectId = subjectId;
        this.typeId = typeId;
        this.startDate = startDate;
        this.privacy = privacy;
        this.duration = duration;
    }

    public CreatingEventEntity() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
