//package com.churchsystem.service;
//
//import com.churchsystem.entity.StockDisplayEntity;
//import com.churchsystem.entity.StockEntity;
//import com.churchsystem.model.interfaces.StockModelInterface;
//import com.churchsystem.service.interfaces.StockServiceInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by Hung on 11/21/2016.
// */
//@Service
//@Transactional
//public class StockService implements StockServiceInterface{
//    @Autowired
//    StockModelInterface stockModelInterface;
//
//    @Override
//    public StockEntity getStockByProductIDAndAttributeID(int productID, int attributeID){
//        return stockModelInterface.getStockByProductIDAndAttributeID(productID,attributeID);
//    }
//
//    public StockEntity getStockByStockID(int stockID){
//        return stockModelInterface.getStockByStockID(stockID);
//    }
//
//    @Override
//    public void updateStockQuantity(StockEntity stockEntity){
//          stockModelInterface.updateStockQuantity(stockEntity);
//    }
//
//    @Override
//    public void createStock(StockEntity stockEntity){
//         stockModelInterface.createStock(stockEntity);
//    }
//
//    @Override
//    public List getSizeOfProduct(int productID){
//        return stockModelInterface.getSizeOfProduct(productID);
//    }
//
//    @Override
//    public List<StockDisplayEntity> getStock(){
//        return stockModelInterface.getStock();
//    }
//
//    @Override
//    public int countStockRecord(){
//        return stockModelInterface.countStockRecord();
//    }
//
//    @Override
//    public int countAvailableStockRecord(){
//        return stockModelInterface.countAvailableStockRecord();
//    }
//}
