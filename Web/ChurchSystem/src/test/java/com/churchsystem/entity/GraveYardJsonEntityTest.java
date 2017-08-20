package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class GraveYardJsonEntityTest {
    @Test
    public void getGraveYardId() throws Exception {
        GraveYardJsonEntity graveYardJsonEntity = new GraveYardJsonEntity();
        graveYardJsonEntity.setGraveYardId(1);
        assertEquals((Integer) 1,graveYardJsonEntity.getGraveYardId());
    }

    @Test
    public void getStatus() throws Exception {
        GraveYardJsonEntity graveYardJsonEntity = new GraveYardJsonEntity();
        graveYardJsonEntity.setStatus(1);
        assertEquals((Integer) 1,graveYardJsonEntity.getStatus());
    }

    @Test
    public void getName() throws Exception {
        GraveYardJsonEntity graveYardJsonEntity = new GraveYardJsonEntity();
        graveYardJsonEntity.setName("AVC");
        assertEquals("AVC",graveYardJsonEntity.getName());
    }

    @Test
    public void getX() throws Exception {
        GraveYardJsonEntity graveYardJsonEntity = new GraveYardJsonEntity();
        graveYardJsonEntity.setX(1);
        assertEquals((Integer) 1,graveYardJsonEntity.getX());
    }

    @Test
    public void getY() throws Exception {
        GraveYardJsonEntity graveYardJsonEntity = new GraveYardJsonEntity();
        graveYardJsonEntity.setY(1);
        assertEquals((Integer) 1,graveYardJsonEntity.getY());
    }

}