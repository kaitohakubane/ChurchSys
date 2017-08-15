package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 8/15/2017.
 */
@Entity
@Table(name = "question", schema = "churchsys", catalog = "")
public class QuestionEntity {
    private int quesId;
    private Integer conductorId;
    private Integer userId;
    private String information;
    private String quesStatus;
    private Integer kind;

    @Id
    @Column(name = "quesId")
    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    @Basic
    @Column(name = "conductorId")
    public Integer getConductorId() {
        return conductorId;
    }

    public void setConductorId(Integer conductorId) {
        this.conductorId = conductorId;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Column(name = "kind")
    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (quesId != that.quesId) return false;
        if (conductorId != null ? !conductorId.equals(that.conductorId) : that.conductorId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (quesStatus != null ? !quesStatus.equals(that.quesStatus) : that.quesStatus != null) return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quesId;
        result = 31 * result + (conductorId != null ? conductorId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (quesStatus != null ? quesStatus.hashCode() : 0);
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        return result;
    }
}
