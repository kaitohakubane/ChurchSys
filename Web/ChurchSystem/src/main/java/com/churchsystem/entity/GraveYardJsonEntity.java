package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */
public class GraveYardJsonEntity {
    private Integer graveYardId;
    private String status;
    private String name;
    private Integer x;
    private Integer y;

    public Integer getGraveYardId() {
        return graveYardId;
    }

    public void setGraveYardId(Integer graveYardId) {
        this.graveYardId = graveYardId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
