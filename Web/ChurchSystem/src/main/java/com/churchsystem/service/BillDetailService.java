//package com.churchsystem.service;
//
//import com.churchsystem.entity.BillDetailDisplayEntity;
//import com.churchsystem.entity.BillEntity;
//import com.churchsystem.entity.BilldetailEntity;
//import com.churchsystem.model.interfaces.BillDetailModelInterface;
//import com.churchsystem.service.interfaces.BillDetailServiceInterface;
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
//public class BillDetailService implements BillDetailServiceInterface {
//    @Autowired
//    BillDetailModelInterface billDetailModelInterface;
//
//    @Override
//    public List<BilldetailEntity> getBillDetailByBillID(BillEntity billEntity) {
//        return billDetailModelInterface.getBillDetailByBillID(billEntity);
//    }
//
//    @Override
//    public List<BillDetailDisplayEntity> getBillDetailByBill(int billID) {
//        return billDetailModelInterface.getBillDetailByBill(billID);
//    }
//
//    @Override
//    public void updateBillDetail(BilldetailEntity billdetailEntity) {
//        billDetailModelInterface.updateBillDetail(billdetailEntity);
//    }
//
//    @Override
//    public void createBillDetail(BilldetailEntity billdetailEntity) {
//        billDetailModelInterface.createBillDetail(billdetailEntity);
//    }
//}
