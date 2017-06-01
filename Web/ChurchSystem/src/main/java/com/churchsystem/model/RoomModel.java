package com.churchsystem.model;

import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.RoomModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Repository
public class RoomModel extends CommonDAO implements RoomModelInterface {
    @Override
    public List<RoomEntity> getRoomBySub(Integer subId){
        Query query= getSession().createQuery(SQLParamConstant.GET_AVAILABLE_ROOM_FOR_SUBJECT)
                .setParameter("requireSubId",subId).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<RoomEntity> results=query.list();
        return results;
    }
}
