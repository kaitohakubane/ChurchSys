package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class RegisteredClassEntityTest {
    @Test
    public void getSubId() throws Exception {
        RegisteredClassEntity registeredClassEntity = new RegisteredClassEntity();
        registeredClassEntity.setSubId(1);
        assertEquals(1,registeredClassEntity.getSubId());
    }

    @Test
    public void getSubName() throws Exception {
        RegisteredClassEntity registeredClassEntity = new RegisteredClassEntity();
        registeredClassEntity.setSubName("abc");
        assertEquals("abc",registeredClassEntity.getSubName());
    }

    @Test
    public void getNumOfRegistration() throws Exception {
        RegisteredClassEntity registeredClassEntity = new RegisteredClassEntity();
        registeredClassEntity.setNumOfRegistration(1);
        assertEquals(1,registeredClassEntity.getNumOfRegistration());
    }

}