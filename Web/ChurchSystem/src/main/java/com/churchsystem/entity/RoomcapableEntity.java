package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Entity
@Table(name = "roomcapable", schema = "churchsys", catalog = "")
public class RoomcapableEntity {
    private Integer roomId;
    private Integer subId;
    private int roomCapId;

    @Basic
    @Column(name = "roomId")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "subId")
    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    @Id
    @Column(name = "roomCapId")
    public int getRoomCapId() {
        return roomCapId;
    }

    public void setRoomCapId(int roomCapId) {
        this.roomCapId = roomCapId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomcapableEntity that = (RoomcapableEntity) o;

        if (roomCapId != that.roomCapId) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        result = 31 * result + roomCapId;
        return result;
    }
}
