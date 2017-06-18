package com.churchsystem.service;

import com.churchsystem.entity.DisplayedSubjectEntity;
import com.churchsystem.model.interfaces.SubjectModelInterface;
import com.churchsystem.service.interfaces.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */

@Service
@Transactional
public class SubjectService implements SubjectServiceInterface {
    @Autowired
    SubjectModelInterface subjectModelInterface;

    public List<DisplayedSubjectEntity> getDisplayedSubject() {
        List<DisplayedSubjectEntity> result = subjectModelInterface.getDisplayedSubject();
        return result;
    }
}
