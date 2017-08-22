package com.churchsystem.service;

import com.churchsystem.entity.SubjectEntity;
import com.churchsystem.model.interfaces.SubjectModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {
    @InjectMocks
    SubjectService subjectService = new SubjectService();

    @Mock
    SubjectModelInterface subjectModelInterface;
    @Test
    public void getDisplayedSubject() throws Exception {

    }

    @Test
    public void getSubjectById() throws Exception {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubId(1);
        Mockito.when(subjectModelInterface.getSubjectById(1)).thenReturn(subjectEntity);
        assertEquals(subjectService.getSubjectById(1),subjectEntity);

    }

    @Test
    public void getDisplayedClass() throws Exception {
    }

}