package com.churchsystem.service.interfaces;

import com.churchsystem.entity.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public interface EventServiceInterface {
    List<EventDisplayEntity> getListOfEvent(int churchId);

    List<EventDisplayEntity> getListOfPublicEvent(int churchId);

    void createEvent(String eventName, Date eventDate, int subId, boolean privacy, int churchId
            , Date examDate, Integer typeId, boolean isRegistered, int numberOfSlot, Timestamp createdTime);

    void mappingResource(int slotId, int slotHour);

    EventEntity getEventById(int eventId);

    List<EventDisplayEntity> getCreatedEvent(int eventId, String token) throws IOException;

    SlotEntity createSlotForEvent(Date eventDate, int slotHour, int churchId, int subId, int eventId, int conductorId,
                                  int roomId);

    SlotEntity createSlotForClass(int eventId, int slotHour, int churchId, Integer roomId, Integer conductorId, Date itemDate, int subId);

    EventEntity getCreatingEvent(Date date, int status, int subId, int churchId, boolean isRegistered, Timestamp time);

    void updateEvent(EventEntity eventEntity);

    EventDataEntity getEventBySlotId(int slotId, int churchId);

    SlotEntity createSlotForAdvanceEvent(int eventId, Time startTime, Time endTime, Date itemDate, int churchId, int subId);

    SlotEntity createSlotForUserEvent(int eventId, Time startTime, Time endTime, int churchId, Date itemDate, int subId);

    Integer getCategoryIdFromSlotId(int slotId);

    void deleteEvent(int eventId);

    Integer checkIsManySlot(int slotId);

    void changeEventStatus(EventEntity eventEntity, int status);

    void changeStatusToFinish(int churchId);

    void updateEventNameAndPrivacy(SlotEntity slotEntity, String eventName, boolean privacy);

    String updateGoogleCalendarEvent(SlotEntity slotEntity, Time startTime, Time endTime, String eventName) throws IOException;

    List<Integer> checkEventSlot(Date eventDate, int slotHour, int churchId, int subId);

    List<Integer> checkEventClass(List<Date> eventDate, int slotHour, int churchId, int subId);

    int checkConductorForClass(SlotEntity slotEntity, Time startTime, Time endTime, int newConductorId, int churchId, int subId, Integer currentConductorId);

    int checkRoomForClass(SlotEntity slotEntity, Time startTime, Time endTime, int newRoomId, int churchId, int subId, Integer currentRoomId);

    List<EventDataEntity> getListOfEventData(int churchId);

    List<DashboardClassEntity> getUserRegisteredClass(int userId);

    int checkAdvanceCreate(List<Date> eventDate, Time startTime, Time endTime, int churchId, int subId);

}
