package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class GraveDisplayEntityTest {
    @Test
    public void getUserIdentity() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setUserIdentity("1");
        assertEquals("1",graveDisplayEntity.getUserIdentity());
    }

    @Test
    public void getGraveId() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setGraveId(1);
        assertEquals(1,graveDisplayEntity.getGraveId());
    }

    @Test
    public void getGraveYardId() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setGraveYardId(1);
        assertEquals((Integer) 1, graveDisplayEntity.getGraveYardId());
    }

    @Test
    public void getUserId() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setUserId(1);
        assertEquals((Integer) 1,graveDisplayEntity.getUserId());
    }

    @Test
    public void getName() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setName("ABC");
        assertEquals("ABC",graveDisplayEntity.getName());
    }

    @Test
    public void getBirthDay() throws Exception {
    }

    @Test
    public void getImage() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setImage("axxxx");
        assertEquals("axxxx",graveDisplayEntity.getImage());
    }

    @Test
    public void getDeathDay() throws Exception {
    }

    @Test
    public void getHomeTown() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setHomeTown("ABC");
        assertEquals("ABC",graveDisplayEntity.getHomeTown());
    }

    @Test
    public void getParish() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setParish("AVC");
        assertEquals("AVC",graveDisplayEntity.getParish());
    }

    @Test
    public void getX() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setX(1);
        assertEquals((Integer) 1,graveDisplayEntity.getX());
    }

    @Test
    public void getY() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setY(1);
        assertEquals((Integer) 1,graveDisplayEntity.getY());
    }

    @Test
    public void getStatus() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setStatus(1);
        assertEquals((Integer) 1,graveDisplayEntity.getStatus());

    }

    @Test
    public void getTel() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setTel("0123456789");
        assertEquals("0123456789",graveDisplayEntity.getTel());

    }

    @Test
    public void getUserName() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setUserName("ABC");
        assertEquals("ABC",graveDisplayEntity.getUserName());
    }

}