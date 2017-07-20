package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ClassDisplayEntity;
import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.entity.RegisteredClassEntity;
import com.churchsystem.entity.RegistrationEntity;
import com.churchsystem.model.interfaces.RegistrationModelInterface;
import com.churchsystem.service.interfaces.RegistrationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Service
@Transactional
public class RegistrationService implements RegistrationServiceInterface {
    @Autowired
    RegistrationModelInterface registrationModelInterface;

    @Override
    public List<RegisterDisplayEntity> getRegistration() {
        return registrationModelInterface.getRegistration();
    }

    @Override
    public List<RegisteredClassEntity> getNumberOfRegisteredClassByChurchId(int churchId) {
        List<RegisteredClassEntity> result = registrationModelInterface.getNumberOfRegisteredClassByChurchId(churchId);
        return result;
    }

    @Override
    public List<RegistrationEntity> getRegistrationBySubId(int subId) {
        return registrationModelInterface.getRegistrationBySubId(subId);
    }

    @Override
    public void updateRegistration(RegistrationEntity registrationEntity) {
        registrationModelInterface.updateRegistration(registrationEntity);
    }

    @Override
    public void addRegistration(int userId, int churchId, int subId, int eventId, String message) {
        RegistrationEntity entity = new RegistrationEntity();
        entity.setUserId(userId);
        entity.setChurchId(churchId);
        entity.setSubId(subId);
        entity.setEventId(eventId);
        entity.setMessage(message);
        entity.setRegisStatus(ParamConstant.REGISTRATION_WAITING_STATUS);
        entity.setRegisDate(new Timestamp(System.currentTimeMillis()));
        registrationModelInterface.addRegistration(entity);
    }

    @Override
    public List<RegistrationEntity> getWaitingRegistrationBySubId(int subId) {
        return registrationModelInterface.getWaitingRegistrationBySubId(subId);
    }

    @Override
    public List<ClassDisplayEntity> getOnPlanClass(int churchId) {
        return registrationModelInterface.getOnPlanClass(churchId);
    }

    @Override
    public List<ClassDisplayEntity> getOnGoingPlanClass(int churchId) {
        return registrationModelInterface.getOnGoingPlanClass(churchId);
    }
}
