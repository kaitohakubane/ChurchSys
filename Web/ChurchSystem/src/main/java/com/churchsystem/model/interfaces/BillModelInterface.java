package com.sneakergo.model.interfaces;

import com.sneakergo.entity.AccountEntity;
import com.sneakergo.entity.BillDisplayEntity;
import com.sneakergo.entity.BillEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/20/2016.
 */
public interface BillModelInterface {
    BillEntity getBillByID(int billID);

    List<BillEntity> getBillByAccount(AccountEntity accountEntity);

    List<BillDisplayEntity> getBillByTime(Date fromDate, Date toDate);

    void updateBill(BillEntity billEntity);

    int countBillRecord(Date date);

    BillEntity createBill(BillEntity billEntity);
}
