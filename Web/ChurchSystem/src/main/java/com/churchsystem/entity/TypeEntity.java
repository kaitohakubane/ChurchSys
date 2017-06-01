package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Entity
@Table(name = "type", schema = "churchsys", catalog = "")
public class TypeEntity {
    private int typeId;
    private String description;

    @Id
    @Column(name = "typeId")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEntity that = (TypeEntity) o;

        if (typeId != that.typeId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
