package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public class ManagerRefEntity {
    private int managerId;
    private String managerName;

    public ManagerRefEntity(int managerId, String managerName) {
        this.managerId = managerId;
        this.managerName = managerName;
    }

    public ManagerRefEntity() {

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
