package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.ClassDisplayEntity;
import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.entity.RegisteredClassEntity;
import com.churchsystem.entity.RegistrationEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.RegistrationModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
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
        return results;
    }

    @Override
    public List<RegisteredClassEntity> getNumberOfRegisteredClassByChurchId(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_REGISTERED_CLASS).
                setParameter(ParamConstant.CHURCH_ID, churchId).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RegisteredClassEntity> result = query.list();
        return result;
    }


    @Override
    public List<RegistrationEntity> getRegistrationBySubId(int subId){
        Criteria criteria=getSession().createCriteria(RegistrationEntity.class).add(Restrictions.eq(ParamConstant.SUBJECT_ID,subId));
        List<RegistrationEntity> registrationEntities=criteria.list();
        return registrationEntities;
    }

    @Override
    public List<RegistrationEntity> getWaitingRegistrationBySubId(int subId){
        Criteria criteria=getSession().createCriteria(RegistrationEntity.class).add(Restrictions.eq(ParamConstant.SUBJECT_ID,subId))
                .add(Restrictions.eq(ParamConstant.REGISTRATION_STATUS,ParamConstant.REGISTRATION_WAITING_STATUS));
        List<RegistrationEntity> registrationEntities=criteria.list();
        return registrationEntities;
    }

    @Override
    public List<ClassDisplayEntity> getOnPlanClass(int churchId){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_ON_PLAN_CLASS).setParameter(ParamConstant.CHURCH_ID,churchId)
                .setParameter(ParamConstant.EVENT_STATUS,ParamConstant.EVENT_APPROVE_STATUS)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<ClassDisplayEntity> classDisplayEntities=query.list();
        return classDisplayEntities;
    }

    @Override
    public List<ClassDisplayEntity> getOnGoingPlanClass(int churchId){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_ON_GOING_PLAN_CLASS).setParameter(ParamConstant.CHURCH_ID,churchId)
                .setParameter(ParamConstant.EVENT_STATUS,ParamConstant.EVENT_APPROVE_STATUS)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<ClassDisplayEntity> classDisplayEntities=query.list();
        return classDisplayEntities;
    }

    @Override
    public void updateRegistration(RegistrationEntity registrationEntity){
        getSession().saveOrUpdate(registrationEntity);
    }

    @Override
    public void addRegistration(RegistrationEntity registrationEntity){
        getSession().persist(registrationEntity);
    }

    @Override
    public RegistrationEntity getRegistrationByEventId(int eventId){
        Criteria criteria=getSession().createCriteria(RegistrationEntity.class).add(Restrictions.eq(ParamConstant.EVENT_ID,eventId));
        RegistrationEntity result=(RegistrationEntity) criteria.list().get(0);
        return result;
    }

}
