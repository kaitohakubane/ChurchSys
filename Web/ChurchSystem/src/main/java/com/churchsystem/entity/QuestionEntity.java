package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Entity
@Table(name = "question", schema = "churchsys", catalog = "")
public class QuestionEntity {
    private int quesId;
    private String managerId;
    private String username;
    private String information;
    private String quesStatus;
    private Integer subId;

    @Id
    @Column(name = "quesId")
    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    @Basic
    @Column(name = "managerId")
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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
    @Column(name = "information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Basic
    @Column(name = "quesStatus")
    public String getQuesStatus() {
        return quesStatus;
    }

    public void setQuesStatus(String quesStatus) {
        this.quesStatus = quesStatus;
    }

    @Basic
    @Column(name = "subId")
    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (quesId != that.quesId) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (quesStatus != null ? !quesStatus.equals(that.quesStatus) : that.quesStatus != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quesId;
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (quesStatus != null ? quesStatus.hashCode() : 0);
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        return result;
    }
}
