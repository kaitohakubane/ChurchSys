package com.churchsystem.service;

import com.churchsystem.model.interfaces.CategoryModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
    @InjectMocks
    CategoryService categoryService = new CategoryService();

    @Mock
    CategoryModelInterface categoryModelInterface;
    @Test
    public void getEventCategoryList() throws Exception {
    }

    @Test
    public void getClassCategoryList() throws Exception {
    }

}