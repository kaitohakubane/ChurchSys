package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class EventDataEntityTest {
    @Test
    public void getStreamLink() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setStreamLink("https://youtu.be/bWJEsEKX-jg");
        assertEquals("https://youtu.be/bWJEsEKX-jg",eventDataEntity.getStreamLink());
    }

    @Test
    public void getStreamCode() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setStreamCode("Dxcs");
        assertEquals("Dxcs",eventDataEntity.getStreamCode());

    }

    @Test
    public void getSlotId() throws Exception {
        EventDataEntity eventDataEntity= new EventDataEntity();
        eventDataEntity.setSlotId(1);
        assertEquals(1,eventDataEntity.getSlotId());
    }

    @Test
    public void getEventId() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setEventId(1);
        assertEquals(1,eventDataEntity.getEventId());
    }

    @Test
    public void getConductorId() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setConductorId(1);
        assertEquals((Integer) 1,eventDataEntity.getConductorId());
    }

    @Test
    public void getRoomId() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setRoomId(1);
        assertEquals((Integer) 1,eventDataEntity.getRoomId());
    }

    @Test
    public void getSubId() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setSubId(1);
        assertEquals((Integer) 1, eventDataEntity.getSubId());
    }

    @Test
    public void getSlotDate() throws Exception {
    }

    @Test
    public void getConductorName() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setConductorName("AVC");
        assertEquals("AVC",eventDataEntity.getConductorName());
    }

    @Test
    public void getRoomName() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setRoomName("101");
        assertEquals("101",eventDataEntity.getRoomName());
    }

    @Test
    public void getPrivacy() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setPrivacy(true);
        assertEquals(true,eventDataEntity.getPrivacy());
    }

    @Test
    public void getDescription() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setDescription("AVAC");
        assertEquals("AVAC", eventDataEntity.getDescription());
    }

    @Test
    public void getSubName() throws Exception {
        EventDataEntity eventDataEntity  = new EventDataEntity();
        eventDataEntity.setSubName("Hôn Nhân");
        assertEquals("Hôn Nhân",eventDataEntity.getSubName());
    }

    @Test
    public void getEventStatus() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setEventStatus(1);
        assertEquals((Integer) 1,eventDataEntity.getEventStatus());

    }

    @Test
    public void getEventName() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setEventName("Test1");
        assertEquals("Test1",eventDataEntity.getEventName());
    }

    @Test
    public void getStatus() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setEventStatus(1);
        assertEquals((Integer) 1,eventDataEntity.getEventStatus());
    }

}