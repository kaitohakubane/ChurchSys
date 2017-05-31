package com.sneakergo.model;

import com.sneakergo.entity.AttributeEntity;
import com.sneakergo.entity.StockEntity;
import com.sneakergo.model.common.CommonDAO;
import com.sneakergo.model.interfaces.AttributeModelInterface;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tuple.Attribute;
import org.springframework.stereotype.Repository;

/**
 * Created by Hung on 11/29/2016.
 */
@Repository
public class AttributeModel extends CommonDAO implements AttributeModelInterface {

    @Override
    public AttributeEntity getAttributeBySize(String size) {
        Criteria criteria = getSession().createCriteria(AttributeEntity.class).
                add(Restrictions.eq("size", size));
        AttributeEntity attributeEntity = (AttributeEntity) criteria.uniqueResult();
        return attributeEntity;
    }

    @Override
    public void insertAttribute(AttributeEntity attributeEntity){
        getSession().persist(attributeEntity);
    }

    @Override
    public AttributeEntity getAttributeById(int attId) {
        AttributeEntity attributeEntity = getSession().get(AttributeEntity.class, attId);
        return attributeEntity;
    }

}
