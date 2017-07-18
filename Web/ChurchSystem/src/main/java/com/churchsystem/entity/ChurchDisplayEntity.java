package com.churchsystem.entity;

import java.sql.Time;

/**
 * Created by Mr Kiet on 07/10/17.
 */
public class ChurchDisplayEntity {
    private int churchId;
    private String churchName;
    private Double longitude;
    private Double latitude;
    private String tel;
    private String address;
    private String mail;
    private Time startTime;
    private Time endTime;
    private String description;
    private String streamName;
    private String streamLink;
    private Integer userId;
    private String accountId;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ChurchDisplayEntity() {
    }

    public ChurchDisplayEntity(int churchId, String churchName, Double longitude, Double latitude, String tel,
                               String address, String mail, Time startTime, Time endTime, String description, String streamName,
                               String streamLink, Integer userId, String accountId, String image) {
        this.churchId = churchId;
        this.churchName = churchName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.tel = tel;
        this.address = address;
        this.mail = mail;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.streamName = streamName;
        this.streamLink = streamLink;
        this.userId = userId;
        this.accountId = accountId;
        this.image = image;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getStreamLink() {
        return streamLink;
    }

    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
