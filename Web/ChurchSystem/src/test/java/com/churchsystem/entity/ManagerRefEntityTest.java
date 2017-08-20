package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class ManagerRefEntityTest {
    @Test
    public void getManagerId() throws Exception {
        ManagerRefEntity managerRefEntity = new ManagerRefEntity();
        managerRefEntity.setManagerId(1);
        assertEquals(1,managerRefEntity.getManagerId());
    }

    @Test
    public void getManagerName() throws Exception {
        ManagerRefEntity managerRefEntity =new ManagerRefEntity();
        managerRefEntity.setManagerName("ABC");
        assertEquals("ABC",managerRefEntity.getManagerName());
    }

}