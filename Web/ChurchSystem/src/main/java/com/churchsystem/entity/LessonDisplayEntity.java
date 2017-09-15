package com.churchsystem.entity;

/**
 * Created by Vongnlh on 9/14/2017.
 */
public class LessonDisplayEntity {
    private int lessonId;
    private String title;
    private String description;
    private int subId;
    private int churchId;
    private int categoryId;
    private String categoryName;

    public LessonDisplayEntity() {
    }

    public LessonDisplayEntity(int lessonId, String title, String description, int subId, int churchId, int categoryId, String categoryName) {
        this.lessonId = lessonId;
        this.title = title;
        this.description = description;
        this.subId = subId;
        this.churchId = churchId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getLessonId() {
        return lessonId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
