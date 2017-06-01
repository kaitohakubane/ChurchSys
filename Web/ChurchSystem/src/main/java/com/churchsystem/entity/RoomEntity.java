package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 5/31/2017.
 */
@Entity
@Table(name = "room", schema = "churchsys", catalog = "")
public class RoomEntity {
    private int roomId;
    private String roomName;
    private Integer roomStatus;

    @Id
    @Column(name = "roomId")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "roomName")
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Basic
    @Column(name = "roomStatus")
    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (roomId != that.roomId) return false;
        if (roomName != null ? !roomName.equals(that.roomName) : that.roomName != null) return false;
        if (roomStatus != null ? !roomStatus.equals(that.roomStatus) : that.roomStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (roomStatus != null ? roomStatus.hashCode() : 0);
        return result;
    }
}
