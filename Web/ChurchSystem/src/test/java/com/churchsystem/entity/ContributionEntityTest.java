package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class ContributionEntityTest {
    @Test
    public void getContributeId() throws Exception {
        ContributionEntity contributionEntity = new ContributionEntity();
        contributionEntity.setContributeId(1);
        assertEquals(1, contributionEntity.getContributeId());
    }

    @Test
    public void getChurchId() throws Exception {
        ContributionEntity contributionEntity = new ContributionEntity();
        contributionEntity.setChurchId(1);
        assertEquals((Integer) 1, contributionEntity.getChurchId());
    }

    @Test
    public void getDonate() throws Exception {
        ContributionEntity contributionEntity = new ContributionEntity();
        contributionEntity.setDonate("1000000");
        assertEquals("1000000",contributionEntity.getDonate());
    }

}