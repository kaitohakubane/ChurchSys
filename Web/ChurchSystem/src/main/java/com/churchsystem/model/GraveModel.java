package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.GraveDisplayEntity;
import com.churchsystem.entity.GraveEntity;
import com.churchsystem.entity.GraveyardEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.GraveModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
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
    public List<GraveDisplayEntity> getGraveOfGraveYard(int graveYardId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_LIST_GRAVE)
                .setParameter(ParamConstant.GRAVE_YARD_ID, graveYardId).setResultTransformer(Transformers.aliasToBean(GraveDisplayEntity.class));
        List<GraveDisplayEntity> result = query.list();
        return result;
    }


    @Override
    public GraveDisplayEntity getGravebyId(int graveYardId) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_GRAVE_BY_ID)
                .setParameter(ParamConstant.GRAVE_ID, graveYardId).setResultTransformer(Transformers.aliasToBean(GraveDisplayEntity.class));
        GraveDisplayEntity result = (GraveDisplayEntity) query.uniqueResult();
        return result;
    }

    @Override
    public GraveyardEntity getGraveYardById(int graveYardId) {
        Criteria criteria = getSession().createCriteria(GraveyardEntity.class).add(Restrictions.eq(ParamConstant.GRAVE_YARD_ID, graveYardId));
        GraveyardEntity result = (GraveyardEntity) criteria.uniqueResult();
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
        getSession().flush();
        getSession().clear();
    }

    @Override
    public void updateGraveYard(GraveyardEntity graveYardEntity) {
        getSession().saveOrUpdate(graveYardEntity);
    }

    @Override
    public GraveEntity getCreatingGrave(int graveYardId,int status){
        Criteria criteria=getSession().createCriteria(GraveEntity.class)
                .add(Restrictions.eq(ParamConstant.GRAVE_YARD_ID,graveYardId)).add(Restrictions.eq(ParamConstant.GRAVE_STATUS,status));
        GraveEntity result=(GraveEntity)criteria.list().get(0);
        return result;
    }
}

