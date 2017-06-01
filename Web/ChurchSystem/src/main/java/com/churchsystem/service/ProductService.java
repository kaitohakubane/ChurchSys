//package com.churchsystem.service;
//
//import com.churchsystem.entity.ProductEntity;
//import com.churchsystem.model.interfaces.ProductModelInterface;
//import com.churchsystem.service.interfaces.ProductServiceInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by Hung on 11/17/2016.
// */
//@Service
//@Transactional
//public class ProductService implements ProductServiceInterface {
//    @Autowired
//    private ProductModelInterface productModelInterface;
//
//    @Override
//    public List<ProductEntity> getAllProduct() {
//        return productModelInterface.getAllProduct();
//    }
//
//    @Override
//    public boolean addProduct(ProductEntity product) {
//        return productModelInterface.addProduct(product);
//    }
//
//    @Override
//    public void updateProduct(ProductEntity product) {
//         productModelInterface.updateProduct(product);
//    }
//
//    @Override
//    public ProductEntity getProductByID(int productID) {
//        return productModelInterface.getProductByID(productID);
//    }
//
//    @Override
//    public List<ProductEntity> getProductByName(String productName) {
//        return productModelInterface.getProductByName(productName);
//    }
//
//    @Override
//    public int countProductRecord(){
//        return productModelInterface.countProductRecord();
//    }
//
//}
