package com.sneakergo.model;

import com.sneakergo.common.constants.SQLParamConstant;
import com.sneakergo.common.constants.UtilsConstant;
import com.sneakergo.entity.StockDisplayEntity;
import com.sneakergo.entity.StockEntity;
import com.sneakergo.model.common.CommonDAO;
import com.sneakergo.model.interfaces.StockModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hung on 11/20/2016.
 */
@Repository
public class StockModel extends CommonDAO implements StockModelInterface {

    @Override
    public StockEntity getStockByProductIDAndAttributeID(int productID, int attributeID) {
        Criteria criteria = getSession().createCriteria(StockEntity.class).add(Restrictions.eq("attributeId", attributeID))
                .add(Restrictions.eq("productId", productID));
        StockEntity stockEntity = (StockEntity) criteria.uniqueResult();
        return stockEntity;
    }

    public StockEntity getStockByStockID(int stockID) {
        StockEntity stockEntity = getSession().get(StockEntity.class, stockID);
        return stockEntity;
    }

    @Override
    public void updateStockQuantity(StockEntity stockEntity) {
        getSession().saveOrUpdate(stockEntity);
    }

    @Override
    public void createStock(StockEntity stockEntity) {
        getSession().persist(stockEntity);
    }

    @Override
    public List getSizeOfProduct(int productID) {
        Criteria criteria = getSession().createCriteria(StockEntity.class)
                .add(Restrictions.eq("productId", productID))
                .add(Restrictions.eq("enabled", true))
                .setProjection(Projections.property("attributeId"));
        return criteria.list();
    }

    @Override
    public List<StockDisplayEntity> getStock() {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_STOCK_RECORDS).
                setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<StockDisplayEntity> stockDisplayEntities = query.list();
        return stockDisplayEntities;
    }

    @Override
    public int countAvailableStockRecord(){
        Long count = (Long)getSession().createCriteria(StockEntity.class)
                .add(Restrictions.eq("enabled",true))
                .add(Restrictions.ne("attributeId", UtilsConstant.ONE))
                .setProjection(Projections.rowCount()).uniqueResult();
        return count.intValue();
    }

    @Override
    public int countStockRecord(){
        Long count = (Long)getSession().createCriteria(StockEntity.class)
                .add(Restrictions.eq("enabled",true))
                .setProjection(Projections.rowCount()).uniqueResult();
        return count.intValue();
    }
}
