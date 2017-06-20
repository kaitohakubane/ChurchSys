package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.EventModelInterface;
import com.churchsystem.model.interfaces.RoomModelInterface;
import com.churchsystem.model.interfaces.SlotModelInterface;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.EventServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public EventDataEntity getCreatedEvent(int slotId){
        return eventModelInterface.getCreatedEvent(slotId);
    }


    @Override
    public SlotEntity createEvent(String eventName, Date eventDate,int subId, int slotHour,boolean privacy, int churchId){
        EventEntity inputEvent=new EventEntity();
        inputEvent.setChurchId(churchId);
        inputEvent.setEventStatus(ParamConstant.APPROVE_STATUS);
        inputEvent.setStartDate(eventDate);
        inputEvent.setEventName(eventName);
        inputEvent.setSubId(subId);
        inputEvent.setPrivacy(privacy);
        eventModelInterface.addNewEvent(inputEvent);

        //Need to fix

        int conductorId=userModelInterface.getSuitableConductorForSlot(slotHour);
        int roomId=roomModelInterface.getSuitableRoomForSlot(slotHour);


        SlotEntity slotEntity=new SlotEntity();
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(eventDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }

    @Override
    public SlotEntity mappingResource(Date date,int subId,int conductorId,int churchId,int slotHour){
        EventEntity eventEntity= eventModelInterface.getCreatingEvent(date,ParamConstant.APPROVE_STATUS,subId,churchId);
        SlotEntity slotEntity=slotModelInterface.getUnassignedEventSlot(conductorId);
        slotEntity.setEventId(eventEntity.getEventId());
        InclusionEntity inclusionEntity=new InclusionEntity();
        inclusionEntity.setSlotHourId(slotHour);
        inclusionEntity.setSlotId(slotEntity.getSlotId());
        slotModelInterface.mappingSlotHour(inclusionEntity);
        return slotEntity;
    }
}
