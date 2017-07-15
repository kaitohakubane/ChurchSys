package com.churchsystem.entity;

/**
 * Created by Mr Kiet on 07/15/17.
 */
public class ManagementJsonEntity {
    private String userName;
    private String accountId;
    private String email;
    private String phone;
    private String cert;
    private String roomName;
    private Integer[] selectedSubjectList;

    public ManagementJsonEntity() {
    }

    public ManagementJsonEntity(String userName, String accountId, String email, String phone, String cert, String roomName, Integer[] selectedSubjectList) {
        this.userName = userName;
        this.accountId = accountId;
        this.email = email;
        this.phone = phone;
        this.cert = cert;
        this.roomName = roomName;
        this.selectedSubjectList = selectedSubjectList;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public Integer[] getSelectedSubjectList() {
        return selectedSubjectList;
    }

    public void setSelectedSubjectList(Integer[] selectedSubjectList) {
        this.selectedSubjectList = selectedSubjectList;
    }
}
