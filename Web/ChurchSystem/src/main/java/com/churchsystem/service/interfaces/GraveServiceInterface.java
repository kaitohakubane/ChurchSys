package com.churchsystem.service.interfaces;

import com.churchsystem.entity.GraveEntity;
import com.churchsystem.entity.GraveyardEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */
public interface GraveServiceInterface {
    List<GraveyardEntity> getGraveYardOfChurch(int churchId);
    List<GraveEntity> getGraveOfGraveYard(int graveYardId);
    void addGrave(GraveEntity graveEntity);
    void updateGrave(GraveEntity graveEntity);
    void addGraveYard(GraveyardEntity graveYardEntity);
    void updateGraveYard(GraveyardEntity graveYardEntity);
    List<GraveyardEntity> generateType1Prototype(int width, int height, int churchId);
}
