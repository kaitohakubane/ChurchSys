package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
@Entity
@Table(name = "inclusion", schema = "churchsys", catalog = "")
public class InclusionEntity {
    private int inclusionId;
    private Integer slotId;
    private Integer slotHourId;

    @Id
    @Column(name = "inclusionId")
    public int getInclusionId() {
        return inclusionId;
    }

    public void setInclusionId(int inclusionId) {
        this.inclusionId = inclusionId;
    }

    @Basic
    @Column(name = "slotId")
    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    @Basic
    @Column(name = "slotHourId")
    public Integer getSlotHourId() {
        return slotHourId;
    }

    public void setSlotHourId(Integer slotHourId) {
        this.slotHourId = slotHourId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InclusionEntity that = (InclusionEntity) o;

        if (inclusionId != that.inclusionId) return false;
        if (slotId != null ? !slotId.equals(that.slotId) : that.slotId != null) return false;
        if (slotHourId != null ? !slotHourId.equals(that.slotHourId) : that.slotHourId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inclusionId;
        result = 31 * result + (slotId != null ? slotId.hashCode() : 0);
        result = 31 * result + (slotHourId != null ? slotHourId.hashCode() : 0);
        return result;
    }
}
