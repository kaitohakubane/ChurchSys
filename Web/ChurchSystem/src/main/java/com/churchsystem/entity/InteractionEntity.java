package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/12/2017.
 */
@Entity
@Table(name = "interaction", schema = "churchsys", catalog = "")
public class InteractionEntity {
    private int interactionId;
    private Integer churchId;
    private Integer userId;

    @Id
    @Column(name = "interactionId")
    public int getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(int interactionId) {
        this.interactionId = interactionId;
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
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InteractionEntity that = (InteractionEntity) o;

        if (interactionId != that.interactionId) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = interactionId;
        result = 31 * result + (churchId != null ? churchId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
