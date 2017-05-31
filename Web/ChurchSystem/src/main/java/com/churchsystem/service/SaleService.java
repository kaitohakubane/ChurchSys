package com.sneakergo.service;

import com.sneakergo.common.utils.NumbericUtils;
import com.sneakergo.entity.SaleDisplayEntity;
import com.sneakergo.entity.SaleEntity;
import com.sneakergo.model.interfaces.SaleModelInterface;
import com.sneakergo.service.interfaces.SaleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
@Service
@Transactional
public class SaleService implements SaleServiceInterface{
    @Autowired
    SaleModelInterface saleModelInterface;

    @Override
    public SaleEntity getSaleByID(int saleID) {
        return saleModelInterface.getSaleByID(saleID);
    }

    @Override
    public List<SaleDisplayEntity> getSaleByTime(Date fromTime,Date toTime) {
        return saleModelInterface.getSaleByTime(fromTime,toTime);
    }

    @Override
    public List<SaleEntity> getAllSale() {
        return saleModelInterface.getAllSale();
    }

    @Override
    public boolean createSave(SaleEntity saleEntity) {
        return saleModelInterface.createSave(saleEntity);
    }

    @Override
    public void updateSale(SaleEntity sale){
        saleModelInterface.updateSale(sale);
    }

    @Override
    public SaleEntity getSaleByProductId(int productId){
        Date date= NumbericUtils.getCurrentDate();
        return saleModelInterface.getSaleByProductId(productId,date);
    }

    @Override
    public int countSaleRecordToday(){
        return saleModelInterface.countSaleRecordToday(NumbericUtils.getCurrentDate());
    }
}
