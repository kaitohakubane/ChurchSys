package com.sneakergo.model.interfaces;

import com.sneakergo.entity.RevenueChart;

import java.util.List;

/**
 * Created by Hung on 12/5/2016.
 */
public interface ChartModelInterface {
    List<RevenueChart> getRevenueByYear(int year);
}
