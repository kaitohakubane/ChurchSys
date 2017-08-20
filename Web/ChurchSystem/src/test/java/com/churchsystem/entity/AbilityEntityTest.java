package com.churchsystem.entity;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/18/2017.
 */
public class AbilityEntityTest {
    int testvalue = 2;
    @Test
    public void getAbilityId() throws Exception {
       AbilityEntity abilityEntity=new AbilityEntity();
       abilityEntity.setAbilityId(1);
       assertEquals(1,abilityEntity.getAbilityId());
    }

    @Test
    public void setAbilityId() throws Exception {

        AbilityEntity abilityEntity = new AbilityEntity();
        abilityEntity.setAbilityId(testvalue);
        assertEquals(testvalue,abilityEntity.getAbilityId());
    }

    @Test
    public void getConductorId() throws Exception {
        AbilityEntity abilityEntity = new AbilityEntity();
        abilityEntity.setConductorId(1);
        assertEquals((Integer) 1,abilityEntity.getConductorId());
    }

    @Test
    public void setConductorId() throws Exception {
        AbilityEntity abilityEntity = new AbilityEntity();
        abilityEntity.setConductorId(testvalue);
        assertEquals((Integer) testvalue,abilityEntity.getConductorId());

    }

    @Test
    public void getSubId() throws Exception {
        AbilityEntity abilityEntity = new AbilityEntity();
        abilityEntity.setSubId(1);
        assertEquals((Integer)1,abilityEntity.getSubId());
    }

    @Test
    public void setSubId() throws Exception {
        AbilityEntity abilityEntity = new AbilityEntity();
        abilityEntity.setSubId(testvalue);
        assertEquals((Integer) testvalue,abilityEntity.getSubId());
    }

}