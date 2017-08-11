package com.churchsystem.model.interfaces;

import com.churchsystem.entity.GraveDisplayEntity;
import com.churchsystem.entity.GraveEntity;
import com.churchsystem.entity.GraveyardEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */
public interface GraveModelInterface {
    List<GraveyardEntity> getGraveYardOfChurch(int churchId);

    List<GraveDisplayEntity> getGraveOfGraveYard(int graveYardId);

    void addGrave(GraveEntity graveEntity);

    void updateGrave(GraveEntity graveEntity);

    void addGraveYard(GraveyardEntity graveYardEntity);

    void updateGraveYard(GraveyardEntity graveYardEntity);

    GraveyardEntity getGraveYardById(int graveYardId);

    GraveDisplayEntity getGravebyId(int graveYardId);

    GraveEntity getCreatingGrave(int graveYardId,int status);

    List<GraveDisplayEntity> getChurchGrave(int churchId);
}
