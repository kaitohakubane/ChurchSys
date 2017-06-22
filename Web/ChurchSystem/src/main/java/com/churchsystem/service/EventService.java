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
    public List<EventDisplayEntity> getCreatedEvent(int eventId){
        List<EventDataEntity> eventDataEntities= eventModelInterface.getCreatedEvent(eventId);
        List<EventDisplayEntity> result=new ArrayList<EventDisplayEntity>();
        for(int i=0;i<eventDataEntities.size();i++){
            EventDisplayEntity item=new EventDisplayEntity(eventDataEntities.get(i));
            result.add(item);
        }
        return result;
    }


    @Override
    public void createEvent(String eventName, Date eventDate,int subId, int slotHour,boolean privacy, int churchId){
        EventEntity inputEvent=new EventEntity();
        inputEvent.setChurchId(churchId);
        inputEvent.setEventStatus(ParamConstant.CONFLICT_STATUS);
        inputEvent.setStartDate(eventDate);
        inputEvent.setEventName(eventName);
        inputEvent.setSubId(subId);
        inputEvent.setPrivacy(privacy);
        eventModelInterface.addNewEvent(inputEvent);
    }


    public SlotEntity createSlotForEvent( Date eventDate, int slotHour, int churchId,int subId){
        //Need to fix
        EventEntity eventEntity= eventModelInterface.getCreatingEvent(eventDate,ParamConstant.CONFLICT_STATUS,subId,churchId);
        int conductorId=userModelInterface.getSuitableConductorForSlot(slotHour,eventDate,churchId);
        int roomId=roomModelInterface.getSuitableRoomForSlot(slotHour,eventDate,churchId);

        SlotEntity slotEntity=new SlotEntity();
        slotEntity.setEventId(eventEntity.getEventId());
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(eventDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }

    @Override
    public void mappingResource(int eventId,int slotHour){
//        EventEntity eventEntity= eventModelInterface.getCreatingEvent(date,ParamConstant.APPROVE_STATUS,subId,churchId);
//        SlotEntity slotEntity=slotModelInterface.getUnassignedEventSlot(conductorId);

        List<SlotEntity> slotEntities=slotModelInterface.getSlotByEventId(eventId);
        for(int i=0;i<slotEntities.size();i++){
            InclusionEntity inclusionEntity=new InclusionEntity();
            inclusionEntity.setSlotHourId(slotHour);
            inclusionEntity.setSlotId(slotEntities.get(i).getSlotId());
            slotModelInterface.mappingSlotHour(inclusionEntity);
        }
    }
}
