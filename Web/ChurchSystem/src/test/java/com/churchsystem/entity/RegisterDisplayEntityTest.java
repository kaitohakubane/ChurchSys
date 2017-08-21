package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class RegisterDisplayEntityTest {
    @Test
    public void getRegisId() throws Exception {
        RegisterDisplayEntity registerDisplayEntity = new RegisterDisplayEntity();
        registerDisplayEntity.setRegisId(1);
        assertEquals(1,registerDisplayEntity.getRegisId());
    }

    @Test
    public void getUsername() throws Exception {
        RegisterDisplayEntity registerDisplayEntity = new RegisterDisplayEntity();
        registerDisplayEntity.setUsername("abc");
        assertEquals("abc",registerDisplayEntity.getUsername());
    }

    @Test
    public void getSubId() throws Exception {
        RegisterDisplayEntity registerDisplayEntity = new RegisterDisplayEntity();
        registerDisplayEntity.setSubId(1);
        assertEquals(1,registerDisplayEntity.getSubId());
    }

    @Test
    public void getSubName() throws Exception {
        RegisterDisplayEntity registerDisplayEntity = new RegisterDisplayEntity();
        registerDisplayEntity.setSubName("abc");
        assertEquals("abc",registerDisplayEntity.getSubName());
    }

    @Test
    public void getRegisDate() throws Exception {
    }

    @Test
    public void getEstTime() throws Exception {
    }

    @Test
    public void getMessage() throws Exception {
        RegisterDisplayEntity registerDisplayEntity = new RegisterDisplayEntity();
        registerDisplayEntity.setMessage("abc");
        assertEquals("abc",registerDisplayEntity.getMessage());
    }

    @Test
    public void getCategoryName() throws Exception {
        RegisterDisplayEntity registerDisplayEntity = new RegisterDisplayEntity();
        registerDisplayEntity.setCategoryName("abc");
        assertEquals("abc",registerDisplayEntity.getCategoryName());
    }

}