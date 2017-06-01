//package com.churchsystem.model;
//
//import com.churchsystem.common.constants.SQLParamConstant;
//import com.churchsystem.entity.BillDetailDisplayEntity;
//import com.churchsystem.entity.BillEntity;
//import com.churchsystem.entity.BilldetailEntity;
//import com.churchsystem.model.common.CommonDAO;
//import com.churchsystem.model.interfaces.BillDetailModelInterface;
//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * Created by Hung on 11/21/2016.
// */
//@Repository
//public class BillDetailModel extends CommonDAO implements BillDetailModelInterface {
//
//    @Override
//    public List<BilldetailEntity> getBillDetailByBillID(BillEntity billEntity) {
//        Criteria criteria = getSession().createCriteria(BilldetailEntity.class)
//                .add(Restrictions.eq("billId", billEntity.getBillId()));
//        List<BilldetailEntity> billdetailEntities = criteria.list();
//        return billdetailEntities;
//    }
//
//    @Override
//    public List<BillDetailDisplayEntity> getBillDetailByBill(int billID) {
//        Query query = getSession().createSQLQuery(SQLParamConstant.GET_BILL_DETAIL_OF_BILL).
//                setParameter("billID",billID).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//        List<BillDetailDisplayEntity> billDetailDisplayEntities = query.list();
//        return billDetailDisplayEntities;
//    }
//
//    @Override
//    public void updateBillDetail(BilldetailEntity billdetailEntity){
//        getSession().saveOrUpdate(billdetailEntity);
//    }
//
//    @Override
//    public void createBillDetail(BilldetailEntity billdetailEntity){
//        getSession().persist(billdetailEntity);
//    }
//
//}
