package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Entity
@Table(name = "slot", schema = "churchsys", catalog = "")
public class SlotEntity {
    private int slotId;
    private Integer eventId;
    private Integer roomId;
    private String managerId;
    private Date slotDate;
    private Integer slotHour;

    @Id
    @Column(name = "slotId")
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
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
    @Column(name = "roomId")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
    @Column(name = "slotDate")
    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

    @Basic
    @Column(name = "slotHour")
    public Integer getSlotHour() {
        return slotHour;
    }

    public void setSlotHour(Integer slotHour) {
        this.slotHour = slotHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlotEntity that = (SlotEntity) o;

        if (slotId != that.slotId) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (slotDate != null ? !slotDate.equals(that.slotDate) : that.slotDate != null) return false;
        if (slotHour != null ? !slotHour.equals(that.slotHour) : that.slotHour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = slotId;
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (slotDate != null ? slotDate.hashCode() : 0);
        result = 31 * result + (slotHour != null ? slotHour.hashCode() : 0);
        return result;
    }
}
