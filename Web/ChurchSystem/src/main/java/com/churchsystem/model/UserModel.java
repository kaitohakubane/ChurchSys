package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.InteractionEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.UserModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
@Repository
public class UserModel extends CommonDAO implements UserModelInterface {

    @Override
    public UserEntity getUserByAccountId(String accountId) {
        Criteria criteria = getSession().createCriteria(UserEntity.class).add(Restrictions.eq("accountId", accountId));
        UserEntity result = (UserEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public UserEntity getUserByUserId(int userId) {
        Criteria criteria = getSession().createCriteria(UserEntity.class).add(Restrictions.eq("userId", userId));
        UserEntity result = (UserEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public int getChurchIdByUserId(int userId) {
        Criteria criteria = getSession().createCriteria(InteractionEntity.class)
                .add(Restrictions.eq("userId", userId)).add(Restrictions.eq("enabled", true));
        InteractionEntity interactionEntity = (InteractionEntity) criteria.uniqueResult();
        return interactionEntity.getChurchId();
    }

    @Override
    public Integer getSuitableConductorForSlot(int slotHourId, Date slotDate, int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_SUITABLE_CONDUCTOR_FOR_SLOT)
                .setParameter(ParamConstant.SLOT_HOUR, slotHourId).setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate);
        Integer result = (Integer) query.uniqueResult();
        return result;
    }

    @Override
    public List<UserEntity> getListSuitableConductorForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_SUITABLE_CONDUCTOR_FOR_SLOT)
                .setParameter(ParamConstant.NEW_START_TIME, newStartTime)
                .setParameter(ParamConstant.NEW_END_TIME, newEndTime)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<UserEntity> result = query.list();
        return result;
    }

    @Override
    public Integer checkConductorForSlot(int slotHourId, Date slotDate, int churchId, int conductorId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.CHECK_CONDUCTOR_FOR_SLOT)
                .setParameter(ParamConstant.SLOT_HOUR, slotHourId).setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate).setParameter(ParamConstant.CONDUCTOR_ID, conductorId);
        Integer result = (Integer) query.uniqueResult();
        return result;
    }


    @Override
    public List<Integer> getIdListSuitableConductorForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_SUITABLE_CONDUCTOR_ID_FOR_SLOT)
                .setParameter(ParamConstant.NEW_START_TIME, newStartTime)
                .setParameter(ParamConstant.NEW_END_TIME, newEndTime)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate);
        List<Integer> result = query.list();
        return result;
    }


    @Override
    public List<UserEntity> getAllPriest(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_ALL_PRIEST)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<UserEntity> userEntities = query.list();
        return userEntities;
    }

    @Override
    public List<String> getListOfChurchFollower(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_OF_CHURCH_FOLLOWER_ACCOUNT)
                .setParameter(ParamConstant.CHURCH_ID, churchId);
        List<String> result = query.list();
        return result;
    }

    @Override
    public String getChurchManagerAccount(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_CHURCH_MANAGER_ACCOUNT)
                .setParameter(ParamConstant.CHURCH_ID, churchId);
        String result = (String)query.uniqueResult();
        return result;
    }


    @Override
    public List<String> getEventRegisteredUserAccount(int eventId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_EVENT_REGISTERED_USER_ACCOUNT)
                .setParameter(ParamConstant.EVENT_ID, eventId);
        List<String> result = query.list();
        return result;
    }
}
