package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class StreamEntityTest {
    @Test
    public void getStreamLink() throws Exception {
        StreamEntity streamEntity = new StreamEntity();
        streamEntity.setStreamLink("abc");
        assertEquals("abc",streamEntity.getStreamLink());
    }

    @Test
    public void getStreamCode() throws Exception {
        StreamEntity streamEntity = new StreamEntity();
        streamEntity.setStreamCode("abc");
        assertEquals("abc",streamEntity.getStreamCode());
    }

}