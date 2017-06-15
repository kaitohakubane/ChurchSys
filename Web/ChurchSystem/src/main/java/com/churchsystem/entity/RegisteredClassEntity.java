package com.churchsystem.entity;

/**
 * Created by Mr Kiet on 06/15/17.
 */
public class RegisteredClassEntity {
    private int subId;
    private String subName;
    private int numOfSlot;

    public RegisteredClassEntity() {
    }

    public RegisteredClassEntity(int subId, String subName, int numOfSlot) {
        this.subId = subId;
        this.subName = subName;
        this.numOfSlot = numOfSlot;
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

    public int getNumOfSlot() {
        return numOfSlot;
    }

    public void setNumOfSlot(int numOfSlot) {
        this.numOfSlot = numOfSlot;
    }
}
