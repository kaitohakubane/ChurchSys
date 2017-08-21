package com.churchsystem.entity;

/**
 * Created by Trung on 7/30/2017.
 */
public class GraveYardJsonEntity {
    private Integer graveYardId;
    private Integer status;
    private String name;
    private Integer x;
    private Integer y;

    public Integer getGraveYardId() {
        return graveYardId;
    }

    public void setGraveYardId(Integer graveYardId) {
        this.graveYardId = graveYardId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
