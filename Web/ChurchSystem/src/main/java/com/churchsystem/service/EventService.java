package com.churchsystem.service;

import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.model.interfaces.EventModelInterface;
import com.churchsystem.service.interfaces.EventServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
@Service
@Transactional
public class EventService implements EventServiceInterface {
    @Autowired
    EventModelInterface eventModelInterface;

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
    public void createEvent(String eventName, Date eventDate,int subId, int slotHour){


    }
}
