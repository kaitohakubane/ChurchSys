package com.churchsystem.service.interfaces;

import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.entity.SlotEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public interface EventServiceInterface {
    List<EventDisplayEntity> getListOfEvent(int churchId);
    List<EventDisplayEntity> getListOfPublicEvent(int churchId);
    void createEvent(String eventName,Date eventDate, int subId, int slotHour, boolean privacy, int churchId);
    void mappingResource(int eventId,int slotHour);
    List<EventDisplayEntity> getCreatedEvent(int slotId);
    SlotEntity createSlotForEvent(Date eventDate, int slotHour, int churchId, int subId);
}
