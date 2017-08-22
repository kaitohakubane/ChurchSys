package com.churchsystem.service;

import com.churchsystem.entity.RegistrationEntity;
import com.churchsystem.model.interfaces.RegistrationModelInterface;
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
public class RegistrationServiceTest {
    @InjectMocks
    RegistrationService registrationService = new RegistrationService();

    @Mock
    RegistrationModelInterface registrationModelInterface;
    @Test
    public void getRegistration() throws Exception {
    }

    @Test
    public void getNumberOfRegisteredClassByChurchId() throws Exception {
    }

    @Test
    public void getRegistrationBySubId() throws Exception {
    }

    @Test
    public void getWaitingRegistrationBySubId() throws Exception {
    }

    @Test
    public void getOnPlanClass() throws Exception {
    }

    @Test
    public void getOnGoingPlanClass() throws Exception {
    }

    @Test
    public void getRegistrationByEventId() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setEventId(1);
        Mockito.when(registrationModelInterface.getRegistrationByEventId(1)).thenReturn(registrationEntity);
        assertEquals(registrationService.getRegistrationByEventId(1),registrationEntity);

    }

    @Test
    public void getAllRegisEvent() throws Exception {
    }

    @Test
    public void getAllRegisClass() throws Exception {
    }

    @Test
    public void getRegistrationById() throws Exception {
        RegistrationEntity registrationEntity =  new RegistrationEntity();
        registrationEntity.setRegisId(1);
        Mockito.when(registrationModelInterface.getRegistrationById(1)).thenReturn(registrationEntity);
        assertEquals(registrationService.getRegistrationById(1),registrationEntity);
    }

}