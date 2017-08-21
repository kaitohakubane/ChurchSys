package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class TypeEntityTest {
    @Test
    public void getTypeId() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setTypeId(1);
        assertEquals(1,typeEntity.getTypeId());
    }

    @Test
    public void getDescription() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setDescription("abc");
        assertEquals("abc",typeEntity.getDescription());
    }

    @Test
    public void getLoopType() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setLoopType(1);
        assertEquals((Integer)1,typeEntity.getLoopType());
    }

    @Test
    public void getLastGenerated() throws Exception {
    }

    @Test
    public void getKind() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setKind(1);
        assertEquals((Integer)1,typeEntity.getKind());
    }

}