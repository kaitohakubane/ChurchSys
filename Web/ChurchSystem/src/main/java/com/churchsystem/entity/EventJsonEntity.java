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

    public EventJsonEntity(String eventName, String slotDate, String subId, String slotHour, String privacy) {
        this.eventName = eventName;
        this.slotDate = slotDate;
        this.subId = subId;
        this.slotHour = slotHour;
        this.privacy = privacy;
    }

    public EventJsonEntity() {
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

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }
}
