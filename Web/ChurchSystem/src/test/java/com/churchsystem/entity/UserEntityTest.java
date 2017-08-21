package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class UserEntityTest {
    @Test
    public void getUserId() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(1);
        assertEquals(1,userEntity.getUserId());
    }

    @Test
    public void getAccountId() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccountId("abc");
        assertEquals("abc",userEntity.getAccountId());
    }

    @Test
    public void getPassword() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("abc");
        assertEquals("abc",userEntity.getPassword());
    }

    @Test
    public void getUserName() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("abc");
        assertEquals("abc",userEntity.getUserName());
    }

    @Test
    public void getRole() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setRole("abc");
        assertEquals("abc",userEntity.getRole());
    }

    @Test
    public void getTel() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setTel("abc");
        assertEquals("abc",userEntity.getTel());
    }

    @Test
    public void getCertificate() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setCertificate("abc");
        assertEquals("abc",userEntity.getCertificate());
    }

    @Test
    public void getAccountNum() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccountNum("abc");
        assertEquals("abc",userEntity.getAccountNum());
    }

    @Test
    public void getEnabled() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setEnabled(true);
        assertEquals(true,userEntity.getEnabled());
    }

    @Test
    public void getEmail() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("abc");
        assertEquals("abc",userEntity.getEmail());
    }

}