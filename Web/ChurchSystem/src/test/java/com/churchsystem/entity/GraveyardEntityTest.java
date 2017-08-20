package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class GraveyardEntityTest {
    @Test
    public void getGraveYardId() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setGraveYardId(1);
        assertEquals(1,graveyardEntity.getGraveYardId());
    }

    @Test
    public void getChurchId() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setChurchId(1);
        assertEquals((Integer) 1,graveyardEntity.getChurchId());
    }

    @Test
    public void getStatus() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setStatus(1);
        assertEquals((Integer) 1,graveyardEntity.getStatus());
    }

    @Test
    public void getName() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setName("AVC");
        assertEquals("AVC",graveyardEntity.getName());
    }

    @Test
    public void getX() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setX(1);
        assertEquals((Integer) 1,graveyardEntity.getX());
    }

    @Test
    public void getY() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setY(1);
        assertEquals((Integer) 1,graveyardEntity.getY());
    }

    @Test
    public void getWidth() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setWidth(10);
        assertEquals((Integer) 10,graveyardEntity.getWidth());
    }

    @Test
    public void getHeight() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setHeight(10);
        assertEquals((Integer) 10,graveyardEntity.getHeight());
    }

    @Test
    public void getGraveAvailable() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setGraveAvailable(1);
        assertEquals((Integer) 1,graveyardEntity.getGraveAvailable());
    }

}