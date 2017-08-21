package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class StreamJsonEntityTest {
    @Test
    public void getStreamTitle() throws Exception {
        StreamJsonEntity streamJsonEntity = new StreamJsonEntity("abc","abc1");
        streamJsonEntity.setStreamTitle("abc");
        assertEquals("abc",streamJsonEntity.getStreamTitle());
    }

    @Test
    public void getResolution() throws Exception {
        StreamJsonEntity streamJsonEntity = new StreamJsonEntity("abc","abc1");
        streamJsonEntity.setResolution("abc1");
        assertEquals("abc1",streamJsonEntity.getResolution());
    }

}