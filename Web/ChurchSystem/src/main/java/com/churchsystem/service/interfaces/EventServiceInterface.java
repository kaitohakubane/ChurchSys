package com.churchsystem.service.interfaces;

import com.churchsystem.entity.EventDataEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
public interface EventServiceInterface {
    List<EventDataEntity> getListOfEvent();
}
