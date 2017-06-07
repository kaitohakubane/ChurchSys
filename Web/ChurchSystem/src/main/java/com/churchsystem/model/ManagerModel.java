package com.churchsystem.model;

import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.ManagerEntity;
import com.churchsystem.entity.ManagerRefEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.ManagerModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Repository
public class ManagerModel extends CommonDAO implements ManagerModelInterface {

    public List<ManagerRefEntity> getManagerBySub(int subId){
        Query query=getSession().createQuery(SQLParamConstant.GET_MANAGER_FOR_SUBJECT)
                .setParameter("requireSubId",subId)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<ManagerRefEntity> results=query.list();
        return results;
    }

    public ManagerEntity getManagerByAccountId(String accountId){
        Criteria criteria=getSession().createCriteria(ManagerEntity.class).add(Restrictions.eq("accountId",accountId));
        ManagerEntity managerEntity=(ManagerEntity) criteria.uniqueResult();
        return managerEntity;
    }

}
