package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 7/31/2017.
 */
public class UserRegistrationInformation {
    private String userName;
    private String phone;
    private String mail;
    private String description;
    private String conductor;
    private String room;

    public UserRegistrationInformation() {
    }

    public UserRegistrationInformation(String userName, String phone, String mail, String description, String conductor, String room) {
        this.userName = userName;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
        this.conductor = conductor;
        this.room = room;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
