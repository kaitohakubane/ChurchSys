package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class UserRegistrationInformationTest {
    @Test
    public void getUserName() throws Exception {
        UserRegistrationInformation userRegistrationInformation = new UserRegistrationInformation();
        userRegistrationInformation.setUserName("abc");
        assertEquals("abc",userRegistrationInformation.getUserName());
    }

    @Test
    public void getPhone() throws Exception {
        UserRegistrationInformation userRegistrationInformation = new UserRegistrationInformation();
        userRegistrationInformation.setPhone("abc");
        assertEquals("abc",userRegistrationInformation.getPhone());
    }

    @Test
    public void getMail() throws Exception {
        UserRegistrationInformation userRegistrationInformation = new UserRegistrationInformation();
        userRegistrationInformation.setMail("abc");
        assertEquals("abc",userRegistrationInformation.getMail());
    }

    @Test
    public void getDescription() throws Exception {
        UserRegistrationInformation userRegistrationInformation = new UserRegistrationInformation();
        userRegistrationInformation.setDescription("abc");
        assertEquals("abc",userRegistrationInformation.getDescription());
    }

}