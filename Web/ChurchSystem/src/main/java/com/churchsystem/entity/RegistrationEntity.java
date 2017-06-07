package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by hungmcse61561-admin on 6/6/2017.
 */
@Entity
@Table(name = "registration", schema = "churchsys", catalog = "")
public class RegistrationEntity {
    private int regisId;
    private Integer eventId;
    private String username;
    private Integer churchId;
    private Integer subId;
    private Date regisDate;
    private Time estTime;
    private Integer regisStatus;
    private Integer result;
    private String message;

    @Id
    @Column(name = "regisId")
    public int getRegisId() {
        return regisId;
    }

    public void setRegisId(int regisId) {
        this.regisId = regisId;
    }

    @Basic
    @Column(name = "eventId")
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "churchId")
    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "subId")
    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "regisDate")
    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    @Basic
    @Column(name = "estTime")
    public Time getEstTime() {
        return estTime;
    }

    public void setEstTime(Time estTime) {
        this.estTime = estTime;
    }

    @Basic
    @Column(name = "regisStatus")
    public Integer getRegisStatus() {
        return regisStatus;
    }

    public void setRegisStatus(Integer regisStatus) {
        this.regisStatus = regisStatus;
    }

    @Basic
    @Column(name = "result")
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationEntity that = (RegistrationEntity) o;

        if (regisId != that.regisId) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;
        if (regisDate != null ? !regisDate.equals(that.regisDate) : that.regisDate != null) return false;
        if (estTime != null ? !estTime.equals(that.estTime) : that.estTime != null) return false;
        if (regisStatus != null ? !regisStatus.equals(that.regisStatus) : that.regisStatus != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = regisId;
        result1 = 31 * result1 + (eventId != null ? eventId.hashCode() : 0);
        result1 = 31 * result1 + (username != null ? username.hashCode() : 0);
        result1 = 31 * result1 + (churchId != null ? churchId.hashCode() : 0);
        result1 = 31 * result1 + (subId != null ? subId.hashCode() : 0);
        result1 = 31 * result1 + (regisDate != null ? regisDate.hashCode() : 0);
        result1 = 31 * result1 + (estTime != null ? estTime.hashCode() : 0);
        result1 = 31 * result1 + (regisStatus != null ? regisStatus.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
        return result1;
    }
}
