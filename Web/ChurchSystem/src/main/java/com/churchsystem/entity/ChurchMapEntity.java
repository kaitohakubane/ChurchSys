package com.churchsystem.entity;

import java.sql.Time;

/**
 * Created by hungmcse61561-admin on 7/5/2017.
 */
public class ChurchMapEntity {
    private Integer churchId;
    private String churchName;
    private Double longitude;
    private Double latitude;
    private double distance;
    private String tel;
    private Time startTime;
    private Time endTime;
    private String description;
    private String streamLink;

    public ChurchMapEntity() {
    }

    public ChurchMapEntity(Integer churchId, String churchName, Double longitude, Double latitude, double distance,
                           String tel, Time startTime, Time endTime, String description, String streamLink) {
        this.churchId = churchId;
        this.churchName = churchName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.tel = tel;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.streamLink = streamLink;
    }

    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getStreamLink() {
        return streamLink;
    }

    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }
}
