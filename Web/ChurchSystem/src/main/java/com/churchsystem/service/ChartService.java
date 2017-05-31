package com.sneakergo.service;

import com.sneakergo.entity.RevenueChart;
import com.sneakergo.model.interfaces.ChartModelInterface;
import com.sneakergo.service.interfaces.ChartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hung on 12/5/2016.
 */

@Service
@Transactional
public class ChartService implements ChartServiceInterface {
    @Autowired
    ChartModelInterface chartModelInterface;

    @Override
    public List<RevenueChart> getRevenueByYear(int year){
        return chartModelInterface.getRevenueByYear(year);
    }
}
