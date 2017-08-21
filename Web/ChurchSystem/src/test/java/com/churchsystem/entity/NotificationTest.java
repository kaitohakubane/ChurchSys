package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class NotificationTest {
    @Test
    public void getAvatar() throws Exception {
        Notification notification = new Notification("abc", "abc1", "abc2", "abc3", "abc4");
        notification.setAvatar("abc");
        assertEquals("abc",notification.getAvatar());
    }

    @Test
    public void getSender() throws Exception {
        Notification notification = new Notification("abc", "abc1", "abc2", "abc3", "abc4");
        notification.setSender("abc1");
        assertEquals("abc1",notification.getSender());
    }


    @Test
    public void getInformation() throws Exception {
        Notification notification = new Notification("abc", "abc1", "abc2", "abc3", "abc4");
        notification.setInformation("abc2");
        assertEquals("abc2",notification.getInformation());
    }



    @Test
    public void getLink() throws Exception {
        Notification notification = new Notification("abc", "abc1", "abc2", "abc3", "abc4");
        notification.setLink("abc3");
        assertEquals("abc3",notification.getLink());
    }


    @Test
    public void getTime() throws Exception {
        Notification notification = new Notification("abc", "abc1", "abc2", "abc3", "abc4");
        notification.setTime("abc4");
        assertEquals("abc4",notification.getTime());
    }


}