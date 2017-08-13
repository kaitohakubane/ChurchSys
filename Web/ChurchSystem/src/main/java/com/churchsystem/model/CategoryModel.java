package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.CategoryEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.CategoryModelInterface;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/17/2017.
 */
@Repository
public class CategoryModel extends CommonDAO implements CategoryModelInterface {

    @Override
    public List<CategoryEntity> getEventCategoryList() {
        Criteria criteria = getSession().createCriteria(CategoryEntity.class).
                add(Restrictions.ne("categoryId", ParamConstant.NOT_FIRST_EVENT_CATEGORY_ID)).
                add(Restrictions.ne("categoryId", ParamConstant.NOT_SECOND_EVENT_CATEGORY_ID));
        List<CategoryEntity> result = criteria.list();
        return result;
    }

    @Override
    public List<CategoryEntity> getClassCategoryList() {
        Criteria criteria = getSession().createCriteria(CategoryEntity.class).
                add(Restrictions.lt("categoryId", ParamConstant.TWELVE)).add(Restrictions.gt("categoryId", ParamConstant.FIVE));
        List<CategoryEntity> result = criteria.list();
        return result;
    }


}
