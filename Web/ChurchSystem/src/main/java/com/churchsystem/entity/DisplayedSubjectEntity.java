package com.churchsystem.entity;

/**
 * Created by Mr Kiet on 06/15/17.
 */
public class DisplayedSubjectEntity {
    private int subId;
    private String subName;
    private int categoryId;

    public DisplayedSubjectEntity(int subId, String subName, int categoryId) {
        this.subId = subId;
        this.subName = subName;
        this.categoryId = categoryId;
    }

    public DisplayedSubjectEntity() {
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
