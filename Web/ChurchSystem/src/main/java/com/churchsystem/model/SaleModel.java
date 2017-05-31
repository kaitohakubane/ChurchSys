package com.sneakergo.model;

import com.sneakergo.common.constants.SQLParamConstant;

import com.sneakergo.common.constants.UtilsConstant;
import com.sneakergo.entity.SaleDisplayEntity;
import com.sneakergo.entity.SaleEntity;
import com.sneakergo.model.common.CommonDAO;
import com.sneakergo.model.interfaces.SaleModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/20/2016.
 */
@Repository
public class SaleModel extends CommonDAO implements SaleModelInterface {

    @Override
    public SaleEntity getSaleByID(int saleID) {
        return getSession().get(SaleEntity.class, saleID);
    }

    @Override
    public List<SaleDisplayEntity> getSaleByTime(Date fromTime, Date toTime) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_ALL_SALE_BY_TIME).
                setParameter("fromDate", fromTime).setParameter("toDate", toTime)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<SaleDisplayEntity> sales = query.list();
        return sales;
    }

    @Override
    public List<SaleEntity> getAllSale() {
        Criteria criteria = getSession().createCriteria(SaleEntity.class).add(Restrictions.eq("enabled", true)).
                addOrder(Order.desc("toDate"));
        List<SaleEntity> sales = criteria.list();
        return sales;
    }

    @Override
    public boolean createSave(SaleEntity saleEntity) {
        if (getSaleByID(saleEntity.getSaleId()) == null) {
            getSession().persist(saleEntity);
            return true;
        }
        return false;
    }

    @Override
    public void updateSale(SaleEntity sale) {
        getSession().saveOrUpdate(sale);
    }

    @Override
    public SaleEntity getSaleByProductId(int productId,Date date){
        Criteria criteria= getSession().createCriteria(SaleEntity.class).add(Restrictions.eq("enabled",true))
                .add(Restrictions.le("fromDate",date)).add(Restrictions.ge("toDate",date))
                .add(Restrictions.eq("productId",productId)).addOrder(Order.desc("fromDate"))
                .setMaxResults(UtilsConstant.ONE);
        SaleEntity saleEntity=(SaleEntity) criteria.uniqueResult();
        return saleEntity;
    }

    @Override
    public int countSaleRecordToday(Date date){
        Long count = (Long)getSession().createCriteria(SaleEntity.class)
                .add(Restrictions.le("fromDate",date))
                .add(Restrictions.ge("toDate",date))
                .add(Restrictions.eq("enabled",true))
                .setProjection(Projections.rowCount()).uniqueResult();
        return count.intValue();
    }
}
