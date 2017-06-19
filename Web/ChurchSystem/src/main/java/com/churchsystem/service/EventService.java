package com.churchsystem.service;

import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.model.interfaces.EventModelInterface;
import com.churchsystem.service.interfaces.EventServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<EventDataEntity> getListOfEvent(){
        return eventModelInterface.getListOfEvent();
    }
}
