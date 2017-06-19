package com.churchsystem.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public class EventDataEntity {
    private int slotId;
    private int eventId;
    private int conductorId;
    private int roomId;
    private Integer subId;
    private Date startTime;
    private Date endTime;
    private String conductorName;
    private String roomName;
    private Boolean privacy;
    private String description;
    private String subName;
    private Integer eventStatus;
    private String eventName;

    public EventDataEntity() {
    }

    public EventDataEntity(int slotId, int eventId, int conductorId, int roomId, Integer subId, Date startTime,
                           Date endTime, String conductorName, String roomName, Boolean privacy, String description,
                           String subName, Integer eventStatus, String eventName) {
        this.slotId = slotId;
        this.eventId = eventId;
        this.conductorId = conductorId;
        this.roomId = roomId;
        this.subId = subId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.conductorName = conductorName;
        this.roomName = roomName;
        this.privacy = privacy;
        this.description = description;
        this.subName = subName;
        this.eventStatus = eventStatus;
        this.eventName = eventName;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getConductorId() {
        return conductorId;
    }

    public void setConductorId(int conductorId) {
        this.conductorId = conductorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
