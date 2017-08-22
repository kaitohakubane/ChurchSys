package com.churchsystem.service;

import com.churchsystem.entity.RoomEntity;
import com.churchsystem.model.interfaces.RoomModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {
    @InjectMocks
    RoomService roomService = new RoomService();

    @Mock
    RoomModelInterface roomModelInterface;

    @Test
    public void getRoomByNameAndChurchId() throws Exception {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomName("101");
        roomEntity.setChurchId(1);
        roomEntity.setRoomStatus(1);
        Mockito.when(roomModelInterface.getRoomByNameAndChurchId("101", 1, 1)).thenReturn(roomEntity);
        assertEquals(roomService.getRoomByNameAndChurchId("101", 1, 1), roomEntity);
    }

    @Test
    public void getRoomById() throws Exception {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(1);
        Mockito.when(roomModelInterface.getRoomById(1)).thenReturn(roomEntity);
        assertEquals(roomService.getRoomById(1), roomEntity);
    }

    @Test
    public void getRoomBySub() throws Exception {

    }

    @Test
    public void getSuitableRoomForSlot() throws Exception {
    }

    @Test
    public void getLastSuitableRoomForSlot() throws Exception {
    }

    @Test
    public void getListSuitableRoomForSlot() throws Exception {
    }

    @Test
    public void getIdListSuitableRoomForSlot() throws Exception {
    }

    @Test
    public void getAllRoom() throws Exception {
    }


}