package com.sneakergo.model;

import com.sneakergo.common.constants.SQLParamConstant;
import com.sneakergo.entity.AccountEntity;
import com.sneakergo.entity.BillDisplayEntity;
import com.sneakergo.entity.BillEntity;
import com.sneakergo.model.common.CommonDAO;
import com.sneakergo.model.interfaces.BillModelInterface;
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
public class BillModel extends CommonDAO implements BillModelInterface {
    @Override
    public BillEntity getBillByID(int billID) {
        return getSession().get(BillEntity.class, billID);
    }

    @Override
    public List<BillEntity> getBillByAccount(AccountEntity accountEntity) {
        Criteria criteria = getSession().createCriteria(BillEntity.class)
                .add(Restrictions.eq("accountId", accountEntity.getAccountId())).addOrder(Order.desc("date"));
        List<BillEntity> bills = criteria.list();
        return bills;
    }

    @Override
    public List<BillDisplayEntity> getBillByTime(Date fromDate, Date toDate) {
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_ALL_BILL_IN_TIME).
                setParameter("fromDate",fromDate).setParameter("toDate",toDate)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<BillDisplayEntity> bills = query.list();
        return bills;
    }

    @Override
    public void updateBill(BillEntity billEntity){
        getSession().saveOrUpdate(billEntity);
    }

    @Override
    public int countBillRecord(Date date){
        Long count = (Long)getSession().createCriteria(BillEntity.class)
                .add(Restrictions.eq("date",date)).add(Restrictions.eq("enabled",true))
                .setProjection(Projections.rowCount()).uniqueResult();
        return count.intValue();
    }

    @Override
    public BillEntity createBill(BillEntity billEntity){
        getSession().persist(billEntity);
        return billEntity;
    }
}
