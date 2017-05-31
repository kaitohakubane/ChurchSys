package com.sneakergo.entity;

/**
 * Created by Hung on 12/5/2016.
 */
public class RevenueChart {
    public String month;
    public String revenue;

    public RevenueChart() {
    }

    public RevenueChart(String month, String revenue) {

        this.month = month;
        this.revenue = revenue;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }
}
