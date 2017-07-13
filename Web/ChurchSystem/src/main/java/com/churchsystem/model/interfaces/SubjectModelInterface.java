package com.churchsystem.model.interfaces;

import com.churchsystem.entity.DisplayedSubjectEntity;
import com.churchsystem.entity.SubjectEntity;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */
public interface SubjectModelInterface {
    List<DisplayedSubjectEntity> getDisplayedSubject();

    SubjectEntity getSubjectById(int subId);
}
