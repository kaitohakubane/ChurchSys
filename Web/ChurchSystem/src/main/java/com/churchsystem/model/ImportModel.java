package com.sneakergo.model;

import com.sneakergo.common.constants.SQLParamConstant;
import com.sneakergo.entity.ImportDisplayEntity;
import com.sneakergo.entity.ImportEntity;
import com.sneakergo.model.common.CommonDAO;
import com.sneakergo.model.interfaces.ImportModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/20/2016.
 */
@Repository
public class ImportModel extends CommonDAO implements ImportModelInterface {

    @Override
    public void importProduct(ImportEntity importEntity) {
        getSession().persist(importEntity);
    }

    @Override
    public List<ImportEntity> getImportByStockId(int stockID) {
        Criteria criteria = getSession().createCriteria(ImportEntity.class).add(Restrictions.eq("stockId", stockID));
        List<ImportEntity> imports = criteria.list();
        return imports;
    }

    @Override
    public List<ImportEntity> getImportFromTimeToTime(Date fromTime, Date toTime) {
        Criteria criteria = getSession().createCriteria(ImportEntity.class).add(Restrictions
                .lt("importDate", toTime)).add(Restrictions.ge("importDate", toTime));
        List<ImportEntity> imports = criteria.list();
        return imports;
    }

    @Override
    public List<ImportDisplayEntity> getImportByTime(Date fromTime, Date toTime) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_ALL_IMPORT_IN_TIME).
                setParameter("fromDate", fromTime).setParameter("toDate", toTime)
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<ImportDisplayEntity> imports = query.list();
        return imports;
    }

}
