package com.churchsystem.entity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisDisplayEntity {
    private int regisId;
    private Date regisDate;
    private String message;
    private Date slotDate;
    private Time startTime;
    private Time endTime;
    private int eventId;
    private String eventName;
    private int subId;
    private String subName;
    private int userId;
    private String accountId;
    private String tel;
    private String email;

    public RegisDisplayEntity() {
    }

    public RegisDisplayEntity(int regisId, Date regisDate, String message, Date slotDate, Time startTime, Time endTime, int eventId, String eventName, int subId, String subName, int userId, String accountId, String tel, String email) {
        this.regisId = regisId;
        this.regisDate = regisDate;
        this.message = message;
        this.slotDate = slotDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventId = eventId;
        this.eventName = eventName;
        this.subId = subId;
        this.subName = subName;
        this.userId = userId;
        this.accountId = accountId;
        this.tel = tel;
        this.email = email;
    }

    public int getRegisId() {
        return regisId;
    }

    public void setRegisId(int regisId) {
        this.regisId = regisId;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String result = sdf.format(regisDate);
        return result;
    }

    public String getTime() {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
        String result = time.format(startTime) + " - " + time.format(endTime) + "<br/>" + "Ngày: " + date.format(slotDate);
        return result;
    }

    public String getContact() {
        String result = "Email: " + email + "<br/>" + "SĐT: " + tel;
        return result;
    }
}
