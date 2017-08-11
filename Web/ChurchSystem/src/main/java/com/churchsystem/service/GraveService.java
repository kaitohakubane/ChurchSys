package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.GraveDisplayEntity;
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
    public List<GraveDisplayEntity> getGraveOfGraveYard(int graveId) {
        return graveModelInterface.getGraveOfGraveYard(graveId);
    }

    @Override
    public void addGrave(GraveEntity graveEntity) {
        graveModelInterface.addGrave(graveEntity);
    }

    @Override
    public List<GraveyardEntity> generateType1Prototype(int width, int height, int churchId) {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setChurchId(churchId);
        int count=ParamConstant.GRAVE_YARD_DEFAULT_START_NUMBER;
        for (int j = 0; j < height; j++) {
            if (j == 0 || j == (height - 1)) {
                for (int i = 0; i < width; i++) {
                    //Gate position
                    if (j == (height - 1) && i == (width - 2)) {
                        graveyardEntity = new GraveyardEntity();
                        graveyardEntity.setChurchId(churchId);
                        graveyardEntity.setName(ParamConstant.GATE_DEFAULT_NAME);
                        graveyardEntity.setX(i);
                        graveyardEntity.setY(j);
                        graveyardEntity.setStatus(ParamConstant.GRAVE_YARD_GATE);
                        graveModelInterface.addGraveYard(graveyardEntity);
                    }else{
                        graveyardEntity = new GraveyardEntity();
                        graveyardEntity.setChurchId(churchId);
                        graveyardEntity.setName(ParamConstant.GRAVE_YARD_DEFAULT_NAME+count);
                        count++;
                        graveyardEntity.setX(i);
                        graveyardEntity.setY(j);
                        graveyardEntity.setStatus(ParamConstant.GRAVE_YARD_NOT_INITIAL);
                        graveModelInterface.addGraveYard(graveyardEntity);
                    }

                }
            } else {
                graveyardEntity = new GraveyardEntity();
                graveyardEntity.setChurchId(churchId);
                graveyardEntity.setName(ParamConstant.GRAVE_YARD_DEFAULT_NAME+count);
                count++;
                graveyardEntity.setX(0);
                graveyardEntity.setY(j);
                graveyardEntity.setStatus(ParamConstant.GRAVE_YARD_NOT_INITIAL);
                graveModelInterface.addGraveYard(graveyardEntity);

                graveyardEntity = new GraveyardEntity();
                graveyardEntity.setChurchId(churchId);
                graveyardEntity.setName(ParamConstant.GRAVE_YARD_DEFAULT_NAME+count);
                count++;
                graveyardEntity.setX(width - 1);
                graveyardEntity.setY(j);
                graveyardEntity.setStatus(ParamConstant.GRAVE_YARD_NOT_INITIAL);
                graveModelInterface.addGraveYard(graveyardEntity);
            }
        }

        graveyardEntity = new GraveyardEntity();
        graveyardEntity.setChurchId(churchId);
        graveyardEntity.setName(ParamConstant.STATUE_DEFAULT_NAME);
        graveyardEntity.setX((width - 1) / 2);
        graveyardEntity.setY(1);
        graveyardEntity.setStatus(ParamConstant.GRAVE_YARD_STATUE);
        graveModelInterface.addGraveYard(graveyardEntity);
        return graveModelInterface.getGraveYardOfChurch(churchId);
    }

    @Override
    public GraveyardEntity getGraveYardById(int graveYardId){
        return graveModelInterface.getGraveYardById(graveYardId);
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

    @Override
    public GraveDisplayEntity getGravebyId(int graveYardId){
        return graveModelInterface.getGravebyId(graveYardId);
    }

    @Override
    public GraveEntity getCreatingGrave(int graveYardId,int status){
        return graveModelInterface.getCreatingGrave(graveYardId,status);
    }

    @Override
    public List<GraveDisplayEntity> getChurchGrave(int churchId){
        return graveModelInterface.getChurchGrave(churchId);
    }
}
