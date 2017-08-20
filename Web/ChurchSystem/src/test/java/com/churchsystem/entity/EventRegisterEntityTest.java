package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class EventRegisterEntityTest {
    @Test
    public void getTypeId() throws Exception {
        EventRegisterEntity eventRegisterEntity = new EventRegisterEntity();
        eventRegisterEntity.setTypeId(1);
        assertEquals(1, eventRegisterEntity.getTypeId());
    }

    @Test
    public void getDescription() throws Exception {
        EventRegisterEntity eventRegisterEntity = new EventRegisterEntity();
        eventRegisterEntity.setDescription("ABC");
        assertEquals("ABC",eventRegisterEntity.getDescription());
    }

    @Test
    public void getRoomId() throws Exception {
        EventRegisterEntity eventRegisterEntity = new EventRegisterEntity();
        eventRegisterEntity.setRoomId(1);
        assertEquals(1,eventRegisterEntity.getRoomId());
    }

    @Test
    public void getRoomName() throws Exception {
        EventRegisterEntity eventRegisterEntity = new EventRegisterEntity();
        eventRegisterEntity.setRoomName("ABC");
        assertEquals("ABC",eventRegisterEntity.getRoomName());
    }

    @Test
    public void getManagerId() throws Exception {
        EventRegisterEntity eventRegisterEntity = new EventRegisterEntity();
        eventRegisterEntity.setManagerId(1);
        assertEquals(1, eventRegisterEntity.getManagerId());
    }

    @Test
    public void getManagerName() throws Exception {
        EventRegisterEntity eventRegisterEntity = new EventRegisterEntity();
        eventRegisterEntity.setManagerName("Test1");
        assertEquals("Test1",eventRegisterEntity.getManagerName());
    }

}