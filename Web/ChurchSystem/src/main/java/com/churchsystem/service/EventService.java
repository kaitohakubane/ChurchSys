package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
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
import java.util.Calendar;
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
        if (eventName.equals("")) {
            eventName = ParamConstant.NO_NAME_EVENT_TITLE;
        }
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
        Integer conductorId = userModelInterface.getSuitableConductorForSlot(slotHour, eventDate, churchId, subId);
        Integer roomId = roomModelInterface.getSuitableRoomForSlot(slotHour, eventDate, churchId, subId);
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
    public SlotEntity createSlotForClass(int eventId, int slotHour, int churchId, int roomId, int conductorId, Date itemDate, int subId) {
        //Need to fix
        SlotEntity slotEntity = new SlotEntity();
        if (userModelInterface.checkConductorForSlot(slotHour, itemDate, churchId, conductorId, subId) == null ||
                roomModelInterface.checkRoomForSlot(slotHour, itemDate, churchId, roomId, subId) == null) {
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
    public SlotEntity createSlotForUserEvent(int eventId, Time startTime, Time endTime, int churchId, Date itemDate, int subId) {
        Integer conductorId = null;
        Integer roomId = null;

        List<Integer> listConductorId = userModelInterface.getIdListSuitableConductorForSlot(startTime, endTime, itemDate, churchId, subId);
        List<Integer> listRoomId = roomModelInterface.getIdListSuitableRoomForSlot(startTime, endTime, itemDate, churchId, subId);
        if(listConductorId.size()>0){
            conductorId=listConductorId.get(UtilsConstant.ZERO);
        }

        if(listRoomId.size()>0){
            roomId=listRoomId.get(UtilsConstant.ZERO);
        }

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
    public Integer getCategoryIdFromSlotId(int slotId) {
        return eventModelInterface.getCategoryIdFromSlotId(slotId);
    }

    @Override
    public void deleteEvent(int eventId) {
        eventModelInterface.deleteEvent(eventId);
    }

    @Override
    public Integer checkIsManySlot(int slotId) {
        try {
            List<SlotEntity> slotEntities = slotModelInterface.getListSlotOfClass(slotId);
            if (slotEntities.size() == UtilsConstant.ONE) {
                return UtilsConstant.IS_ONE_SLOT;
            } else if (slotEntities.size() > UtilsConstant.ONE) {
                return UtilsConstant.IS_MANY_SLOT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UtilsConstant.ERROR;
    }

    @Override
    public void changeStatusToFinish(int churchId) {
        try {
            Date curDate = DateUtils.getCurrentDate();
            List<EventEntity> eventEntities = eventModelInterface.getListEventOfChurch(churchId);
            for (int i = 0; i < eventEntities.size(); i++) {
                List<SlotEntity> slotEntities = slotModelInterface.getSlotByEventId(eventEntities.get(i).getEventId());
                for (int j = 0; j < slotEntities.size(); j++) {
                    if (slotEntities.get(j).getSlotDate().compareTo(curDate) < 0) {
                        slotEntities.get(j).setSlotStatus(ParamConstant.SLOT_FINISH_STATUS);
                        slotModelInterface.updateSlot(slotEntities.get(j));
                    }
                }
                if(slotEntities.get(slotEntities.size()-1).getSlotStatus()== ParamConstant.SLOT_FINISH_STATUS){
                    changeEventStatus(eventEntities.get(i),ParamConstant.EVENT_FINISH_STATUS);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeEventStatus(EventEntity eventEntity, int status) {
        eventEntity.setEventStatus(status);
        eventModelInterface.updateEvent(eventEntity);
    }

    @Override
    public void updateEventNameAndPrivacy(SlotEntity slotEntity ,String eventName, boolean privacy){
        EventEntity eventEntity = eventModelInterface.getEventById(slotEntity.getEventId());
        eventEntity.setEventName(eventName);
        eventEntity.setPrivacy(privacy);
        eventModelInterface.updateEvent(eventEntity);
    }

    @Override
    public void updateRepeatSlot(SlotEntity slotEntity,ArrayList<Integer> slotHour ){
        slotModelInterface.updateSlot(slotEntity);

        slotModelInterface.deleteSlotHourBySlotId(slotEntity.getSlotId());

        for (int i = 0; i < slotHour.size(); i++) {
            mappingResource(slotEntity.getSlotId(), slotHour.get(i));
        }
    }
}
