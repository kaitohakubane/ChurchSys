package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class ManagementJsonEntityTest {
    @Test
    public void getRoomName() throws Exception {
        ManagementJsonEntity managementJsonEntity = new ManagementJsonEntity();
        managementJsonEntity.setRoomName("thánh đường");
        assertEquals("thánh đường",managementJsonEntity.getRoomName());
    }

    @Test
    public void getUserName() throws Exception {
        ManagementJsonEntity managementJsonEntity = new ManagementJsonEntity();
        managementJsonEntity.setUserName("test1");
        assertEquals("test1",managementJsonEntity.getUserName());
    }

    @Test
    public void getAccountId() throws Exception {
        ManagementJsonEntity managementJsonEntity = new ManagementJsonEntity();
        managementJsonEntity.setAccountId("1");
        assertEquals("1",managementJsonEntity.getAccountId());
    }

    @Test
    public void getEmail() throws Exception {
        ManagementJsonEntity managementJsonEntity = new ManagementJsonEntity();
        managementJsonEntity.setEmail("hungmc@gmail.com");
        assertEquals("hungmc@gmail.com",managementJsonEntity.getEmail());
    }

    @Test
    public void getPhone() throws Exception {
        ManagementJsonEntity managementJsonEntity = new ManagementJsonEntity();
        managementJsonEntity.setPhone("0123456789");
        assertEquals("0123456789",managementJsonEntity.getPhone());
    }

    @Test
    public void getCert() throws Exception {
        ManagementJsonEntity managementJsonEntity = new ManagementJsonEntity();
        managementJsonEntity.setCert("Linh Muc");
        assertEquals("Linh Muc",managementJsonEntity.getCert());
    }

    @Test
    public void getSelectedSubjectList() throws Exception {
        ManagementJsonEntity managementJsonEntity = new ManagementJsonEntity();
        managementJsonEntity.getSelectedSubjectList();
        assertEquals(null,managementJsonEntity.getSelectedSubjectList());
    }

}