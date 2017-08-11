package com.churchsystem.entity;

import java.sql.Date;

/**
 * Created by hungmcse61561-admin on 8/5/2017.
 */
public class GraveDisplayEntity {
    private int graveId;
    private Integer graveYardId;
    private Integer userId;
    private String name;
    private Date birthDay;
    private String image;
    private Date deathDay;
    private String homeTown;
    private String parish;
    private Integer x;
    private Integer y;
    private Integer status;
    private String email;
    private String tel;
    private String userName;

    public GraveDisplayEntity() {

    }

    public GraveDisplayEntity(int graveId, Integer graveYardId, Integer userId, String name, Date birthDay, String image, Date deathDay, String homeTown, String parish, Integer x, Integer y, Integer status, String email, String tel, String userName) {
        this.graveId = graveId;
        this.graveYardId = graveYardId;
        this.userId = userId;
        this.name = name;
        this.birthDay = birthDay;
        this.image = image;
        this.deathDay = deathDay;
        this.homeTown = homeTown;
        this.parish = parish;
        this.x = x;
        this.y = y;
        this.status = status;
        this.email = email;
        this.tel = tel;
        this.userName = userName;
    }

    public int getGraveId() {
        return graveId;
    }

    public void setGraveId(int graveId) {
        this.graveId = graveId;
    }

    public Integer getGraveYardId() {
        return graveYardId;
    }

    public void setGraveYardId(Integer graveYardId) {
        this.graveYardId = graveYardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Date deathDay) {
        this.deathDay = deathDay;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}