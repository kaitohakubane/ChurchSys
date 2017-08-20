package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class EventDisplayEntityTest {
    @Test
    public void getEventStatus() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setEventStatus(1);
        assertEquals(1,eventDisplayEntity.getEventStatus());

    }

    @Test
    public void getStreamLink() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setStreamLink("abcxyz");
        assertEquals("abcxyz", eventDisplayEntity.getStreamLink());
    }

    @Test
    public void getStreamCode() throws Exception {
        EventDisplayEntity eventDisplayEntity= new EventDisplayEntity();
        eventDisplayEntity.setStreamCode("zxccvb");
        assertEquals("zxccvb", eventDisplayEntity.getStreamCode());
    }

    @Test
    public void getStatus() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setStatus(1);
        assertEquals((Integer) 1, eventDisplayEntity.getStatus());
    }

    @Test
    public void getSlotId() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setSlotId(4);
        assertEquals(4,eventDisplayEntity.getSlotId());
    }

    @Test
    public void getTitle() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setTitle("ABC");
        assertEquals("ABC",eventDisplayEntity.getTitle());
    }

    @Test
    public void getSubName() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setSubName("ẤuNhi");
        assertEquals("ẤuNhi",eventDisplayEntity.getSubName());
    }

    @Test
    public void getStart() throws Exception {
    }

    @Test
    public void getEnd() throws Exception {
    }

    @Test
    public void getConductorName() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setConductorName("Kiet");
        assertEquals("Kiet",eventDisplayEntity.getConductorName());
    }

    @Test
    public void getRoomName() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setRoomName("101");
        assertEquals("101",eventDisplayEntity.getRoomName());
    }

    @Test
    public void getPrivacy() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setPrivacy(1);
        assertEquals(1,eventDisplayEntity.getPrivacy());
    }

    @Test
    public void getDescription() throws Exception {
        EventDisplayEntity eventDisplayEntity = new EventDisplayEntity();
        eventDisplayEntity.setDescription("avava");
        assertEquals("avava",eventDisplayEntity.getDescription());
    }

}