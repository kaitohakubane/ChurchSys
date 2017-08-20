package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class EventEntityTest {
    int typedefualt = 1;
    @Test
    public void getEventId() throws Exception {
       EventEntity eventEntity = new EventEntity();
       eventEntity.setEventId(1);
       assertEquals(1,eventEntity.getEventId());
    }

    @Test
    public void getEventName() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventName("AVC");
        assertEquals("AVC",eventEntity.getEventName());
    }

    @Test
    public void getNumOfSlot() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setNumOfSlot(4);
        assertEquals((Integer) 4, eventEntity.getNumOfSlot());
    }

    @Test
    public void getChurchId() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setChurchId(1);
        assertEquals((Integer) 1,eventEntity.getChurchId());
    }

    @Test
    public void getEventStatus() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventStatus(1);
        assertEquals((Integer) 1, eventEntity.getEventStatus());
    }

    @Test
    public void getExamDate() throws Exception {
    }

    @Test
    public void getSubId() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setSubId(1);
        assertEquals((Integer) 1,eventEntity.getSubId());
    }

    @Test
    public void getTypeId() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setTypeId(1);
        assertEquals((Integer) 1,eventEntity.getTypeId());
    }

    @Test
    public void getDescription() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setDescription("aAVC");
        assertEquals("aAVC",eventEntity.getDescription());
    }

    @Test
    public void getPrivacy() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setPrivacy(true);
        assertEquals(true,eventEntity.getPrivacy());
    }

    @Test
    public void getRegistered() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setRegistered(true);
        assertEquals(true,eventEntity.getRegistered());
    }

}