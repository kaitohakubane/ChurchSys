package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by Vongnlh on 9/16/2017.
 */
@Entity
@Table(name = "lecture", schema = "churchsys", catalog = "")
public class LectureEntity {
    private int lectureId;
    private String title;
    private String description;
    private String linkvideo;
    private int churchId;

    public LectureEntity() {
    }

    public LectureEntity(int lectureId, String title, String description, String linkvideo, int churchId) {
        this.lectureId = lectureId;
        this.title = title;
        this.description = description;
        this.linkvideo = linkvideo;
        this.churchId = churchId;
    }
    @Id
    @Column(name = "lectureId")
    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Basic
    @Column(name = "linkvideo")
    public String getLinkvideo() {
        return linkvideo;
    }

    public void setLinkvideo(String linkvideo) {
        this.linkvideo = linkvideo;
    }
    @Basic
    @Column(name = "churchId")
    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }
}
