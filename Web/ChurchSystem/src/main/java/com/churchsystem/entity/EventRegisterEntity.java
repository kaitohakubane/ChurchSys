package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public class EventRegisterEntity {
    private int typeId;
    private String description;
    private int roomId;
    private String roomName;
    private int managerId;
    private String managerName;

    public EventRegisterEntity(int typeId, String description, int roomId, String roomName, int managerId, String managerName) {
        this.typeId = typeId;
        this.description = description;
        this.roomId = roomId;
        this.roomName = roomName;
        this.managerId = managerId;
        this.managerName = managerName;
    }

    public EventRegisterEntity() {
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
