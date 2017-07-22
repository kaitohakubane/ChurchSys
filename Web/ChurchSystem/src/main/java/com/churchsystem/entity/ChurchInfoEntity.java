package com.churchsystem.entity;

import java.sql.Time;

public class ChurchInfoEntity {

    private int churchId;
    private String churchName;
    private String tel;
    private String address;
    private String mail;
    private Time startTime;
    private Time endTime;
    private String image;
    private String description;
    private int userId;
    private String userName;
    private String certificate;

    public ChurchInfoEntity() {
    }

    public ChurchInfoEntity(int churchId, String churchName, String tel, String address, String mail, Time startTime,
                            Time endTime, String image, String description, int userId, String userName, String certificate) {
        this.churchId = churchId;
        this.churchName = churchName;
        this.tel = tel;
        this.address = address;
        this.mail = mail;
        this.startTime = startTime;
        this.endTime = endTime;
        this.image = image;
        this.description = description;
        this.userId = userId;
        this.userName = userName;
        this.certificate = certificate;
    }

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
