package com.churchsystem.service.interfaces;

import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.entity.SlotEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public interface EventServiceInterface {
    List<EventDisplayEntity> getListOfEvent(int churchId);
    List<EventDisplayEntity> getListOfPublicEvent(int churchId);
    SlotEntity createEvent(String eventName, java.sql.Date eventDate, int subId, int slotHour, boolean privacy, int churchId);
    SlotEntity mappingResource(java.sql.Date date, int subId, int conductorId, int churchId, int slotHour);
    EventDataEntity getCreatedEvent(int slotId);
}
