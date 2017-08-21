package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class SlotEntityTest {
    @Test
    public void getSlotId() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setSlotId(1);
        assertEquals(1,slotEntity.getSlotId());
    }

    @Test
    public void getEventId() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setEventId(1);
        assertEquals((Integer)1,slotEntity.getEventId());
    }

    @Test
    public void getRoomId() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setRoomId(1);
        assertEquals((Integer)1,slotEntity.getRoomId());
    }

    @Test
    public void getConductorId() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setConductorId(1);
        assertEquals((Integer)1,slotEntity.getConductorId());
    }

    @Test
    public void getSlotDate() throws Exception {
    }

    @Test
    public void getSlotStatus() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setSlotStatus(1);
        assertEquals((Integer)1,slotEntity.getSlotStatus());
    }

    @Test
    public void getStreamLink() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setStreamLink("abc");
        assertEquals("abc",slotEntity.getStreamLink());
    }

    @Test
    public void getStreamCode() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setStreamCode("abc");
        assertEquals("abc",slotEntity.getStreamCode());
    }

    @Test
    public void getIsStream() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setIsStream(1);
        assertEquals((Integer)1,slotEntity.getIsStream());
    }

}