package com.sneakergo.service.interfaces;

import com.sneakergo.entity.StockDisplayEntity;
import com.sneakergo.entity.StockEntity;

import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
public interface StockServiceInterface {
    StockEntity getStockByProductIDAndAttributeID(int productID, int attributeID);

    void updateStockQuantity(StockEntity stockEntity);

    void createStock(StockEntity stockEntity);

    List getSizeOfProduct(int productID);

    List<StockDisplayEntity> getStock();

    StockEntity getStockByStockID(int stockID);

    int countStockRecord();

    int countAvailableStockRecord();

}
