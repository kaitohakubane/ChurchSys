package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 6/20/2017.
 */
public class EventJsonEntity {
    private String eventName;
    private String slotDate;
    private String subId;
    private String slotHour;
    private String privacy;
    private String typeString;
    private String numOfSlot;
    private String examDate;
    private String type;

    public EventJsonEntity() {
    }

    public EventJsonEntity(String eventName, String slotDate, String subId, String slotHour, String privacy,
                           String typeString, String numOfSlot, String examDate, String type) {
        this.eventName = eventName;
        this.slotDate = slotDate;
        this.subId = subId;
        this.slotHour = slotHour;
        this.privacy = privacy;
        this.typeString = typeString;
        this.numOfSlot = numOfSlot;
        this.examDate = examDate;
        this.type = type;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(String slotDate) {
        this.slotDate = slotDate;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSlotHour() {
        return slotHour;
    }

    public void setSlotHour(String slotHour) {
        this.slotHour = slotHour;
    }

    public String getNumOfSlot() {
        return numOfSlot;
    }

    public void setNumOfSlot(String numOfSlot) {
        this.numOfSlot = numOfSlot;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }
}
