package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Service
@Transactional
public class ChurchService implements ChurchServiceInterface {
    @Autowired
    ChurchModelInterface churchModelInterface;

    @Override
    public ChurchEntity getChurchById(int churchId) {
        return churchModelInterface.getChurchById(churchId);
    }


    @Override
    public void updateChurch(ChurchEntity churchEntity) {
        churchModelInterface.updateChurch(churchEntity);
    }

    @Override
    public List<ChurchMapEntity> getNearbyChurch(Double latitude, Double longitude, int radius) {
        return churchModelInterface.getNearbyChurch(latitude, longitude, radius);
    }

    @Override
    public List<ChurchDisplayEntity> getAllChurch() {
        return churchModelInterface.getAllChurch();
    }

    @Override
    public ChurchInfoEntity getChurchInfo(int churchId) {
        return churchModelInterface.getChurchInfo(churchId);
    }

    @Override
    public List<IncomingEventEntity> getIncomingEvent(int userId) {
        return churchModelInterface.getIncomingEvent(userId);
    }

    @Override
    public SettingEntity getSettingOfChurch(int churchId) {
        return churchModelInterface.getSettingOfChurch(churchId);
    }

    @Override
    public void editSetting(int churchId, int isSync) {
        SettingEntity settingEntity = churchModelInterface.getSettingOfChurch(churchId);
        if (settingEntity == null) {
            if (isSync == 1) {
                SettingEntity newSetting = new SettingEntity();
                newSetting.setChurchId(churchId);
                newSetting.setIsSync(isSync);
                churchModelInterface.addSetting(newSetting);
            }
        } else {
            settingEntity.setIsSync(isSync);
            churchModelInterface.updateSetting(settingEntity);
        }
    }
}

