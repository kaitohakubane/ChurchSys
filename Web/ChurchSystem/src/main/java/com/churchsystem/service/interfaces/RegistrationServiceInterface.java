package com.churchsystem.service.interfaces;

import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.entity.RegisteredClassEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */

public interface RegistrationServiceInterface {
    List<RegisterDisplayEntity> getRegistration();
    List<RegisteredClassEntity> getNumberOfRegisteredClassByChurchId(int churchId);
}
