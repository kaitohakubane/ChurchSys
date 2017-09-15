package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by Vongnlh on 9/8/2017.
 */

@Entity
@Table(name = "lesson",schema = "churchsys", catalog = "")

public class LessonEntity {
    private int lessonId;
    private String title;
    private String description;
    private int subId;
    private int churchId;

    public LessonEntity(int lessonId, String title, String description, int subId, int churchId) {
        this.lessonId = lessonId;
        this.title = title;
        this.description = description;
        this.subId = subId;
        this.churchId = churchId;
    }

    public LessonEntity() {
    }
    @Id
    @Column(name = "lessonId")
    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Basic
    @Column(name = "subId")
    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
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
    @Column(name = "churchId")
    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }
}
