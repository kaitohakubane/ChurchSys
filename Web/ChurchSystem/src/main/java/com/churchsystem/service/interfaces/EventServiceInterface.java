package com.churchsystem.service.interfaces;

import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventDisplayEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public interface EventServiceInterface {
    List<EventDisplayEntity> getListOfEvent(int churchId);
    List<EventDisplayEntity> getListOfPublicEvent(int churchId);
    void createEvent(String eventName, Date eventDate, int subId, int slotHour);
}
