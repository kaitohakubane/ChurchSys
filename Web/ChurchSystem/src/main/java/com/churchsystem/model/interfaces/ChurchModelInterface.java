package com.churchsystem.model.interfaces;

import com.churchsystem.entity.*;

import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
public interface ChurchModelInterface {
    ChurchEntity getChurchById(int churchId);

    void updateChurch(ChurchEntity churchEntity);

    List<ChurchMapEntity> getNearbyChurch(Double latitude, Double longitude, int radius);

    List<ChurchDisplayEntity> getAllChurch();

    ChurchInfoEntity getChurchInfo(int churchId);

    List<IncomingEventEntity> getIncomingEvent(int userId);

    SettingEntity getSettingOfChurch(int churchId);
}
