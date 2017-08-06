package com.churchsystem.entity;

import com.churchsystem.common.utils.DateUtils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class IncomingClassEntity {
    private int eventId;
    private String eventName;
    private Date startDate;
    private String subName;

    public IncomingClassEntity() {
    }

    public IncomingClassEntity(int eventId, String eventName, Date startDate, String subName) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.startDate = startDate;
        this.subName = subName;
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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getInfo() {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date curDate = DateUtils.getCurrentDate();
        String result = "Môn: " + subName + "</br>";
        if (startDate.compareTo(curDate) >= 1) {
            result += "Ngày bắt đầu: " + date.format(startDate);
        }
        else {
            result += "Đang diễn ra";
        }
        return result;
    }
}
