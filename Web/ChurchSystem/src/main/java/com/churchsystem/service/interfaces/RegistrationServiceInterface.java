package com.churchsystem.service.interfaces;

import com.churchsystem.entity.ClassDisplayEntity;
import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.entity.RegisteredClassEntity;
import com.churchsystem.entity.RegistrationEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */

public interface RegistrationServiceInterface {
    List<RegisterDisplayEntity> getRegistration();
    List<RegisteredClassEntity> getNumberOfRegisteredClassByChurchId(int churchId);
    List<RegistrationEntity> getRegistrationBySubId(int subId);
    void updateRegistration(RegistrationEntity registrationEntity);
    void addNewRegistration(int userId,int churchId,int subId,int eventId,String message);
    List<RegistrationEntity> getWaitingRegistrationBySubId(int subId);
    List<ClassDisplayEntity> getOnPlanClass(int churchId);
    List<ClassDisplayEntity> getOnGoingPlanClass(int churchId);
}
