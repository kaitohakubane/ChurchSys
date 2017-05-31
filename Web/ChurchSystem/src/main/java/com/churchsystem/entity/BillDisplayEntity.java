package com.sneakergo.entity;

import java.sql.Date;

/**
 * Created by Hung on 11/22/2016.
 */
public class BillDisplayEntity {
    private int billId;
    private String accountId;
    private String accountName;
    private String totalPrice;
    private Date date;
    private Boolean enabled;

    public BillDisplayEntity() {
    }

    public BillDisplayEntity(int billId, String accountId, String accountName, String totalPrice, Date date, Boolean enabled) {

        this.billId = billId;
        this.accountId = accountId;
        this.accountName = accountName;
        this.totalPrice = totalPrice;
        this.date = date;
        this.enabled = enabled;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


}
