package com.churchsystem.service;

import com.churchsystem.entity.RegisteredClassEntity;
import com.churchsystem.model.interfaces.RegisteredClassModelInterface;
import com.churchsystem.service.interfaces.RegisteredClassServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */
@Service
@Transactional
public class RegisteredClassService implements RegisteredClassServiceInterface {
    @Autowired
    RegisteredClassServiceInterface registeredClassServiceInterface;

    public List<RegisteredClassEntity> getNumberOfRegisteredClassByChurchId(int churchId) {
        List<RegisteredClassEntity> result = registeredClassServiceInterface.getNumberOfRegisteredClassByChurchId(churchId);
        return result;
    }
}
