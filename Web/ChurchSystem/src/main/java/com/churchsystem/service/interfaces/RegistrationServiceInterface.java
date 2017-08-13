package com.churchsystem.service.interfaces;

import com.churchsystem.entity.*;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */

public interface RegistrationServiceInterface {
    List<RegisterDisplayEntity> getRegistration();

    List<RegisteredClassEntity> getNumberOfRegisteredClassByChurchId(int churchId);

    List<RegistrationEntity> getRegistrationBySubId(int subId);

    void updateRegistration(RegistrationEntity registrationEntity);

    void addNewRegistration(int userId, int churchId, int subId, Integer eventId, String message);

    List<RegistrationEntity> getWaitingRegistrationBySubId(int subId);

    List<ClassDisplayEntity> getOnPlanClass(int churchId);

    List<ClassDisplayEntity> getOnGoingPlanClass(int churchId);

    RegistrationEntity getRegistrationByEventId(int eventId);

    List<RegisDisplayEntity> getAllRegisEvent(int churchId);

    List<RegisDisplayEntity> getAllRegisClass(int churchId);

    RegistrationEntity getRegistrationById(int regisId);

    void changeStatusToDisplay(List<ClassDisplayEntity> classList, List<RegistrationEntity> registrationEntities);
}
