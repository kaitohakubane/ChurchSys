package com.sneakergo.model.interfaces;

import com.sneakergo.entity.ProductEntity;

import java.util.List;

/**
 * Created by Hung on 11/17/2016.
 */
public interface ProductModelInterface {

    ProductEntity getProductByID(int productID);

    List<ProductEntity> getAllProduct();

    boolean addProduct(ProductEntity product);

    void updateProduct(ProductEntity product);

    List<ProductEntity> getProductByName(String productName);

    int countProductRecord();

}
