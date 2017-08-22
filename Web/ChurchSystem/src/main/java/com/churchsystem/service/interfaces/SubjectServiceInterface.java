package com.churchsystem.service.interfaces;

import com.churchsystem.entity.DisplayedSubjectEntity;
import com.churchsystem.entity.SubjectEntity;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */
public interface SubjectServiceInterface {
    List<DisplayedSubjectEntity> getDisplayedSubject();

    List<DisplayedSubjectEntity> getDisplayedEvent();

    SubjectEntity getSubjectById(int subId);

    List<DisplayedSubjectEntity> getDisplayedClass();
}
