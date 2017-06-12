package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 6/12/2017.
 */
@Entity
@Table(name = "contribution", schema = "churchsys", catalog = "")
public class ContributionEntity {
    private int contributeId;
    private Integer userId;
    private Integer postId;
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
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "postId")
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (donate != null ? !donate.equals(that.donate) : that.donate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contributeId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (donate != null ? donate.hashCode() : 0);
        return result;
    }
}
