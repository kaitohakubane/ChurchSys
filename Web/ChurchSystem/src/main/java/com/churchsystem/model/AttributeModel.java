//package com.churchsystem.model;
//
//import com.churchsystem.entity.AttributeEntity;
//import com.churchsystem.entity.StockEntity;
//import com.churchsystem.model.common.CommonDAO;
//import com.churchsystem.model.interfaces.AttributeModelInterface;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.stereotype.Repository;
//
///**
// * Created by Hung on 11/29/2016.
// */
//@Repository
//public class AttributeModel extends CommonDAO implements AttributeModelInterface {
//
//    @Override
//    public AttributeEntity getAttributeBySize(String size) {
//        Criteria criteria = getSession().createCriteria(AttributeEntity.class).
//                add(Restrictions.eq("size", size));
//        AttributeEntity attributeEntity = (AttributeEntity) criteria.uniqueResult();
//        return attributeEntity;
//    }
//
//    @Override
//    public void insertAttribute(AttributeEntity attributeEntity){
//        getSession().persist(attributeEntity);
//    }
//
//    @Override
//    public AttributeEntity getAttributeById(int attId) {
//        AttributeEntity attributeEntity = getSession().get(AttributeEntity.class, attId);
//        return attributeEntity;
//    }
//
//}
