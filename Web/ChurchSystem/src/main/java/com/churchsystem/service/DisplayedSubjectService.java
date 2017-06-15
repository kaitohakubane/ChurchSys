package com.churchsystem.service;

import com.churchsystem.entity.DisplayedSubjectEntity;
import com.churchsystem.model.interfaces.DisplayedSubjectModelInterface;
import com.churchsystem.service.interfaces.DisplayedSubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */

@Service
@Transactional
public class DisplayedSubjectService implements DisplayedSubjectServiceInterface {
    @Autowired
    DisplayedSubjectModelInterface displayedSubjectModelInterface;

    public List<DisplayedSubjectEntity> getDisplayedSubject() {
        List<DisplayedSubjectEntity> result = displayedSubjectModelInterface.getDisplayedSubject();
        return result;
    }
}
