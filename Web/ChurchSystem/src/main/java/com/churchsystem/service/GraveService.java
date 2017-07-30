package com.churchsystem.service;

import com.churchsystem.entity.GraveEntity;
import com.churchsystem.entity.GraveyardEntity;
import com.churchsystem.model.interfaces.GraveModelInterface;
import com.churchsystem.service.interfaces.GraveServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */
@Service
@Transactional
public class GraveService implements GraveServiceInterface {
    @Autowired
    GraveModelInterface graveModelInterface;

    @Override
    public List<GraveyardEntity> getGraveYardOfChurch(int churchId) {
        return graveModelInterface.getGraveYardOfChurch(churchId);
    }

    @Override
    public List<GraveEntity> getGraveOfGraveYard(int graveYardId) {
        return graveModelInterface.getGraveOfGraveYard(graveYardId);
    }

    @Override
    public void addGrave(GraveEntity graveEntity) {
        graveModelInterface.addGrave(graveEntity);
    }

    @Override
    public void updateGrave(GraveEntity graveEntity) {
        graveModelInterface.updateGrave(graveEntity);
    }

    @Override
    public void addGraveYard(GraveyardEntity graveYardEntity) {
        graveModelInterface.addGraveYard(graveYardEntity);
    }

    @Override
    public void updateGraveYard(GraveyardEntity graveYardEntity) {
        graveModelInterface.updateGraveYard(graveYardEntity);
    }
}
