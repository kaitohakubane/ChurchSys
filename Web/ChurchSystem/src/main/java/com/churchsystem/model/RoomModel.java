package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.RoomEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.RoomModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Repository
public class RoomModel extends CommonDAO implements RoomModelInterface {
    @Override
    public List<RoomEntity> getRoomBySub(Integer subId){
        Query query= getSession().createSQLQuery(SQLParamConstant.GET_AVAILABLE_ROOM_FOR_SUBJECT)
                .setParameter("requireSubId",subId).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RoomEntity> results=query.list();
        return results;
    }

    @Override
    public int getSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId) {
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_SUITABLE_ROOM_FOR_SLOT)
                .setParameter(ParamConstant.SLOT_HOUR,slotHourId).setParameter(ParamConstant.CHURCH_ID,churchId)
                .setParameter(ParamConstant.SLOT_DATE,slotDate);
        int result=(Integer)query.uniqueResult();
        return result;
    }
}
