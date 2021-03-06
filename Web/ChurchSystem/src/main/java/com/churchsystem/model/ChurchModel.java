package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.*;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Repository
public class ChurchModel extends CommonDAO implements ChurchModelInterface {
    @Override
    public ChurchEntity getChurchById(int churchId) {
        Criteria criteria = getSession().createCriteria(ChurchEntity.class).add(Restrictions.eq(ParamConstant.CHURCH_ID, churchId));
        ChurchEntity result = (ChurchEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public void updateChurch(ChurchEntity churchEntity) {
        getSession().saveOrUpdate(churchEntity);
    }

    @Override
    public List<ChurchMapEntity> getNearbyChurch(Double latitude, Double longitude, int radius) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_NEARBY_LOCATION)
                .setParameter(ParamConstant.INPUT_LATITUDE, latitude).setParameter(ParamConstant.INPUT_LONGITUDE, longitude)
                .setParameter(ParamConstant.DISTANCE, radius).setResultTransformer(Transformers.aliasToBean(ChurchMapEntity.class));
        List<ChurchMapEntity> churchMapEntities = query.list();
        return churchMapEntities;
    }

    /**
     * Get all church in system for Admin view
     * @return list of all church in system and its manager
     */
    @Override
    public List<ChurchDisplayEntity> getAllChurch() {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_DISPLAYED_CHURCH).setResultTransformer
                (Transformers.aliasToBean(ChurchDisplayEntity.class));
        List<ChurchDisplayEntity> churchDisplayEntities = query.list();
        return churchDisplayEntities;
    }

    @Override
    public ChurchInfoEntity getChurchInfo(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_CHURCH_INFORMATION)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Transformers.aliasToBean(ChurchInfoEntity.class));
        ChurchInfoEntity churchInfoEntities = (ChurchInfoEntity) query.uniqueResult();
        return churchInfoEntities;
    }

    @Override
    public List<IncomingEventEntity> getIncomingEvent(int userId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_INCOMING_EVENT_INFO)
                .setParameter(ParamConstant.USER_ID, userId)
                .setResultTransformer(Transformers.aliasToBean(IncomingEventEntity.class));
        List<IncomingEventEntity> incomingEventEntities = query.list();
        return incomingEventEntities;
    }

    @Override
    public SettingEntity getSettingOfChurch(int churchId) {
        Criteria criteria = getSession().createCriteria(SettingEntity.class).add(Restrictions.eq(ParamConstant.CHURCH_ID, churchId));
        SettingEntity result = (SettingEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public void addSetting(SettingEntity settingEntity) {
        getSession().persist(settingEntity);
    }

    @Override
    public void updateSetting(SettingEntity settingEntity) {
        getSession().saveOrUpdate(settingEntity);
    }


    @Override
    public List<IncomingEventEntity> getIncomingEventByChurchId(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_INCOMING_EVENT_BY_CHURCH_ID)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Transformers.aliasToBean(IncomingEventEntity.class));
        List<IncomingEventEntity> incomingEventEntities = query.list();
        return incomingEventEntities;
    }

    @Override
    public List<IncomingClassEntity> getIncomingClassByChurchId(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_INCOMING_CLASS_BY_CHURCH_ID)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Transformers.aliasToBean(IncomingClassEntity.class));
        List<IncomingClassEntity> incomingClassEntities = query.list();
        return incomingClassEntities;
    }


    @Override
    public void createChurch(ChurchEntity churchEntity) {
        getSession().persist(churchEntity);
        getSession().flush();
        getSession().clear();
    }

    @Override
    public ChurchEntity getChurchByInfo(Double longitude, Double latitude) {
        Criteria criteria = getSession().createCriteria(ChurchEntity.class)
                .add(Restrictions.eq(ParamConstant.CHURCH_LONGITUDE, longitude))
                .add(Restrictions.eq(ParamConstant.CHURCH_LATITUDE, latitude));
        ChurchEntity result = (ChurchEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public void createSetting(SettingEntity setting) {
        getSession().persist(setting);
    }
}
