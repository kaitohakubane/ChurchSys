package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class QuestionEntityTest {
    @Test
    public void getQuesId() throws Exception {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuesId(1);
        assertEquals(1,questionEntity.getQuesId());
    }

    @Test
    public void getConductorId() throws Exception {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setConductorId(1);
        assertEquals((Integer)1,questionEntity.getConductorId());
    }

    @Test
    public void getUserId() throws Exception {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setUserId(1);
        assertEquals((Integer)1,questionEntity.getUserId());
    }

    @Test
    public void getInformation() throws Exception {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setInformation("abc");
        assertEquals("abc",questionEntity.getInformation());
    }

    @Test
    public void getQuesStatus() throws Exception {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuesStatus("abc");
        assertEquals("abc",questionEntity.getQuesStatus());
    }

    @Test
    public void getKind() throws Exception {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setKind(1);
        assertEquals((Integer)1,questionEntity.getKind());
    }

}