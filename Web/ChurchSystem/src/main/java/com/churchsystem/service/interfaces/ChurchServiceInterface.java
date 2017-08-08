package com.churchsystem.service.interfaces;

import com.churchsystem.entity.*;

import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
public interface ChurchServiceInterface {
    ChurchEntity getChurchById(int churchId);

    void updateChurch(ChurchEntity churchEntity);

    List<ChurchMapEntity> getNearbyChurch(Double latitude, Double longitude, int radius);

    List<ChurchDisplayEntity> getAllChurch();

    ChurchInfoEntity getChurchInfo(int churchId);

    List<IncomingEventEntity> getIncomingEvent(int userId);

    SettingEntity getSettingOfChurch(int churchId);

    void editSetting(int churchId, int isSync,int theme);

    List<IncomingEventEntity> getIncomingEventByChurchId(int churchId);

    List<IncomingClassEntity> getIncomingClassByChurchId(int churchId);

    void createChurch(ChurchEntity churchEntity);

}
