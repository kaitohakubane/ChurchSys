package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
@Entity
@Table(name = "slothour", schema = "churchsys", catalog = "")
public class SlothourEntity {
    private int slotHourId;
    private String slotName;
    private Time startTime;
    private Time endTime;

    @Id
    @Column(name = "slotHourId")
    public int getSlotHourId() {
        return slotHourId;
    }

    public void setSlotHourId(int slotHourId) {
        this.slotHourId = slotHourId;
    }

    @Basic
    @Column(name = "slotName")
    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    @Basic
    @Column(name = "startTime")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlothourEntity that = (SlothourEntity) o;

        if (slotHourId != that.slotHourId) return false;
        if (slotName != null ? !slotName.equals(that.slotName) : that.slotName != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = slotHourId;
        result = 31 * result + (slotName != null ? slotName.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
