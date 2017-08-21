package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class RegistrationEntityTest {
    @Test
    public void getRegisId() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setRegisId(1);
        assertEquals(1,registrationEntity.getRegisId());
    }

    @Test
    public void getEventId() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setEventId(1);
        assertEquals((Integer)1,registrationEntity.getEventId());
    }

    @Test
    public void getUserId() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setUserId(1);
        assertEquals((Integer)1,registrationEntity.getUserId());
    }

    @Test
    public void getChurchId() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setChurchId(1);
        assertEquals((Integer)1,registrationEntity.getChurchId());
    }

    @Test
    public void getSubId() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setSubId(1);
        assertEquals((Integer)1,registrationEntity.getSubId());
    }

    @Test
    public void getRegisDate() throws Exception {
    }

    @Test
    public void getRegisStatus() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setRegisStatus(1);
        assertEquals((Integer)1,registrationEntity.getRegisStatus());
    }

    @Test
    public void getResult() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setResult(1);
        assertEquals((Integer)1,registrationEntity.getResult());
    }

    @Test
    public void getMessage() throws Exception {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setMessage("abc");
        assertEquals("abc",registrationEntity.getMessage());
    }

}