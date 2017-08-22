package com.churchsystem.service;

import com.churchsystem.entity.SlotEntity;
import com.churchsystem.entity.TypeEntity;
import com.churchsystem.model.interfaces.SlotModelInterface;
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
public class SlotServiceTest {
    @InjectMocks
    SlotService slotService = new SlotService();

    @Mock
    SlotModelInterface slotModelInterface;
    @Test
    public void getListOfSlotHour() throws Exception {
    }

    @Test
    public void getTypeByDescription() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setDescription("ABC");
        Mockito.when(slotModelInterface.getTypeByDescription("ABC")).thenReturn(typeEntity);
        assertEquals(slotService.getTypeByDescription("ABC"),typeEntity);
    }

    @Test
    public void getTypeByLoopTypeAndKind() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setLoopType(1);
        typeEntity.setKind(1);
        typeEntity.setDescription("ABC");
        Mockito.when(slotModelInterface.getTypeByLoopTypeAndKind(1,1,"ABC")).thenReturn(typeEntity);
        assertEquals(slotService.getTypeByLoopTypeAndKind(1,1,"ABC"),typeEntity);
    }

    @Test
    public void getSlotById() throws Exception {
        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setSlotId(1);
        Mockito.when(slotModelInterface.getSlotById(1)).thenReturn(slotEntity);
        assertEquals(slotService.getSlotById(1),slotEntity);
    }

    @Test
    public void getSlotByEventId() throws Exception {

    }

    @Test
    public void getSlotHourByTimeRange() throws Exception {
    }

    @Test
    public void getListSlotOfClass() throws Exception {
    }

    @Test
    public void getListSlotHourByTime() throws Exception {
    }

}