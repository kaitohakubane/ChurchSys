package com.churchsystem.entity;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/20/2017.
 */
public class GraveEntityTest {
    @Test
    public void getGraveId() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setGraveId(1);
        assertEquals(1,graveEntity.getGraveId());
    }

    @Test
    public void getGraveYardId() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setGraveYardId(1);
        assertEquals((Integer) 1,graveEntity.getGraveYardId());
    }

    @Test
    public void getUserId() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setUserId(1);
        assertEquals((Integer) 1,graveEntity.getUserId());
    }

    @Test
    public void getIdentity() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setIdentity("1");
        assertEquals("1",graveEntity.getIdentity());

    }

    @Test
    public void getPhone() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setPhone("0123456789");
        assertEquals("0123456789",graveEntity.getPhone());
    }

    @Test
    public void getName() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setName("ABC");
        assertEquals("ABC",graveEntity.getName());
    }

    @Test
    public void getBirthDay() throws Exception {

    }

    @Test
    public void getImage() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setImage("avc");
        assertEquals("avc",graveEntity.getImage());
    }

    @Test
    public void getHomeTown() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setHomeTown("Đà Nẳng");
        assertEquals("Đà Nẳng",graveEntity.getHomeTown());
    }


    @Test
    public void getParish() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setParish("HoaKHanh");
        assertEquals("HoaKHanh", graveEntity.getParish());
    }


    @Test
    public void getX() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setX(1);
        assertEquals((Integer) 1,graveEntity.getX());
    }

    @Test
    public void getY() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setY(1);
        assertEquals((Integer) 1, graveEntity.getY());
    }

    @Test
    public void getStatus() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setStatus(1);
        assertEquals((Integer) 1,graveEntity.getStatus());
    }

}