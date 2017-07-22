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
}
