package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.GraveEntity;
import com.churchsystem.entity.GraveyardEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.GraveModelInterface;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */
@Repository
public class GraveModel extends CommonDAO implements GraveModelInterface {
    @Override
    public List<GraveyardEntity> getGraveYardOfChurch(int churchId) {
        Criteria criteria = getSession().createCriteria(GraveyardEntity.class).add(Restrictions.eq(ParamConstant.CHURCH_ID, churchId));
        List<GraveyardEntity> result = criteria.list();
        return result;
    }

    @Override
    public List<GraveEntity> getGraveOfGraveYard(int graveYardId) {
        Criteria criteria = getSession().createCriteria(GraveEntity.class).add(Restrictions.eq(ParamConstant.GRAVE_YARD_ID, graveYardId));
        List<GraveEntity> result = criteria.list();
        return result;
    }

    @Override
    public void addGrave(GraveEntity graveEntity) {
        getSession().persist(graveEntity);
    }

    @Override
    public void updateGrave(GraveEntity graveEntity) {
        getSession().saveOrUpdate(graveEntity);
    }

    @Override
    public void addGraveYard(GraveyardEntity graveYardEntity) {
        getSession().persist(graveYardEntity);
    }

    @Override
    public void updateGraveYard(GraveyardEntity graveYardEntity) {
        getSession().saveOrUpdate(graveYardEntity);
    }
}

