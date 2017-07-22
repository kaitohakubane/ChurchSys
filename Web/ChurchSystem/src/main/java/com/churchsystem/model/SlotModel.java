package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.InclusionEntity;
import com.churchsystem.entity.SlotEntity;
import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.entity.TypeEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.SlotModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
@Repository
public class SlotModel extends CommonDAO implements SlotModelInterface {

    @Override
    public List<SlothourEntity> getListOfSlotHour() {
        Criteria criteria = getSession().createCriteria(SlothourEntity.class);
        List<SlothourEntity> result = criteria.list();
        return result;
    }

    @Override
    public void addNewSlot(SlotEntity slotEntity) {
        getSession().persist(slotEntity);
    }

    @Override
    public void mappingSlotHour(InclusionEntity inclusionEntity) {
        getSession().persist(inclusionEntity);
    }

    @Override
    public SlotEntity getUnassignedEventSlot(int conductorId) {
        Criteria criteria = getSession().createCriteria(SlotEntity.class)
                .add(Restrictions.isNull(ParamConstant.EVENT_ID))
                .add(Restrictions.eq(ParamConstant.CONDUCTOR_ID, conductorId));
        SlotEntity result = (SlotEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public void updateSlot(SlotEntity slotEntity) {
        getSession().saveOrUpdate(slotEntity);
    }

    @Override
    public List<SlotEntity> getSlotByEventId(int eventId) {
        Criteria criteria = getSession().createCriteria(SlotEntity.class).add(Restrictions.eq(ParamConstant.EVENT_ID, eventId));
        List<SlotEntity> slotEntities = criteria.list();
        return slotEntities;
    }

    @Override
    public TypeEntity getTypeByDescription(String type) {
        Criteria criteria = getSession().createCriteria(TypeEntity.class).add(Restrictions.eq(ParamConstant.TYPE_DESCRIPTION, type));
        TypeEntity typeEntity = (TypeEntity) criteria.uniqueResult();
        return typeEntity;
    }

    @Override
    public SlotEntity getSlotById(int slotId) {
        Criteria criteria = getSession().createCriteria(SlotEntity.class).add(Restrictions.eq(ParamConstant.SLOT_ID, slotId));
        SlotEntity slotEntity = (SlotEntity) criteria.uniqueResult();
        return slotEntity;
    }

    @Override
    public void deleteSlotHourBySlotId(int slotId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.DELETE_SLOT_HOUR_BY_SLOT_ID)
                .setParameter(ParamConstant.SLOT_ID, slotId);
        query.executeUpdate();
    }

    @Override
    public void addNewType(TypeEntity typeEntity) {
        getSession().persist(typeEntity);
    }

    @Override
    public List<SlothourEntity> getSlotHourByTimeRange(Time startTime, Time endTime) {
        Criteria criteria = getSession().createCriteria(SlothourEntity.class)
                .add(Restrictions.lt(ParamConstant.START_TIME, endTime))
                .add(Restrictions.gt(ParamConstant.END_TIME, startTime));
        List<SlothourEntity> result = criteria.list();
        return result;
    }

    @Override
    public List<SlotEntity> getListSlotOfClass(int slotId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_SLOT_OF_CLASS)
                .setParameter(ParamConstant.SLOT_ID, slotId).setResultTransformer(Transformers.aliasToBean(SlotEntity.class));
        List<SlotEntity> slotEntities = query.list();
        return slotEntities;
    }

    @Override
    public void deleteSlot(int slotId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.DELETE_SLOT_BY_SLOT_ID)
                .setParameter(ParamConstant.SLOT_ID, slotId);
        query.executeUpdate();
    }


    @Override
    public List<SlothourEntity> getListSlotHourByTime(Time startTime, Time endTime) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_SLOT_HOUR_BY_TIME)
                .setParameter(ParamConstant.START_TIME, startTime)
                .setParameter(ParamConstant.END_TIME, endTime)
                .setResultTransformer(Transformers.aliasToBean(SlothourEntity.class));
        List<SlothourEntity> slothourEntities = query.list();
        return slothourEntities;
    }

}
