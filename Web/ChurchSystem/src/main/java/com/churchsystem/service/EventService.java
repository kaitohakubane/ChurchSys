package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.EventModelInterface;
import com.churchsystem.model.interfaces.RoomModelInterface;
import com.churchsystem.model.interfaces.SlotModelInterface;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.EventServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.tags.Param;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
@Service
@Transactional
public class EventService implements EventServiceInterface {
    @Autowired
    EventModelInterface eventModelInterface;

    @Autowired
    RoomModelInterface roomModelInterface;

    @Autowired
    UserModelInterface userModelInterface;

    @Autowired
    SlotModelInterface slotModelInterface;


    @Override
    public List<EventDisplayEntity> getListOfEvent(int churchId) {

        List<EventDataEntity> data = eventModelInterface.getListOfEvent(churchId);
        List<EventDisplayEntity> result = convertEventData(data);
        return result;
    }

    @Override
    public List<EventDisplayEntity> getListOfPublicEvent(int churchId) {
        List<EventDataEntity> data = eventModelInterface.getListOfPublicEvent(churchId);
        List<EventDisplayEntity> result = convertEventData(data);
        return result;
    }

    public List<EventDisplayEntity> convertEventData(List<EventDataEntity> data) {
        List<EventDisplayEntity> listEvent = new ArrayList<EventDisplayEntity>();
        for (int i = 0; i < data.size(); i++) {
            EventDataEntity eventDataEntity = data.get(i);
            EventDisplayEntity item = new EventDisplayEntity(eventDataEntity);
            listEvent.add(item);
        }
        return listEvent;
    }

    @Override
    public List<EventDisplayEntity> getCreatedEvent(int eventId) {
        List<EventDataEntity> eventDataEntities = eventModelInterface.getCreatedEvent(eventId);
        List<EventDisplayEntity> result = new ArrayList<EventDisplayEntity>();
        for (int i = 0; i < eventDataEntities.size(); i++) {
            EventDisplayEntity item = new EventDisplayEntity(eventDataEntities.get(i));
            result.add(item);
        }
        return result;
    }


    @Override
    public void createEvent(String eventName, Date eventDate, int subId, boolean privacy, int churchId
            , Date examDate, Integer typeId, boolean isRegistered, int numberOfSlot) {
        EventEntity inputEvent = new EventEntity();
        inputEvent.setChurchId(churchId);
        inputEvent.setEventStatus(ParamConstant.WAITING_FOR_APPROVE_STATUS);
        inputEvent.setStartDate(eventDate);
        inputEvent.setEventName(eventName);
        inputEvent.setSubId(subId);
        inputEvent.setPrivacy(privacy);
        inputEvent.setTypeId(typeId);
        inputEvent.setExamDate(examDate);
        inputEvent.setRegistered(isRegistered);
        inputEvent.setNumOfSlot(numberOfSlot);
        eventModelInterface.addNewEvent(inputEvent);
    }

    @Override
    public SlotEntity createSlotForEvent(Date eventDate, int slotHour, int churchId, int subId, int eventId) {
        //Need to fix
        Integer conductorId = userModelInterface.getSuitableConductorForSlot(slotHour, eventDate, churchId);
        Integer roomId = roomModelInterface.getSuitableRoomForSlot(slotHour, eventDate, churchId);
        SlotEntity slotEntity = new SlotEntity();
        if (conductorId == null || roomId == null) {
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
        } else {
            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
        }

        slotEntity.setEventId(eventId);
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(eventDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }

    @Override
    public EventEntity getEventById(int eventId) {
        return eventModelInterface.getEventById(eventId);
    }

    @Override
    public SlotEntity createSlotForClass(int eventId, int slotHour, int churchId, int roomId, int conductorId, Date itemDate) {
        //Need to fix
        SlotEntity slotEntity = new SlotEntity();
        if (userModelInterface.checkConductorForSlot(slotHour, itemDate, churchId, conductorId) == null ||
                roomModelInterface.checkRoomForSlot(slotHour, itemDate, churchId, roomId) == null) {
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
        } else {
            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
        }
        slotEntity.setEventId(eventId);
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(itemDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }


    @Override
    public void mappingResource(int slotId, int slotHour) {
        InclusionEntity inclusionEntity = new InclusionEntity();
        inclusionEntity.setSlotHourId(slotHour);
        inclusionEntity.setSlotId(slotId);
        slotModelInterface.mappingSlotHour(inclusionEntity);

    }

    @Override
    public SlotEntity createSlotForUserEvent(int eventId, Time startTime, Time endTime, int churchId, Date itemDate) {
        Integer conductorId = userModelInterface.getIdListSuitableConductorForSlot(startTime, endTime, itemDate, churchId).get(UtilsConstant.ZERO);
        Integer roomId = roomModelInterface.getIdListSuitableRoomForSlot(startTime, endTime, itemDate, churchId).get(UtilsConstant.ZERO);
        SlotEntity slotEntity = new SlotEntity();

        if (conductorId == null || roomId == null) {
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
        } else {
            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
        }

        slotEntity.setEventId(eventId);
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(itemDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }


    @Override
    public EventEntity getCreatingEvent(Date date, int status, int subId, int churchId, boolean isRegistered) {
        return eventModelInterface.getCreatingEvent(date, status, subId, churchId, isRegistered);
    }

    @Override
    public void updateEvent(EventEntity eventEntity) {
        eventModelInterface.updateEvent(eventEntity);
    }

    @Override
    public EventDataEntity getEventBySlotId(int slotId, int churchId) {
        return eventModelInterface.getEventBySlotId(slotId, churchId);
    }

    @Override
    public Integer getCategoryIdFromSlotId(int slotId){
        return eventModelInterface.getCategoryIdFromSlotId(slotId);
    }

}
