package com.churchsystem.model;

import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.RegistrationModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 5/31/2017.
 */
@Repository
public class RegistrationModel extends CommonDAO implements RegistrationModelInterface {
    @Override
    public List<RegisterDisplayEntity> getRegistration(){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_REGISTRATION)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RegisterDisplayEntity> results=query.list();
        return null;
    }
}
