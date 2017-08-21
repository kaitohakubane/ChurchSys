package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class RoomEntityTest {
    @Test
    public void getRoomId() throws Exception {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(1);
        assertEquals(1,roomEntity.getRoomId());
    }

    @Test
    public void getRoomName() throws Exception {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomName("abc");
        assertEquals("abc",roomEntity.getRoomName());
    }

    @Test
    public void getChurchId() throws Exception {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setChurchId(1);
        assertEquals((Integer)1,roomEntity.getChurchId());
    }

    @Test
    public void getRoomStatus() throws Exception {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomStatus(1);
        assertEquals((Integer)1,roomEntity.getRoomStatus());
    }

}