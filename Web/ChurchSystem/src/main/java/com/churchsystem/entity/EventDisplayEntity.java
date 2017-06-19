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

    public EventDisplayEntity() {
    }

    public EventDisplayEntity(EventDataEntity dataEntity) {
        this.slotId = dataEntity.getSlotId();
        this.title = dataEntity.getEventName();
        this.subName = dataEntity.getSubName();
        this.start=StringUtils.formatDateToString(dataEntity.getStartTime());
        this.end=StringUtils.formatDateToString(dataEntity.getEndTime());
        this.conductorName = dataEntity.getConductorName();
        this.roomName = dataEntity.getRoomName();

        if (dataEntity.getPrivacy()) {
            this.privacy = UtilsConstant.ONE;
        } else {
            this.privacy = UtilsConstant.ZERO;
        }
        this.description=dataEntity.getDescription();
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
