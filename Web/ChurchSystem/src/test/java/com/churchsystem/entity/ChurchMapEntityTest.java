package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class ChurchMapEntityTest {
    double test = 12.34;
    @Test
    public void getStreamName() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setStreamName("test1");
        assertEquals("test1", churchMapEntity.getStreamName());
    }

    @Test
    public void getIsFollowed() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setIsFollowed(1);
        assertEquals((Integer) 1,churchMapEntity.getIsFollowed());
    }

    @Test
    public void getAddress() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setAddress("so 8 ha van tinh");
        assertEquals("so 8 ha van tinh", churchMapEntity.getAddress());
    }

    @Test
    public void getChurchId() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setChurchId(1);
        assertEquals((Integer) 1, churchMapEntity.getChurchId());
    }

    @Test
    public void getChurchName() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setChurchName("HoaKhanh");
        assertEquals("HoaKhanh", churchMapEntity.getChurchName());
    }

    @Test
    public void getLongitude() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setLongitude(113.222);
        assertEquals((Double) 113.222, churchMapEntity.getLongitude());
    }

    @Test
    public void getLatitude() throws Exception {
        ChurchMapEntity  churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setLatitude(111.111);
        assertEquals((Double)111.111, churchMapEntity.getLatitude());
    }

    @Test
    public void getDistance() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setDistance(test);
        assertEquals(test, churchMapEntity.getDistance(),5);
    }

    @Test
    public void getTel() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setTel("0123456789");
        assertEquals("0123456789",churchMapEntity.getTel());
    }


    @Test
    public void getStartTime() throws Exception {

    }

    @Test
    public void getEndTime() throws Exception {
    }

    @Test
    public void getDescription() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setDescription("Test1");
        assertEquals("Test1", churchMapEntity.getDescription());
    }

    @Test
    public void getStreamLink() throws Exception {
        ChurchMapEntity churchMapEntity = new ChurchMapEntity();
        churchMapEntity.setStreamLink("https://youtu.be/bWJEsEKX-jg");
        assertEquals("https://youtu.be/bWJEsEKX-jg", churchMapEntity.getStreamLink());
    }

}