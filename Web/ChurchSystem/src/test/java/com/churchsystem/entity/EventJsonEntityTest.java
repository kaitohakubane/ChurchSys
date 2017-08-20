package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class EventJsonEntityTest {
    @Test
    public void getToken() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setToken("adasda");
        assertEquals("adasda",eventJsonEntity.getToken());
    }

    @Test
    public void getEventName() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setEventName("Test1");
        assertEquals("Test1",eventJsonEntity.getEventName());
    }

    @Test
    public void getSlotDate() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setSlotDate("2017/8/20");
        assertEquals("2017/8/20",eventJsonEntity.getSlotDate());
    }
    @Test
    public void getSubId() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setSubId("1");
        assertEquals("1",eventJsonEntity.getSubId());

    }

    @Test
    public void getSlotHour() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setSlotHour("12:00:00");
        assertEquals("12:00:00",eventJsonEntity.getSlotHour());
    }

    @Test
    public void getPrivacy() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setPrivacy("true");
        assertEquals("true", eventJsonEntity.getPrivacy());
    }

    @Test
    public void getTypeString() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setTypeString("246");
        assertEquals("246",eventJsonEntity.getTypeString());
    }

    @Test
    public void getNumOfSlot() throws Exception {
        EventJsonEntity  eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setNumOfSlot("5");
        assertEquals("5",eventJsonEntity.getNumOfSlot());
    }

    @Test
    public void getExamDate() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setExamDate("2017/11/18");
        assertEquals("2017/11/18",eventJsonEntity.getExamDate());

    }

    @Test
    public void getType() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setType("246");
        assertEquals("246",eventJsonEntity.getType());
    }

    @Test
    public void getSlotId() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setSlotId("4");
        assertEquals("4",eventJsonEntity.getSlotId());
    }

    @Test
    public void getConductorId() throws Exception {
        EventJsonEntity eventJsonEntity = new EventJsonEntity();
        eventJsonEntity.setConductorId("1");
        assertEquals("1",eventJsonEntity.getConductorId());
    }

    @Test
    public void getRoomId() throws Exception {
        EventJsonEntity eventJsonEntity  = new EventJsonEntity();
        eventJsonEntity.setRoomId("1");
        assertEquals("1",eventJsonEntity.getRoomId());
    }

}