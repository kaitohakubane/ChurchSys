package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Entity
@Table(name = "ability", schema = "churchsys", catalog = "")
public class AbilityEntity {
    private Integer managerId;
    private Integer subId;
    private int abilityId;

    @Basic
    @Column(name = "managerId")
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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
    @Column(name = "abilityId")
    public int getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(int abilityId) {
        this.abilityId = abilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbilityEntity that = (AbilityEntity) o;

        if (abilityId != that.abilityId) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId != null ? managerId.hashCode() : 0;
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        result = 31 * result + abilityId;
        return result;
    }
}
