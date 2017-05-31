package com.sneakergo.model.interfaces;

import com.sneakergo.entity.BillDetailDisplayEntity;
import com.sneakergo.entity.BillEntity;
import com.sneakergo.entity.BilldetailEntity;

import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
public interface BillDetailModelInterface {

    List<BilldetailEntity> getBillDetailByBillID(BillEntity billEntity);

    List<BillDetailDisplayEntity> getBillDetailByBill(int billID);

    void updateBillDetail(BilldetailEntity billdetailEntity);

    void createBillDetail(BilldetailEntity billdetailEntity);
}
