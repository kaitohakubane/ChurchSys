package com.churchsystem.entity;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.StringUtils;

import java.sql.Time;
import java.util.Date;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
public class EventDisplayEntity {
    private int slotId;
    private String title;
    private String subName;
    private String start;
    private String end;
    private String conductorName;
    private String roomName;
    private int privacy;
    private String description;
    private Integer status;
    private String streamLink;
    private String streamCode;
    private int eventStatus;
    private Integer isStream;

    public EventDisplayEntity() {
    }

    public Integer getIsStream() {
        return isStream;
    }

    public void setIsStream(Integer isStream) {
        this.isStream = isStream;
    }

    public EventDisplayEntity(EventDataEntity dataEntity) {
        this.slotId = dataEntity.getSlotId();
        this.title = dataEntity.getEventName();
        this.subName = dataEntity.getSubName();
        this.start= StringUtils.convertDateAndTimeToDateTime(dataEntity.getSlotDate(),dataEntity.getStartTime());
        this.end= StringUtils.convertDateAndTimeToDateTime(dataEntity.getSlotDate(),dataEntity.getEndTime());
        this.conductorName = dataEntity.getConductorName();
        this.roomName = dataEntity.getRoomName();

        if (dataEntity.getPrivacy()) {
            this.privacy = UtilsConstant.ONE;
        } else {
            this.privacy = UtilsConstant.ZERO;
        }
        this.description=dataEntity.getDescription();
        this.status=dataEntity.getStatus();
        this.streamLink=dataEntity.getStreamLink();
        this.streamCode=dataEntity.getStreamCode();
        this.eventStatus=dataEntity.getEventStatus();
        this.isStream=dataEntity.getIsStream();
    }

    public int getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(int eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getStreamLink() {
        return streamLink;
    }

    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }

    public String getStreamCode() {
        return streamCode;
    }

    public void setStreamCode(String streamCode) {
        this.streamCode = streamCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
