package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class PostEntityTest {
    @Test
    public void getPostId() throws Exception {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(1);
        assertEquals(1,postEntity.getPostId());
    }

    @Test
    public void getConductorId() throws Exception {
        PostEntity postEntity = new PostEntity();
        postEntity.setConductorId(1);
        assertEquals((Integer)1,postEntity.getConductorId());
    }

    @Test
    public void getTitle() throws Exception {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("abc");
        assertEquals("abc",postEntity.getTitle());
    }

    @Test
    public void getInformation() throws Exception {
        PostEntity postEntity = new PostEntity();
        postEntity.setInformation("abc");
        assertEquals("abc",postEntity.getInformation());
    }

    @Test
    public void getPostDate() throws Exception {
    }

}