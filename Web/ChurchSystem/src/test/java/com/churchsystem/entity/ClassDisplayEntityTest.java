package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class ClassDisplayEntityTest {
    @Test
    public void getCateId() throws Exception {
        ClassDisplayEntity classDisplayEntity = new ClassDisplayEntity();
        classDisplayEntity.setCateId(1);
        assertEquals(1, classDisplayEntity.getCateId());
    }

    @Test
    public void getUserStatus() throws Exception {
        ClassDisplayEntity classDisplayEntity  = new ClassDisplayEntity() ;
        classDisplayEntity.setUserStatus(1);
        assertEquals(1,classDisplayEntity.getUserStatus());
    }

    @Test
    public void getConductorName() throws Exception {
        ClassDisplayEntity classDisplayEntity = new ClassDisplayEntity();
        classDisplayEntity.setConductorName("ABC");
        assertEquals("ABC", classDisplayEntity.getConductorName());
    }

    @Test
    public void getRoomName() throws Exception {
        ClassDisplayEntity classDisplayEntity = new ClassDisplayEntity();
        classDisplayEntity.setRoomName("Thánh Đường");
        assertEquals("Thánh Đường", classDisplayEntity.getRoomName());
    }

    @Test
    public void getEventId() throws Exception {
        ClassDisplayEntity classDisplayEntity = new ClassDisplayEntity();
        classDisplayEntity.setEventId(1);
        assertEquals(1, classDisplayEntity.getEventId());
    }

    @Test
    public void getEventName() throws Exception {
        ClassDisplayEntity classDisplayEntity = new ClassDisplayEntity();
        classDisplayEntity.setEventName("Hon Phoi");
        assertEquals("Hon Phoi", classDisplayEntity.getEventName());
    }

    @Test
    public void getStartDate() throws Exception {
    }

    @Test
    public void getTypeName() throws Exception {
        ClassDisplayEntity classDisplayEntity = new ClassDisplayEntity();
        classDisplayEntity.setTypeName("Test1");
        assertEquals("Test1", classDisplayEntity.getTypeName());
    }

    @Test
    public void getSubName() throws Exception {
        ClassDisplayEntity classDisplayEntity = new ClassDisplayEntity();
        classDisplayEntity.setSubName("Ấu Nhi 1");
        assertEquals("Ấu Nhi 1", classDisplayEntity.getSubName());
    }

}