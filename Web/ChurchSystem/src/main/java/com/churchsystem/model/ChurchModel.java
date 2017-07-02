package com.churchsystem.model;

import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Repository
public class ChurchModel extends CommonDAO implements ChurchModelInterface {
    @Override
    public ChurchEntity getChurchById(int churchId){
        Criteria criteria=getSession().createCriteria(ChurchEntity.class).add(Restrictions.eq("churchId",churchId));
        ChurchEntity result=(ChurchEntity) criteria.uniqueResult();
        return result;
    }

    @Override
    public void updateChurch(ChurchEntity churchEntity){
        getSession().saveOrUpdate(churchEntity);
    }
}
