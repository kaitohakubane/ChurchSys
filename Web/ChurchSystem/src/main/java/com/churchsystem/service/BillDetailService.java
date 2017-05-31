package com.sneakergo.service;

import com.sneakergo.entity.BillDetailDisplayEntity;
import com.sneakergo.entity.BillEntity;
import com.sneakergo.entity.BilldetailEntity;
import com.sneakergo.model.interfaces.BillDetailModelInterface;
import com.sneakergo.service.interfaces.BillDetailServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
@Service
@Transactional
public class BillDetailService implements BillDetailServiceInterface {
    @Autowired
    BillDetailModelInterface billDetailModelInterface;

    @Override
    public List<BilldetailEntity> getBillDetailByBillID(BillEntity billEntity) {
        return billDetailModelInterface.getBillDetailByBillID(billEntity);
    }

    @Override
    public List<BillDetailDisplayEntity> getBillDetailByBill(int billID) {
        return billDetailModelInterface.getBillDetailByBill(billID);
    }

    @Override
    public void updateBillDetail(BilldetailEntity billdetailEntity) {
        billDetailModelInterface.updateBillDetail(billdetailEntity);
    }

    @Override
    public void createBillDetail(BilldetailEntity billdetailEntity) {
        billDetailModelInterface.createBillDetail(billdetailEntity);
    }
}
