package com.churchsystem.service;

import com.churchsystem.entity.CategoryEntity;
import com.churchsystem.model.interfaces.CategoryModelInterface;
import com.churchsystem.service.interfaces.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/17/2017.
 */

@Service
@Transactional
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    CategoryModelInterface categoryModelInterface;

    @Override
    public List<CategoryEntity> getEventCategoryList() {
        return categoryModelInterface.getEventCategoryList();
    }

    @Override
    public List<CategoryEntity> getClassCategoryList() {
        return categoryModelInterface.getClassCategoryList();
    }

    @Override
    public List<CategoryEntity> getEventCateList() {
        return categoryModelInterface.getEventCateList();
    }
}
