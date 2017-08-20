package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class ChurchDisplayEntityTest {
    @Test
    public void getImage() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setImage("Abc");
        assertEquals("Abc",churchDisplayEntity.getImage());
    }

    @Test
    public void getChurchId() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setChurchId(1);
        assertEquals(1,churchDisplayEntity.getChurchId());
    }

    @Test
    public void getChurchName() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setChurchName("HoaKhanh");
        assertEquals("HoaKhanh",churchDisplayEntity.getChurchName());
    }

    @Test
    public void getLongitude() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setLongitude(1234.1234);
        assertEquals((Double) 1234.1234,churchDisplayEntity.getLongitude());

    }

    @Test
    public void getLatitude() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setLatitude(11.11);
        assertEquals((Double) 11.11,churchDisplayEntity.getLatitude());
    }

    @Test
    public void getTel() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setTel("0123456789");
        assertEquals("0123456789",churchDisplayEntity.getTel());
    }

    @Test
    public void getAddress() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setAddress("so 8 ha van tinh");
        assertEquals("so 8 ha van tinh", churchDisplayEntity.getAddress());
    }

    @Test
    public void getMail() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setMail("hoakhanh@gmail.com");
        assertEquals("hoakhanh@gmail.com",churchDisplayEntity.getMail());
    }

    @Test
    public void getStartTime() throws Exception {

    }

    @Test
    public void getEndTime() throws Exception {
    }

    @Test
    public void getDescription() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setDescription("test churchdisplay");
        assertEquals("test churchdisplay", churchDisplayEntity.getDescription());
    }

    @Test
    public void getStreamName() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setStreamName("Test1");
        assertEquals("Test1",churchEntity.getStreamName());
    }

    @Test
    public void getStreamLink() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setStreamLink("https://youtu.be/bWJEsEKX-jg");
        assertEquals("https://youtu.be/bWJEsEKX-jg",churchEntity.getStreamLink());
    }

    @Test
    public void getUserId() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setUserId(1);
        assertEquals((Integer) 1,churchDisplayEntity.getUserId());
    }

    @Test
    public void getAccountId() throws Exception {
        ChurchDisplayEntity churchDisplayEntity = new ChurchDisplayEntity();
        churchDisplayEntity.setAccountId("test1");
        assertEquals("test1",churchDisplayEntity.getAccountId());

    }

}