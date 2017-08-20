package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/18/2017.
 */
public class CategoryEntityTest {
    int testvalue = 1;
    String testname = "Phungvu";
    @Test
    public void getCategoryId() throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1);
        assertEquals(1,categoryEntity.getCategoryId());

    }

    @Test
    public void setCategoryId() throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(testvalue);
        assertEquals(testvalue,categoryEntity.getCategoryId());

    }

    @Test
    public void getCategoryName() throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName("Phungvu");
        assertEquals(testname,categoryEntity.getCategoryName());
    }

    @Test
    public void setCategoryName() throws Exception {
    }

}