package com.churchsystem.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by hungmcse61561-admin on 8/15/2017.
 */
@Entity
@Table(name = "type", schema = "churchsys", catalog = "")
public class TypeEntity {
    private int typeId;
    private String description;
    private Integer loopType;
    private Date lastGenerated;
    private Integer kind;

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

    @Basic
    @Column(name = "loopType")
    public Integer getLoopType() {
        return loopType;
    }

    public void setLoopType(Integer loopType) {
        this.loopType = loopType;
    }

    @Basic
    @Column(name = "lastGenerated")
    public Date getLastGenerated() {
        return lastGenerated;
    }

    public void setLastGenerated(Date lastGenerated) {
        this.lastGenerated = lastGenerated;
    }

    @Basic
    @Column(name = "kind")
    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEntity that = (TypeEntity) o;

        if (typeId != that.typeId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (loopType != null ? !loopType.equals(that.loopType) : that.loopType != null) return false;
        if (lastGenerated != null ? !lastGenerated.equals(that.lastGenerated) : that.lastGenerated != null)
            return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (loopType != null ? loopType.hashCode() : 0);
        result = 31 * result + (lastGenerated != null ? lastGenerated.hashCode() : 0);
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        return result;
    }
}
