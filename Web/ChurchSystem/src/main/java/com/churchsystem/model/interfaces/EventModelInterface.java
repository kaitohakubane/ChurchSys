package com.churchsystem.model.interfaces;

import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public interface EventModelInterface {
    List<EventDataEntity> getListOfEvent(int churchId);
    List<EventDataEntity> getListOfPublicEvent(int churchId);
    void addNewEvent(EventEntity eventEntity);
}
