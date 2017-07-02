package com.churchsystem.model.interfaces;

import com.churchsystem.entity.ChurchEntity;

/**
 * Created by Mr Kiet on 06/14/17.
 */
public interface ChurchModelInterface {
    ChurchEntity getChurchById(int churchId);
    void updateChurch(ChurchEntity churchEntity);
}
