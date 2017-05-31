package com.sneakergo.entity;

/**
 * Created by Hung on 11/21/2016.
 */
public class StockDisplayEntity {
    private int productID;
    private int attributeID;
    private int quantity;
    private String size;
    private String productName;

    public StockDisplayEntity(int productID, int attributeID, int quantity, String size, String productName) {
        this.productID = productID;
        this.attributeID = attributeID;
        this.quantity = quantity;
        this.size = size;
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
