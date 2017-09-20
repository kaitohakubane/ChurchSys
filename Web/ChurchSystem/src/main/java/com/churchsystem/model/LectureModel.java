package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.LectureEntity;
import com.churchsystem.entity.LessonEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.LectureModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

/**
 * Created by Vongnlh on 9/16/2017.
 */
@Repository
public class LectureModel extends CommonDAO implements LectureModelInterface {
    @Override
    public List<LectureEntity> getAllLecture(int churchId){
     Query query = getSession().createSQLQuery(SQLParamConstant.GET_ALL_LECTURE).setParameter(ParamConstant.CHURCH_ID,churchId)
             .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
     List<LectureEntity> result = query.list();
     return result;
    }
    @Override
    public void insertLecture(LectureEntity lectureEntity) {
        getSession().persist(lectureEntity);
    }
}
