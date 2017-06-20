package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventEntity;
import com.churchsystem.entity.InclusionEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.EventModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Repository
public class EventModel extends CommonDAO implements EventModelInterface {

    @Override
    public List<EventDataEntity> getListOfEvent(int churchId){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_EVENT_DISPLAY_SLOT)
                .setParameter("requireChurchId",churchId)
                .setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        List<EventDataEntity> result=query.list();
        return result;
    }

    @Override
    public List<EventDataEntity> getListOfPublicEvent(int churchId){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_PUBLIC_EVENT_DISPLAY_SLOT)
                .setParameter("requireChurchId",churchId)
                .setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        List<EventDataEntity> result=query.list();
        return result;
    }

    @Override
    public void addNewEvent(EventEntity eventEntity){
        getSession().persist(eventEntity);
    }

    @Override
    public EventEntity getCreatingEvent(Date date,int status,int subId,int churchId){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_CREATING_EVENT)
                .setParameter(ParamConstant.EVENT_DATE,date).setParameter(ParamConstant.EVENT_STATUS,status)
                .setParameter(ParamConstant.EVENT_SUBJECT_ID,subId)
                .setParameter(ParamConstant.CHURCH_ID,churchId)
                .setResultTransformer(Transformers.aliasToBean(EventEntity.class));
        EventEntity result=(EventEntity) query.uniqueResult();
        return result;
    }

    @Override
    public EventDataEntity getCreatedEvent(int slotId){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_EVENT_BY_SLOTID)
                .setParameter(ParamConstant.SLOT_ID,slotId)
                .setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        EventDataEntity result=(EventDataEntity) query.uniqueResult();
        return result;
    }

}
