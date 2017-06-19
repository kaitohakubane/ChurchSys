package com.churchsystem.model;

import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.EventModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

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
}
