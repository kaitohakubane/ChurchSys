package com.churchsystem.model;

import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.RegisteredClassEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.RegisteredClassModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */
@Repository
public class RegisteredClassModel extends CommonDAO implements RegisteredClassModelInterface {
    @Override
    public List<RegisteredClassEntity> getNumberOfRegisteredClassByChurchId(int churchId) {
        Query query = getSession().createQuery(SQLParamConstant.GET_NUMBER_OF_REGISTERED_CLASS).setParameter("requireChurchId", churchId).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RegisteredClassEntity> result = query.list();
        return result;
    }
}
