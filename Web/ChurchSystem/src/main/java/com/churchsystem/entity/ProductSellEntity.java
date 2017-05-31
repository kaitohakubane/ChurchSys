package com.sneakergo.entity;

/**
 * Created by Hung on 12/5/2016.
 */
public class ProductSellEntity {
    private int productId;
    private String productName;
    private String price;
    private String picture;
    private String nation;
    private String description;
    private Boolean enabled;
    private Integer salePercent;

    public ProductSellEntity(ProductEntity productEntity,int salePercent){
        this.productId = productEntity.getProductId();
        this.productName = productEntity.getProductName();
        this.price = productEntity.getPrice();
        this.picture = productEntity.getPicture();
        this.nation = productEntity.getNation();
        this.description = productEntity.getDescription();
        this.enabled = productEntity.getEnabled();
        this.salePercent = salePercent;
    }

    public ProductSellEntity(int productId, String productName, String price, String picture,
                             String nation, String description, Boolean enabled, Integer salePercent) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.picture = picture;
        this.nation = nation;
        this.description = description;
        this.enabled = enabled;
        this.salePercent = salePercent;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Integer salePercent) {
        this.salePercent = salePercent;
    }
}
