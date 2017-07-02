package com.churchsystem.service.interfaces;

import com.churchsystem.entity.ChurchEntity;

/**
 * Created by Mr Kiet on 06/14/17.
 */
public interface ChurchServiceInterface {
    ChurchEntity getChurchById(int churchId);
    void updateChurch(ChurchEntity churchEntity);
}
