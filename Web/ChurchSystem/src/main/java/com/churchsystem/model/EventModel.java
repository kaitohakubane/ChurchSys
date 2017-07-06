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
import org.hibernate.criterion.Restrictions;
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
    public List<EventDataEntity> getListOfEvent(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_EVENT_DISPLAY_SLOT)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        List<EventDataEntity> result = query.list();
        return result;
    }

    @Override
    public List<EventDataEntity> getListOfPublicEvent(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_PUBLIC_EVENT_DISPLAY_SLOT)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        List<EventDataEntity> result = query.list();
        return result;
    }

    @Override
    public void addNewEvent(EventEntity eventEntity) {
        getSession().persist(eventEntity);
    }

    @Override
    public void updateEvent(EventEntity eventEntity) {
        getSession().saveOrUpdate(eventEntity);
    }

    @Override
    public EventEntity getCreatingEvent(Date date, int status, int subId, int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_CREATING_EVENT)
                .setParameter(ParamConstant.EVENT_DATE, date).setParameter(ParamConstant.EVENT_STATUS, status)
                .setParameter(ParamConstant.EVENT_SUBJECT_ID, subId)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Transformers.aliasToBean(EventEntity.class));
        EventEntity result = (EventEntity) query.uniqueResult();
        return result;
    }

    @Override
    public List<EventDataEntity> getCreatedEvent(int eventId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_DISPLAY_EVENT_BY_EVENT_ID)
                .setParameter(ParamConstant.EVENT_ID, eventId)
                .setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        List<EventDataEntity> result = query.list();
        return result;
    }

    @Override
    public EventEntity getEventById(int eventId) {
        Criteria criteria = getSession().createCriteria(EventEntity.class).add(Restrictions.eq("eventId", eventId));
        EventEntity eventEntity = (EventEntity) criteria.uniqueResult();
        return eventEntity;
    }

    @Override
    public EventDataEntity getEventBySlotId(int slotId, int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_EVENT_FROM_SLOT_ID).
                setParameter(ParamConstant.SLOT_ID, slotId).setParameter(ParamConstant.CHURCH_ID, churchId).
                setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        EventDataEntity result = (EventDataEntity) query.uniqueResult();
        System.out.println(result.toString());
        return result;
    }
}
