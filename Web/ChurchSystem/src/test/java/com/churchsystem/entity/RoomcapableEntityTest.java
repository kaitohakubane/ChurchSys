package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class RoomcapableEntityTest {
    @Test
    public void getRoomCapId() throws Exception {
        RoomcapableEntity roomcapableEntity = new RoomcapableEntity();
        roomcapableEntity.setRoomCapId(1);
        assertEquals(1,roomcapableEntity.getRoomCapId());
    }

    @Test
    public void getRoomId() throws Exception {
        RoomcapableEntity roomcapableEntity = new RoomcapableEntity();
        roomcapableEntity.setRoomId(1);
        assertEquals((Integer)1,roomcapableEntity.getRoomId());
    }

    @Test
    public void getSubId() throws Exception {
        RoomcapableEntity roomcapableEntity = new RoomcapableEntity();
        roomcapableEntity.setSubId(1);
        assertEquals((Integer)1,roomcapableEntity.getSubId());
    }

}