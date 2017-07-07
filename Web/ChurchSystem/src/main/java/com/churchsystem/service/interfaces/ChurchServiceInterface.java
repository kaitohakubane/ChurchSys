package com.churchsystem.service.interfaces;

import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.ChurchMapEntity;

import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
public interface ChurchServiceInterface {
    ChurchEntity getChurchById(int churchId);
    void updateChurch(ChurchEntity churchEntity);
    List<ChurchMapEntity> getNearbyChurch(Double latitude, Double longitude, int radius );
}
