package com.churchsystem.entity;

import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/18/2017.
 */
public class ChurchEntityTest {
    int defaultvalue = 1;
    String defultname = "HoaKhanh";
    String defaultTel = "0123456789";
    String defaultAdd = "so 8 ha van tinh";
    String defaultMail = "hoakhanh@gmail.com";
    String defaultStartTime = "13/5/2017";
    int defualtEndTime = 2038-01-19031407;
    String dedaualtImage = "ABC";
    @Test
    public void getChurchId() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setChurchId(1);
        assertEquals(defaultvalue,churchEntity.getChurchId());
    }

    @Test
    public void setChurchId() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setChurchId(1);
        assertEquals(defaultvalue,churchEntity.getChurchId());
    }

    @Test
    public void getChurchName() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setChurchName("HoaKhanh");
        assertEquals(defultname,churchEntity.getChurchName());

    }

    @Test
    public void setChurchName() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setChurchName("HoaKhanh");
        assertEquals(defultname,churchEntity.getChurchName());
    }

    @Test
    public void getLongitude() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setLongitude(1213.2132);
        assertEquals((Double)1213.2132,churchEntity.getLongitude());
    }

    @Test
    public void setLongitude() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setLongitude(1213.2132);
        assertEquals((Double)1213.2132,churchEntity.getLongitude());
    }

    @Test
    public void getLatitude() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setLongitude(1213.2132);
        assertEquals((Double)1213.2132,churchEntity.getLongitude());
    }

    @Test
    public void setLatitude() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setLongitude(1213.2132);
        assertEquals((Double)1213.2132,churchEntity.getLongitude());
    }

    @Test
    public void getTel() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setTel("0123456789");
        assertEquals(defaultTel,churchEntity.getTel());
    }

    @Test
    public void setTel() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setTel("0123456789");
        assertEquals(defaultTel,churchEntity.getTel());
    }

    @Test
    public void getAddress() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setAddress("so 8 ha van tinh");
        assertEquals(defaultAdd, churchEntity.getAddress());
    }

    @Test
    public void setAddress() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setAddress("so 8 ha van tinh");
        assertEquals(defaultAdd, churchEntity.getAddress());
    }

    @Test
    public void getMail() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setMail("hoakhanh@gmail.com");
        assertEquals(defaultMail,churchEntity.getMail());
    }

    @Test
    public void setMail() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setMail("hoakhanh@gmail.com");
        assertEquals(defaultMail,churchEntity.getMail());
    }

    @Test
    public void getStartTime() throws Exception {

    }

    @Test
    public void setStartTime() throws Exception {
    }

    @Test
    public void getEndTime() throws Exception {
    }

    @Test
    public void setEndTime() throws Exception {

    }

    @Test
    public void getImage() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setImage("ABC");
        assertEquals("ABC",churchEntity.getImage());
    }

    @Test
    public void setImage() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setImage("ABC");
        assertEquals("ABC",churchEntity.getImage());
    }

    @Test
    public void getDescription() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setDescription("Test thu nha tho");
        assertEquals("Test thu nha tho", churchEntity.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setDescription("Test thu nha tho");
        assertEquals("Test thu nha tho", churchEntity.getDescription());
    }

    @Test
    public void getStreamName() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setStreamName("Test1");
        assertEquals("Test1",churchEntity.getStreamName());
    }

    @Test
    public void setStreamName() throws Exception {
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
    public void setStreamLink() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setStreamLink("https://youtu.be/bWJEsEKX-jg");
        assertEquals("https://youtu.be/bWJEsEKX-jg",churchEntity.getStreamLink());
    }

}