package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 8/3/2017.
 */
@Entity
@Table(name = "graveyard", schema = "churchsys", catalog = "")
public class GraveyardEntity {
    private int id;
    private Integer churchId;
    private Integer status;
    private String name;
    private Integer x;
    private Integer y;
    private Integer graveSize;
    private Integer graveAvailable;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "x")
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y")
    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Basic
    @Column(name = "graveSize")
    public Integer getGraveSize() {
        return graveSize;
    }

    public void setGraveSize(Integer graveSize) {
        this.graveSize = graveSize;
    }

    @Basic
    @Column(name = "graveAvailable")
    public Integer getGraveAvailable() {
        return graveAvailable;
    }

    public void setGraveAvailable(Integer graveAvailable) {
        this.graveAvailable = graveAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraveyardEntity that = (GraveyardEntity) o;

        if (id != that.id) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        if (graveSize != null ? !graveSize.equals(that.graveSize) : that.graveSize != null) return false;
        if (graveAvailable != null ? !graveAvailable.equals(that.graveAvailable) : that.graveAvailable != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (churchId != null ? churchId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (graveSize != null ? graveSize.hashCode() : 0);
        result = 31 * result + (graveAvailable != null ? graveAvailable.hashCode() : 0);
        return result;
    }
}
