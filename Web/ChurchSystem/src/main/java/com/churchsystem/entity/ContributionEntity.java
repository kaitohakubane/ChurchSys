package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 8/15/2017.
 */
@Entity
@Table(name = "contribution", schema = "churchsys", catalog = "")
public class ContributionEntity {
    private int contributeId;
    private Integer churchId;
    private String donate;

    @Id
    @Column(name = "contributeId")
    public int getContributeId() {
        return contributeId;
    }

    public void setContributeId(int contributeId) {
        this.contributeId = contributeId;
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
    @Column(name = "donate")
    public String getDonate() {
        return donate;
    }

    public void setDonate(String donate) {
        this.donate = donate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContributionEntity that = (ContributionEntity) o;

        if (contributeId != that.contributeId) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;
        if (donate != null ? !donate.equals(that.donate) : that.donate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contributeId;
        result = 31 * result + (churchId != null ? churchId.hashCode() : 0);
        result = 31 * result + (donate != null ? donate.hashCode() : 0);
        return result;
    }
}
