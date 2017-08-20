package com.churchsystem.entity;

import org.junit.Test;

import javax.print.DocFlavor;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class ChurchInfoEntityTest {
    @Test
    public void getStreamLink() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setStreamLink("https://youtu.be/bWJEsEKX-jg");
        assertEquals("https://youtu.be/bWJEsEKX-jg",churchInfoEntity.getStreamLink());
    }

    @Test
    public void getStreamName() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setStreamName("Test1");
        assertEquals("Test1",churchInfoEntity.getStreamName());
    }

    @Test
    public void getChurchId() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setChurchId(1);
        assertEquals(1,churchInfoEntity.getChurchId());
    }

    @Test
    public void getChurchName() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setChurchName("HoaKhanh");
        assertEquals("HoaKhanh",churchInfoEntity.getChurchName());
    }

    @Test
    public void getTel() throws Exception {
        ChurchInfoEntity churchInfoEntity  = new ChurchInfoEntity();
        churchInfoEntity.setTel("0123456789");
        assertEquals("0123456789",churchInfoEntity.getTel());
    }

    @Test
    public void getAddress() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setAddress("so 8 ha van tinh");
        assertEquals("so 8 ha van tinh", churchInfoEntity.getAddress());

    }

    @Test
    public void getMail() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setMail("hoakhanh@gmail.com");
        assertEquals("hoakhanh@gmail.com", churchInfoEntity.getMail());
    }

    @Test
    public void getStartTime() throws Exception {
    }

    @Test
    public void getEndTime() throws Exception {
    }

    @Test
    public void getImage() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setImage("Abc");
        assertEquals("Abc", churchInfoEntity.getImage());
    }

    @Test
    public void getDescription() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setDescription("Test church info");
        assertEquals("Test church info", churchInfoEntity.getDescription());
    }

    @Test
    public void getUserId() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setUserId(1);
        assertEquals(1, churchInfoEntity.getUserId());
    }

    @Test
    public void getUserName() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setUserName("test1");
        assertEquals("test1",churchInfoEntity.getUserName());
    }

    @Test
    public void getCertificate() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setCertificate("Linh Muc");
        assertEquals("Linh Muc", churchInfoEntity.getCertificate());
    }

}