package com.sneakergo.entity;

/**
 * Created by Hung on 11/30/2016.
 */
public class BillDetailDisplayEntity {

    private String productName;
    String size;
    private Integer quantity;
    private String price;
    private String total;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BillDetailDisplayEntity(String productName, String size, Integer quantity, String price, String total) {
        this.productName = productName;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public BillDetailDisplayEntity() {

    }
}
