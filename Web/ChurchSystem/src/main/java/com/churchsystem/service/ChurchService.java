package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
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
    public void editSetting(int churchId, int isSync,int theme) {
        SettingEntity settingEntity = churchModelInterface.getSettingOfChurch(churchId);
        if (settingEntity == null) {
            if (isSync == 1) {
                SettingEntity newSetting = new SettingEntity();
                newSetting.setChurchId(churchId);
                newSetting.setIsSync(isSync);
                newSetting.setTheme(theme);
                churchModelInterface.addSetting(newSetting);
            }
        } else {
            settingEntity.setIsSync(isSync);
            settingEntity.setTheme(theme);
            churchModelInterface.updateSetting(settingEntity);
        }
    }

    @Override
    public List<IncomingEventEntity> getIncomingEventByChurchId(int churchId) {
        return churchModelInterface.getIncomingEventByChurchId(churchId);
    }

    @Override
    public List<IncomingClassEntity> getIncomingClassByChurchId(int churchId) {
        return churchModelInterface.getIncomingClassByChurchId(churchId);
    }

    @Override
    public void createChurch(ChurchEntity churchEntity) {
        churchModelInterface.createChurch(churchEntity);
        churchEntity = churchModelInterface.getChurchByInfo(churchEntity.getLongitude(), churchEntity.getLatitude());
        SettingEntity settingEntity = new SettingEntity();
        settingEntity.setChurchId(churchEntity.getChurchId());
        settingEntity.setIsSync(ParamConstant.IS_NOT_SYNC);
        settingEntity.setTheme(ParamConstant.CHURCH_THEME_0);
        churchModelInterface.createSetting(settingEntity);
    }


}

