package com.sneakergo.entity;

import java.sql.Date;

/**
 * Created by Hung on 11/26/2016.
 */
public class SaleDisplayEntity {
    private int saleId;
    private String productName;
    private Integer salePercent;
    private Date fromDate;
    private Date toDate;
    private Boolean enabled;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Integer salePercent) {
        this.salePercent = salePercent;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public SaleDisplayEntity() {

    }

    public SaleDisplayEntity(int saleId, String productName, Integer salePercent, Date fromDate, Date toDate, Boolean enabled) {

        this.saleId = saleId;
        this.productName = productName;
        this.salePercent = salePercent;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.enabled = enabled;
    }
}
