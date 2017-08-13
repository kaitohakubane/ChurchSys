package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.DisplayedSubjectEntity;
import com.churchsystem.entity.SubjectEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.SubjectModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.security.auth.Subject;
import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */

@Repository
public class SubjectModel extends CommonDAO implements SubjectModelInterface {
    @Override
    public List<DisplayedSubjectEntity> getDisplayedSubject() {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_OF_SUBJECT)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<DisplayedSubjectEntity> result = query.list();
        return result;
    }

    @Override
    public SubjectEntity getSubjectById(int subId) {
        Criteria criteria = getSession().createCriteria(SubjectEntity.class).add(Restrictions.eq(ParamConstant.SUBJECT_ID, subId));
        SubjectEntity result = (SubjectEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public List<DisplayedSubjectEntity> getDisplayedClass() {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_OF_CLASS)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<DisplayedSubjectEntity> result = query.list();
        return result;
    }

}
