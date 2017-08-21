package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class SlothourEntityTest {
    @Test
    public void getSlotHourId() throws Exception {
        SlothourEntity slothourEntity = new SlothourEntity();
        slothourEntity.setSlotHourId(1);
        assertEquals(1,slothourEntity.getSlotHourId());
    }

    @Test
    public void getSlotName() throws Exception {
        SlothourEntity slothourEntity = new SlothourEntity();
        slothourEntity.setSlotName("abc");
        assertEquals("abc",slothourEntity.getSlotName());
    }

    @Test
    public void getStartTime() throws Exception {
    }

    @Test
    public void getEndTime() throws Exception {
    }

}