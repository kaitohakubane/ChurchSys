package com.churchsystem.entity;

/**
 * Created by Mr Kiet on 06/15/17.
 */
public class RegisteredClassEntity {
    private int subId;
    private String subName;
    private int numOfRegistration;

    public RegisteredClassEntity() {
    }


    public RegisteredClassEntity(int subId, String subName, int numOfRegistration) {
        this.subId = subId;
        this.subName = subName;
        this.numOfRegistration = numOfRegistration;
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

    public int getNumOfRegistration() {
        return numOfRegistration;
    }

    public void setNumOfRegistration(int numOfRegistration) {
        this.numOfRegistration = numOfRegistration;
    }
}
