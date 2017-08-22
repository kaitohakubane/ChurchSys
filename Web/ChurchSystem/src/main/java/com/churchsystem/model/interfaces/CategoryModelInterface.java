package com.churchsystem.model.interfaces;

import com.churchsystem.entity.CategoryEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/17/2017.
 */
public interface CategoryModelInterface {
    List<CategoryEntity> getEventCategoryList();

    List<CategoryEntity> getEventCateList();

    List<CategoryEntity> getClassCategoryList();
}
