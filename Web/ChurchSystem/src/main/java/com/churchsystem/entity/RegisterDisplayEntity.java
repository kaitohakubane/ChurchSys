package com.churchsystem.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by hungmcse61561-admin on 5/31/2017.
 */
public class RegisterDisplayEntity {
    private int regisId;
    private String username;
    private int subId;
    private String subName;
    private Date regisDate;
    private Time estTime;
    private String message;
    private String categoryName;

    public RegisterDisplayEntity() {
    }

    public RegisterDisplayEntity(int regisId, String username, int subId, String subName, Date regisDate, Time estTime, String message, String categoryName) {
        this.regisId = regisId;
        this.username = username;
        this.subId = subId;
        this.subName = subName;
        this.regisDate = regisDate;
        this.estTime = estTime;
        this.message = message;
        this.categoryName = categoryName;
    }

    public int getRegisId() {
        return regisId;
    }

    public void setRegisId(int regisId) {
        this.regisId = regisId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public Time getEstTime() {
        return estTime;
    }

    public void setEstTime(Time estTime) {
        this.estTime = estTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
