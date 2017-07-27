package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.RoomEntity;
import com.churchsystem.entity.RoomcapableEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.RoomModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Repository
public class RoomModel extends CommonDAO implements RoomModelInterface {
    @Override
    public List<RoomEntity> getRoomBySub(Integer subId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_AVAILABLE_ROOM_FOR_SUBJECT)
                .setParameter("requireSubId", subId).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RoomEntity> results = query.list();
        return results;
    }

    @Override
    public RoomEntity getRoomById(Integer roomId) {
        Criteria criteria = getSession().createCriteria(RoomEntity.class).add(Restrictions.eq("roomId", roomId));
        RoomEntity result = (RoomEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public Integer getSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId, int subId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_SUITABLE_ROOM_FOR_SLOT)
                .setParameter(ParamConstant.SLOT_HOUR, slotHourId).setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate)
                .setParameter(ParamConstant.SUBJECT_ID,subId);
        Integer result = (Integer) query.uniqueResult();
        return result;
    }

    @Override
    public Integer getLastSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId, int subId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LAST_SUITABLE_ROOM_FOR_SLOT)
                .setParameter(ParamConstant.SLOT_HOUR, slotHourId).setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate)
                .setParameter(ParamConstant.SUBJECT_ID,subId);
        Integer result = (Integer) query.uniqueResult();
        return result;
    }

    public List<RoomEntity> getListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_SUITABLE_ROOM_FOR_SLOT)
                .setParameter(ParamConstant.NEW_START_TIME, newStartTime)
                .setParameter(ParamConstant.NEW_END_TIME, newEndTime)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate)
                .setParameter(ParamConstant.SUBJECT_ID,subId)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RoomEntity> result = query.list();
        return result;
    }

    @Override
    public Integer checkRoomForSlot(int slotHourId, Date slotDate, int churchId, int roomId, int subId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.CHECK_ROOM_FOR_SLOT)
                .setParameter(ParamConstant.SLOT_HOUR, slotHourId).setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate).setParameter(ParamConstant.ROOM_ID, roomId)
                .setParameter(ParamConstant.SUBJECT_ID,subId);
        Integer result = (Integer) query.uniqueResult();
        return result;
    }

    @Override
    public List<Integer> getIdListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_SUITABLE_ROOM_ID_FOR_SLOT)
                .setParameter(ParamConstant.NEW_START_TIME, newStartTime)
                .setParameter(ParamConstant.NEW_END_TIME, newEndTime)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setParameter(ParamConstant.SLOT_DATE, slotDate)
                .setParameter(ParamConstant.SUBJECT_ID,subId);
        List<Integer> result = query.list();
        return result;
    }

    @Override
    public List<RoomEntity> getAllRoom(int churchId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_ALL_ROOM)
                .setParameter(ParamConstant.CHURCH_ID, churchId)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RoomEntity> roomEntities = query.list();
        return roomEntities;
    }

    @Override
    public void insertRoom(RoomEntity roomEntity){
        getSession().persist(roomEntity);
    }
    @Override
    public RoomEntity getRoomByNameAndChurchId(String roomName, int churchId, int status){
        Criteria criteria = getSession().createCriteria(RoomEntity.class).add(Restrictions.eq("roomName",roomName))
                .add(Restrictions.eq("churchId",churchId))
                .add(Restrictions.eq("roomStatus",status));
        RoomEntity roomEntity = (RoomEntity) criteria.uniqueResult();
        return roomEntity;
    }
    @Override
    public void updateRoom(RoomEntity roomEntity) {
        getSession().saveOrUpdate(roomEntity);
    }

    @Override
    public void mapRoomWithSubject(RoomcapableEntity roomcapableEntity){
        getSession().persist(roomcapableEntity);
    }
}
