package com.churchsystem.model;

import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.EventModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Repository
public class EventModel extends CommonDAO implements EventModelInterface {

    @Override
    public List<EventDataEntity> getListOfEvent(){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_EVENT_DISPLAY_SLOT)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<EventDataEntity> result=query.list();
        return result;
    }
}
