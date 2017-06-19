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
    private String eventName;
    private String subName;
    private String slotHourStart;
    private String slotHourEnd;
    private String conductorName;
    private String roomName;
    private int privacy;
    private String description;

    public EventDisplayEntity() {
    }

    public EventDisplayEntity(EventDataEntity dataEntity) {
        this.slotId = dataEntity.getSlotId();
        this.eventName = dataEntity.getEventName();
        this.subName = dataEntity.getSubName();
        this.slotHourStart=StringUtils.formatDateToString(dataEntity.getStartTime());
        this.slotHourEnd=StringUtils.formatDateToString(dataEntity.getEndTime());
        this.conductorName = dataEntity.getConductorName();
        this.roomName = dataEntity.getRoomName();

        if (dataEntity.getPrivacy()) {
            this.privacy = UtilsConstant.ONE;
        } else {
            this.privacy = UtilsConstant.ZERO;
        }
        this.description=dataEntity.getDescription();
    }

    public EventDisplayEntity(int slotId, String eventName, String subName, String slotHourStart,
                              String slotHourEnd, String conductorName, String roomName, int privacy,
                              String description) {
        this.slotId = slotId;
        this.eventName = eventName;
        this.subName = subName;
        this.slotHourStart = slotHourStart;
        this.slotHourEnd = slotHourEnd;
        this.conductorName = conductorName;
        this.roomName = roomName;
        this.privacy = privacy;
        this.description = description;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSlotHourStart() {
        return slotHourStart;
    }

    public void setSlotHourStart(String slotHourStart) {
        this.slotHourStart = slotHourStart;
    }

    public String getSlotHourEnd() {
        return slotHourEnd;
    }

    public void setSlotHourEnd(String slotHourEnd) {
        this.slotHourEnd = slotHourEnd;
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
