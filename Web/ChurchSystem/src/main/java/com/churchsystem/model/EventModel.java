package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.DashboardClassEntity;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventEntity;
import com.churchsystem.entity.SlotEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.EventModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
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
    public EventEntity getCreatingEvent(Date date, int status, int subId, int churchId, boolean isRegistered,Timestamp time) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_CREATING_EVENT)
                .setParameter(ParamConstant.EVENT_DATE, date).setParameter(ParamConstant.EVENT_STATUS, status)
                .setParameter(ParamConstant.EVENT_SUBJECT_ID, subId)
                .setParameter(ParamConstant.CHURCH_ID, churchId).setParameter(ParamConstant.IS_EVENT_REGISTERED, isRegistered)
                .setParameter(ParamConstant.CREATED_TIME,time)
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
        Criteria criteria = getSession().createCriteria(EventEntity.class).add(Restrictions.eq(ParamConstant.EVENT_ID, eventId));
        EventEntity eventEntity = (EventEntity) criteria.uniqueResult();
        return eventEntity;
    }

    @Override
    public EventDataEntity getEventBySlotId(int slotId, int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_EVENT_FROM_SLOT_ID).
                setParameter(ParamConstant.SLOT_ID, slotId).setParameter(ParamConstant.CHURCH_ID, churchId).
                setResultTransformer(Transformers.aliasToBean(EventDataEntity.class));
        EventDataEntity result = (EventDataEntity) query.uniqueResult();
        return result;
    }

    @Override
    public Integer getCategoryIdFromSlotId(int slotId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_CATEGORY_ID_FROM_SLOT_ID).setParameter(ParamConstant.SLOT_ID, slotId);
        Integer result = (Integer) query.uniqueResult();
        return result;
    }

    @Override
    public void deleteEvent(int eventId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.DELETE_EVENT_BY_EVENT_ID)
                .setParameter(ParamConstant.EVENT_ID, eventId);
        query.executeUpdate();
    }

    @Override
    public List<EventEntity> getListEventOfChurch(int churchId) {
        Criteria criteria = getSession().createCriteria(EventEntity.class).add(Restrictions.eq(ParamConstant.CHURCH_ID, churchId))
                .add(Restrictions.eq(ParamConstant.EVENT_STATUS, ParamConstant.EVENT_APPROVE_STATUS));
        List<EventEntity> result = criteria.list();
        return result;
    }


    @Override
    public List<DashboardClassEntity> getUserRegisteredClass(int userId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_REGISTERED_CLASS_BY_USER_ID)
                .setParameter(ParamConstant.USER_ID, userId)
                .setResultTransformer(Transformers.aliasToBean(DashboardClassEntity.class));
        List<DashboardClassEntity> dashboardClassEntities = query.list();
        return dashboardClassEntities;
    }
}
