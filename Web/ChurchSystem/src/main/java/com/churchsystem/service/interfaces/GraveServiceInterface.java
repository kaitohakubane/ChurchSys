package com.churchsystem.service.interfaces;

import com.churchsystem.entity.GraveDisplayEntity;
import com.churchsystem.entity.GraveEntity;
import com.churchsystem.entity.GraveyardEntity;

import java.util.List;

/**
 * Created by Trung on 7/30/2017.
 */
public interface GraveServiceInterface {
    List<GraveyardEntity> getGraveYardOfChurch(int churchId);

    List<GraveDisplayEntity> getGraveOfGraveYard(int graveYardId);

    void addGrave(GraveEntity graveEntity);

    void updateGrave(GraveEntity graveEntity);

    void addGraveYard(GraveyardEntity graveYardEntity);

    void updateGraveYard(GraveyardEntity graveYardEntity);

    GraveyardEntity getGraveYardById(int graveYardId);

    List<GraveyardEntity> generateType1Prototype(int width, int height, int churchId);

    GraveDisplayEntity getGravebyId(int graveId);

    GraveEntity getCreatingGrave(int graveYardId,int status);

    List<GraveDisplayEntity> getChurchGrave(int churchId);

    GraveyardEntity getCreatingGraveYard(int churchId);

    GraveEntity getGrave(int graveId);
}
