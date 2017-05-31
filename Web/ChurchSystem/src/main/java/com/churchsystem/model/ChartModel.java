package com.sneakergo.model;

import com.sneakergo.common.constants.SQLParamConstant;
import com.sneakergo.entity.RevenueChart;
import com.sneakergo.model.common.CommonDAO;
import com.sneakergo.model.interfaces.ChartModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hung on 12/4/2016.
 */
@Repository
public class ChartModel extends CommonDAO implements ChartModelInterface {
    @Override
    public List<RevenueChart> getRevenueByYear(int year) {
        Query query = getSession().createSQLQuery(SQLParamConstant.GET_REVENUE_EACH_MONTH).
                setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        query.setParameter("year", year);
        List<RevenueChart> chart= query.list();
        return chart;
    }

}
