package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class IncomingClassEntityTest {
    @Test
    public void getEventId() throws Exception {
        IncomingClassEntity incomingClassEntity = new IncomingClassEntity();
        incomingClassEntity.setEventId(1);
        assertEquals(1,incomingClassEntity.getEventId());
    }

    @Test
    public void getEventName() throws Exception {
        IncomingClassEntity incomingClassEntity = new IncomingClassEntity();
        incomingClassEntity.setEventName("ABC");
        assertEquals("ABC",incomingClassEntity.getEventName());
    }

    @Test
    public void getStartDate() throws Exception {

    }

    @Test
    public void getSubName() throws Exception {
        IncomingClassEntity incomingClassEntity = new IncomingClassEntity();
        incomingClassEntity.setSubName("ABC");
        assertEquals("ABC",incomingClassEntity.getSubName());
    }

    @Test
    public void getInfo() throws Exception {
    }

}