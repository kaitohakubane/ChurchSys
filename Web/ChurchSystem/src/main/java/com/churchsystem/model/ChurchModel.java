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
    public List<IncomingEventEntity> getIncomingEvent(int userId){
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_INCOMING_EVENT_INFO)
                .setParameter(ParamConstant.USER_ID, userId)
                .setResultTransformer(Transformers.aliasToBean(IncomingEventEntity.class));
        List<IncomingEventEntity> incomingEventEntities = query.list();
        return incomingEventEntities;
    }

    @Override
    public SettingEntity getSettingOfChurch(int churchId){
        Criteria criteria=getSession().createCriteria(SettingEntity.class).add(Restrictions.eq(ParamConstant.CHURCH_ID,churchId));
        SettingEntity result=(SettingEntity) criteria.uniqueResult();
        return result;
    }
}
