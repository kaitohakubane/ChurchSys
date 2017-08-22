package com.churchsystem.service;

import com.churchsystem.entity.DashboardClassEntity;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventEntity;
import com.churchsystem.model.interfaces.EventModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {
    @InjectMocks
    EventService eventService = new EventService();

    @Mock
    EventModelInterface eventModelInterface;

    @Test
    public void getEventById() throws Exception {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventId(1);
        Mockito.when(eventModelInterface.getEventById(1)).thenReturn(eventEntity);
        assertEquals(eventService.getEventById(1), eventEntity);
    }

    @Test
    public void getEventBySlotId() throws Exception {
        EventDataEntity eventDataEntity = new EventDataEntity();
        eventDataEntity.setSlotId(3);
        Mockito.when(eventModelInterface.getEventBySlotId(3, 1)).thenReturn(eventDataEntity);
        assertEquals(eventService.getEventBySlotId(3, 1), eventDataEntity);
    }

    @Test
    public void getListOfEvent() throws Exception {
    }

    @Test
    public void getListOfEventData() throws Exception {
    }

    @Test
    public void getListOfPublicEvent() throws Exception {
    }

    @Test
    public void getCreatedEvent() throws Exception {

    }

    @Test
    public void getCategoryIdFromSlotId() throws Exception {


    }

    @Test
    public void getUserRegisteredClass() throws Exception {

    }

}