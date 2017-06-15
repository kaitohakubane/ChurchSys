package com.churchsystem.model;

import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.DisplayedSubjectEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.DisplayedSubjectModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */

@Repository
public class DisplayedSubjectModel extends CommonDAO implements DisplayedSubjectModelInterface {
    @Override
    public List<DisplayedSubjectEntity> getDisplayedSubject() {
        Query query = getSession().createQuery(SQLParamConstant.GET_LIST_OF_SUBJECT)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<DisplayedSubjectEntity> result = query.list();
        return result;
    }
}
