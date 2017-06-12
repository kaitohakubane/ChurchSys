package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/12/2017.
 */
@Entity
@Table(name = "post", schema = "churchsys", catalog = "")
public class PostEntity {
    private int postId;
    private Integer conductorId;
    private String title;
    private String information;
    private Boolean isContribute;

    @Id
    @Column(name = "postId")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Basic
    @Column(name = "isContribute")
    public Boolean getContribute() {
        return isContribute;
    }

    public void setContribute(Boolean contribute) {
        isContribute = contribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (postId != that.postId) return false;
        if (conductorId != null ? !conductorId.equals(that.conductorId) : that.conductorId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (isContribute != null ? !isContribute.equals(that.isContribute) : that.isContribute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + (conductorId != null ? conductorId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (isContribute != null ? isContribute.hashCode() : 0);
        return result;
    }
}
