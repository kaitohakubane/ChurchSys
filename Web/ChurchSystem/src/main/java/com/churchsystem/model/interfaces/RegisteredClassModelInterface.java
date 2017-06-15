package com.churchsystem.model.interfaces;

import com.churchsystem.entity.RegisteredClassEntity;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */
public interface RegisteredClassModelInterface {
    List<RegisteredClassEntity> getNumberOfRegistratedClassByChurchId(int churchId);
}
