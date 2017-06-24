package com.churchsystem.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public class EventDataEntity {
    private int slotId;
    private int eventId;
    private Integer conductorId;
    private Integer roomId;
    private Integer subId;
    private Date slotDate;
    private Time startTime;
    private Time endTime;
    private String conductorName;
    private String roomName;
    private Boolean privacy;
    private String description;
    private String subName;
    private Integer eventStatus;
    private String eventName;
    private Integer status;

    public EventDataEntity() {
    }

    public EventDataEntity(int slotId, int eventId, Integer conductorId, Integer roomId, Integer subId, Date slotDate,
                           Time startTime, Time endTime, String conductorName, String roomName, Boolean privacy,
                           String description, String subName, Integer eventStatus, String eventName, Integer status) {
        this.slotId = slotId;
        this.eventId = eventId;
        this.conductorId = conductorId;
        this.roomId = roomId;
        this.subId = subId;
        this.slotDate = slotDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.conductorName = conductorName;
        this.roomName = roomName;
        this.privacy = privacy;
        this.description = description;
        this.subName = subName;
        this.eventStatus = eventStatus;
        this.eventName = eventName;
        this.status = status;
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

    public Integer getConductorId() {
        return conductorId;
    }

    public void setConductorId(Integer conductorId) {
        this.conductorId = conductorId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
