package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class RegisDisplayEntityTest {
    @Test
    public void getRegisId() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setRegisId(1);
        assertEquals(1,regisDisplayEntity.getRegisId());
    }

    @Test
    public void getRegisDate() throws Exception {

    }

    @Test
    public void getMessage() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setMessage("abc");
        assertEquals("abc",regisDisplayEntity.getMessage());
    }

    @Test
    public void getSlotDate() throws Exception {
    }

    @Test
    public void getStartTime() throws Exception {
    }

    @Test
    public void getEndTime() throws Exception {
    }

    @Test
    public void getEventId() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setEventId(1);
        assertEquals(1,regisDisplayEntity.getEventId());
    }

    @Test
    public void getEventName() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setEventName("abc");
        assertEquals("abc",regisDisplayEntity.getEventName());
    }

    @Test
    public void getSubId() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setSubId(1);
        assertEquals(1,regisDisplayEntity.getSubId());
    }

    @Test
    public void getSubName() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setSubName("abc");
        assertEquals("abc",regisDisplayEntity.getSubName());
    }

    @Test
    public void getUserId() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setUserId(1);
        assertEquals(1,regisDisplayEntity.getUserId());
    }

    @Test
    public void getAccountId() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setAccountId("abc");
        assertEquals("abc",regisDisplayEntity.getAccountId());
    }

    @Test
    public void getTel() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setTel("abc");
        assertEquals("abc",regisDisplayEntity.getTel());
    }

    @Test
    public void getEmail() throws Exception {
        RegisDisplayEntity regisDisplayEntity = new RegisDisplayEntity();
        regisDisplayEntity.setEmail("abc");
        assertEquals("abc",regisDisplayEntity.getEmail());
    }

    @Test
    public void getDate() throws Exception {
    }

    @Test
    public void getTime() throws Exception {
    }

    @Test
    public void getContact() throws Exception {
        RegisDisplayEntity regisDisplayEntity=new RegisDisplayEntity();
        regisDisplayEntity.setEmail("kaitohakubane@gmail.com");
        regisDisplayEntity.setTel("0918581533");
        assertEquals("Email: kaitohakubane@gmail.com<br/>SĐT: 0918581533",regisDisplayEntity.getContact());
    }

}