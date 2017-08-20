package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class IncomingEventEntityTest {
    @Test
    public void getEventId() throws Exception {
        IncomingEventEntity incomingEventEntity = new IncomingEventEntity();
        incomingEventEntity.setEventId(1);
        assertEquals(1,incomingEventEntity.getEventId());
    }

    @Test
    public void getEventName() throws Exception {
        IncomingEventEntity incomingEventEntity = new IncomingEventEntity();
        incomingEventEntity.setEventName("ABC");
        assertEquals("ABC",incomingEventEntity.getEventName());
    }

    @Test
    public void getChurchId() throws Exception {
        IncomingEventEntity incomingEventEntity = new IncomingEventEntity();
        incomingEventEntity.setChurchId(1);
        assertEquals(1,incomingEventEntity.getChurchId());
    }

    @Test
    public void getChurchName() throws Exception {
        IncomingEventEntity incomingEventEntity = new IncomingEventEntity();
        incomingEventEntity.setChurchName("HoaKhanh");
        assertEquals("HoaKhanh",incomingEventEntity.getChurchName());
    }

    @Test
    public void getSubId() throws Exception {
        IncomingEventEntity incomingEventEntity = new IncomingEventEntity();
        incomingEventEntity.setSubId(1);
        assertEquals(1,incomingEventEntity.getSubId());
    }

    @Test
    public void getSubName() throws Exception {
        IncomingEventEntity incomingEventEntity = new IncomingEventEntity();
        incomingEventEntity.setSubName("Dự Tòng");
        assertEquals("Dự Tòng", incomingEventEntity.getSubName());
    }

}