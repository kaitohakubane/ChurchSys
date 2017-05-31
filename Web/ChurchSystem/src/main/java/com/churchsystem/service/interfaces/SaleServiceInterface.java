package com.sneakergo.service.interfaces;

import com.sneakergo.entity.SaleDisplayEntity;
import com.sneakergo.entity.SaleEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
public interface SaleServiceInterface {
    SaleEntity getSaleByID(int saleID);

    List<SaleDisplayEntity> getSaleByTime(Date fromTime, Date toTime);

    List<SaleEntity> getAllSale();


    boolean createSave(SaleEntity saleEntity);

    void updateSale(SaleEntity sale);

    SaleEntity getSaleByProductId(int productId);

    int countSaleRecordToday();
}
