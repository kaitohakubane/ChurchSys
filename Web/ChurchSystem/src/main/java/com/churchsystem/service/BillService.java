package com.sneakergo.service;

import com.sneakergo.common.utils.NumbericUtils;
import com.sneakergo.entity.AccountEntity;
import com.sneakergo.entity.BillDisplayEntity;
import com.sneakergo.entity.BillEntity;
import com.sneakergo.model.interfaces.BillModelInterface;
import com.sneakergo.service.interfaces.BillServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
@Service
@Transactional
public class BillService implements BillServiceInterface {

    @Autowired
    private BillModelInterface billModelInterface;

    @Override
    public BillEntity getBillByID(int billID) {
        return billModelInterface.getBillByID(billID);
    }

    @Override
    public List<BillEntity> getBillByAccount(AccountEntity accountEntity) {
        return billModelInterface.getBillByAccount(accountEntity);
    }

    @Override
    public List<BillDisplayEntity> getBillByTime(Date fromDate, Date toDate) {
        return billModelInterface.getBillByTime(fromDate, toDate);
    }

    @Override
    public void updateBill(BillEntity billEntity) {
        billModelInterface.updateBill(billEntity);
    }

    @Override
    public int countBillRecord(Date date) {
        return billModelInterface.countBillRecord(date);
    }

    @Override
    public int countTodayBillRecord(){
        Date currentDate= NumbericUtils.getCurrentDate();
        return billModelInterface.countBillRecord(currentDate);
    }

    @Override
    public BillEntity createBill(BillEntity billEntity){
        return billModelInterface.createBill(billEntity);
    }


}
