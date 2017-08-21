package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by Trung on 8/6/2017.
 */
@Entity
@Table(name = "graveyard", schema = "churchsys", catalog = "")
public class GraveyardEntity {
    private int graveYardId;
    private Integer churchId;
    private Integer status;
    private String name;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private Integer graveAvailable;

    @Id
    @Column(name = "graveYardId")
    public int getGraveYardId() {
        return graveYardId;
    }

    public void setGraveYardId(int graveYardId) {
        this.graveYardId = graveYardId;
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
    @Column(name = "width")
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Basic
    @Column(name = "height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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

        if (graveYardId != that.graveYardId) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (graveAvailable != null ? !graveAvailable.equals(that.graveAvailable) : that.graveAvailable != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = graveYardId;
        result = 31 * result + (churchId != null ? churchId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (graveAvailable != null ? graveAvailable.hashCode() : 0);
        return result;
    }
}
