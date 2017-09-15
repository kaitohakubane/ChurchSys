package com.churchsystem.model;


import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.LessonDisplayEntity;
import com.churchsystem.entity.LessonEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.LessonModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by Vongnlh on 9/8/2017.
 */
@Repository
public class LessonModel extends CommonDAO implements LessonModelInterface {

    @Override
    public List<LessonEntity> getAllLessonOfChurch(int churchId){
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LESSON_OF_CHURCH).
                setParameter(ParamConstant.CHURCH_ID,churchId)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<LessonEntity> result = query.list();
        return result;
    }
    @Override
    public void insertLesson(LessonEntity lessonEntity){
        getSession().persist(lessonEntity);
    }




    @Override
    public List<LessonDisplayEntity> getAllLesson(int churchId){
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_ALL_LESSON)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Transformers.aliasToBean(LessonDisplayEntity.class));
        List<LessonDisplayEntity> result = query.list();
        return result;
    }


}
