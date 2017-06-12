package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/12/2017.
 */
@Entity
@Table(name = "ability", schema = "churchsys", catalog = "")
public class AbilityEntity {
    private int abilityId;
    private Integer conductorId;
    private Integer subId;

    @Id
    @Column(name = "abilityId")
    public int getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(int abilityId) {
        this.abilityId = abilityId;
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

        AbilityEntity that = (AbilityEntity) o;

        if (abilityId != that.abilityId) return false;
        if (conductorId != null ? !conductorId.equals(that.conductorId) : that.conductorId != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = abilityId;
        result = 31 * result + (conductorId != null ? conductorId.hashCode() : 0);
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        return result;
    }
}
