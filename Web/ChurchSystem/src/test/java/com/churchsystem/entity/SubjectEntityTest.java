package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class SubjectEntityTest {
    @Test
    public void getSubId() throws Exception {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubId(1);
        assertEquals(1,subjectEntity.getSubId());
    }

    @Test
    public void getSubName() throws Exception {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubName("abc");
        assertEquals("abc",subjectEntity.getSubName());
    }

    @Test
    public void getCategoryId() throws Exception {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setCategoryId(1);
        assertEquals((Integer)1,subjectEntity.getCategoryId());
    }

}