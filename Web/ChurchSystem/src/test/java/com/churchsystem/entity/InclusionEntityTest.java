package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class InclusionEntityTest {

    @Test
    public void getInclusionId() throws Exception {
        InclusionEntity inclusionEntity = new InclusionEntity();
        inclusionEntity.setInclusionId(1);
        assertEquals(1,inclusionEntity.getInclusionId());
    }

    @Test
    public void getSlotId() throws Exception {
        InclusionEntity inclusionEntity = new InclusionEntity();
        inclusionEntity.setSlotId(5);
        assertEquals((Integer) 5,inclusionEntity.getSlotId());
    }

    @Test
    public void getSlotHourId() throws Exception {
        InclusionEntity inclusionEntity = new InclusionEntity();
        inclusionEntity.setSlotHourId(1);
        assertEquals((Integer) 1,inclusionEntity.getSlotHourId());
    }

}