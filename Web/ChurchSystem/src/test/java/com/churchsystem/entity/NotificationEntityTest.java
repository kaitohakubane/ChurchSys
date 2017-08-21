package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class NotificationEntityTest {
    @Test
    public void getNotificationId() throws Exception {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setNotificationId(1);
        assertEquals(1,notificationEntity.getNotificationId());
    }

    @Test
    public void getUserId() throws Exception {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setUserId(1);
        assertEquals((Integer)1,notificationEntity.getUserId());
    }

    @Test
    public void getAvatar() throws Exception {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setAvatar("abc");
        assertEquals("abc",notificationEntity.getAvatar());
    }

    @Test
    public void getSender() throws Exception {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setSender("abc");
        assertEquals("abc",notificationEntity.getSender());
    }

    @Test
    public void getInformation() throws Exception {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setInformation("abc");
        assertEquals("abc",notificationEntity.getInformation());
    }

    @Test
    public void getLink() throws Exception {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setLink("abc");
        assertEquals("abc",notificationEntity.getLink());
    }

    @Test
    public void getTime() throws Exception {
    }

}