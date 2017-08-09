package com.churchsystem.entity;

import com.churchsystem.common.utils.DateUtils;

import java.sql.Date;

public class DashboardClassEntity {
    private String eventName;
    private String churchName;
    private Date startDate;
    private int status;

    public DashboardClassEntity() {
    }

    public DashboardClassEntity(String eventName, String churchName, Date startDate, int status) {
        this.eventName = eventName;
        this.churchName = churchName;
        this.startDate = startDate;
        this.status = status;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getClassStatus() {
        String result = "";
        Date curDate = DateUtils.getCurrentDate();
        if(status==4){
            result = "Đã hoàn thành";
        }else {
            if (startDate.compareTo(curDate) >= 1) {
                result = "Sắp diễn ra";
            }
            else {
                result += "Đang diễn ra";
            }
        }
        return result;
    }
}
