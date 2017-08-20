package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class DisplayedSubjectEntityTest {
    @Test
    public void getSubId() throws Exception {
        DisplayedSubjectEntity displayedSubjectEntity = new DisplayedSubjectEntity();
        displayedSubjectEntity.setSubId(1);
        assertEquals(1,displayedSubjectEntity.getSubId() );
    }

    @Test
    public void getSubName() throws Exception {
        DisplayedSubjectEntity displayedSubjectEntity = new DisplayedSubjectEntity();
        displayedSubjectEntity.setSubName("AVC");
        assertEquals("AVC",displayedSubjectEntity.getSubName());
    }

    @Test
    public void getCategoryId() throws Exception {
        DisplayedSubjectEntity displayedSubjectEntity = new DisplayedSubjectEntity();
        displayedSubjectEntity.setCategoryId(1);
        assertEquals(1, displayedSubjectEntity.getCategoryId());
    }

}