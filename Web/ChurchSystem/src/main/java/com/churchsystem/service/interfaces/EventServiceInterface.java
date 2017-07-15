package com.churchsystem.service.interfaces;

import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.entity.EventEntity;
import com.churchsystem.entity.SlotEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public interface EventServiceInterface {
    List<EventDisplayEntity> getListOfEvent(int churchId);

    List<EventDisplayEntity> getListOfPublicEvent(int churchId);

    void createEvent(String eventName, Date eventDate, int subId, boolean privacy,
                     int churchId, Date examDate, Integer typeId, boolean isRegistered, int numberOfSlot);

    void mappingResource(int slotId, int slotHour);

    EventEntity getEventById(int eventId);

    List<EventDisplayEntity> getCreatedEvent(int slotId);

    SlotEntity createSlotForEvent(Date eventDate, int slotHour, int churchId, int subId, int eventId);

    SlotEntity createSlotForClass(int eventId, int slotHour, int churchId, int roomId, int conductorId, Date itemDate);

    EventEntity getCreatingEvent(Date date, int status, int subId, int churchId, boolean isRegistered);

    void updateEvent(EventEntity eventEntity);

    EventDataEntity getEventBySlotId(int slotId, int churchId);

    SlotEntity createSlotForUserEvent(int eventId, Time startTime, Time endTime, int churchId, Date itemDate);

    Integer getCategoryIdFromSlotId(int slotId);
}
