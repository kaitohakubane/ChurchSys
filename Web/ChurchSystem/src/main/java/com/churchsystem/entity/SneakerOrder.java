package com.sneakergo.entity;

/**
 * Created by Hung on 12/3/2016.
 */
public class SneakerOrder {
    String accountId;
    int productId;
    String size;
    int quantity;

    public SneakerOrder() {
    }

    public SneakerOrder(String accountId, int productId, String size, int quantity) {
        this.accountId = accountId;
        this.productId = productId;
        this.size = size;
        this.quantity = quantity;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
