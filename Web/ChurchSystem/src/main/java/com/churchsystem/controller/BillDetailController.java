package com.sneakergo.controller;

import com.sneakergo.common.constants.PageConstant;
import com.sneakergo.common.constants.ParamConstant;
import com.sneakergo.common.constants.UtilsConstant;
import com.sneakergo.common.utils.NumbericUtils;
import com.sneakergo.entity.*;
import com.sneakergo.service.interfaces.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hung on 11/30/2016.
 */
@Controller
public class BillDetailController {

    @Autowired
    BillDetailServiceInterface billDetailServiceInterface;

    @Autowired
    AccountServiceInterface accountServiceInterface;

    @Autowired
    BillServiceInterface billServiceInterface;

    @Autowired
    SaleServiceInterface saleServiceInterface;

    @Autowired
    ProductServiceInterface productServiceInterface;

    @Autowired
    StockServiceInterface stockServiceInterface;

    @Autowired
    AttributeServiceInterface attributeServiceInterface;


    @RequestMapping(value = PageConstant.BILL_DETAIL_PAGE_URL, method = RequestMethod.POST)
    public ModelAndView searchBillDetail(@RequestParam(value = ParamConstant.BILL_ID) int billId,
                                         @RequestParam(value = ParamConstant.FROM_DATE) String fromDate,
                                         @RequestParam(value = ParamConstant.TO_DATE) String toDate) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.BILL_DETAIL_PAGE);
        BillEntity billEntity = billServiceInterface.getBillByID(billId);
        if (billEntity != null) {
            AccountEntity accountEntity = accountServiceInterface.getAccountByID(billEntity.getAccountId());
            List<BillDetailDisplayEntity> billDetail = billDetailServiceInterface.getBillDetailByBill(billId);
            modelAndView.addObject(ParamConstant.BILL_DETAIL_LIST, billDetail).
                    addObject(ParamConstant.CUSTOMER, accountEntity).addObject(ParamConstant.BILL, billEntity)
                    .addObject(ParamConstant.FROM_DATE, fromDate).addObject(ParamConstant.TO_DATE, toDate);
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CHECKOUT_URL, method = RequestMethod.POST)
    public BillEntity createBillDetail(@RequestParam(value = ParamConstant.ORDER) String strOrder) {
        try {
            List<SneakerOrder> orders = new ArrayList<SneakerOrder>();


            JSONArray jsonarray = new JSONArray(strOrder);

            BillEntity billEntity = new BillEntity();

            int totalPrice = UtilsConstant.ZERO;
            String accountId;
            double salePercent = 0;
            int price=UtilsConstant.ZERO;
            for (int i = 0; i < jsonarray.length(); i++) {
                SneakerOrder order = new SneakerOrder();
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                accountId = jsonobject.getString(ParamConstant.ACCOUNT_ID);
                int productId = jsonobject.getInt(ParamConstant.PRODUCT_ID);
                int quantity = jsonobject.getInt(ParamConstant.QUANTITY);
                String size = jsonobject.getString(ParamConstant.SIZE);
                order.setAccountId(accountId);
                order.setProductId(productId);
                order.setQuantity(quantity);
                order.setSize(size);
                orders.add(order);
            }

            billEntity=billServiceInterface.createBill(billEntity);

            //Insert data base for each product in bill
            for (SneakerOrder order : orders) {
                BilldetailEntity billDetailEntity = new BilldetailEntity();
                SaleEntity sale = saleServiceInterface.getSaleByProductId(order.getProductId());
                if (sale != null) {
                    salePercent = UtilsConstant.ONE - (sale.getSalePercent() / 100.0);
                } else {
                    salePercent = UtilsConstant.ONE;
                }

                //Create bill detail record
                price=UtilsConstant.ZERO;
                price += order.getQuantity() * salePercent * Integer.parseInt(productServiceInterface.getProductByID(order.getProductId()).getPrice());
                totalPrice+=price;
                billDetailEntity.setBillId(billEntity.getBillId());

                //Handle stockId attribute of billdetail
                AttributeEntity attributeEntity=attributeServiceInterface.getAttributeBySize(order.getSize());
                StockEntity stockEntity= stockServiceInterface.getStockByProductIDAndAttributeID
                        (order.getProductId(),attributeEntity.getAttributeId());
                billDetailEntity.setStockId(stockEntity.getStockId());

                billDetailEntity.setPrice(String.valueOf(price));
                billDetailEntity.setQuantity(order.getQuantity());
                billDetailServiceInterface.createBillDetail(billDetailEntity);

                //Update stock


                stockEntity.setQuantity(stockEntity.getQuantity()-order.getQuantity());
                stockServiceInterface.updateStockQuantity(stockEntity);
            }

            //Create bill
            billEntity.setDate(NumbericUtils.getCurrentDate());
            billEntity.setAccountId(orders.get(UtilsConstant.ZERO).getAccountId());
            billEntity.setTotalPrice(String.valueOf(totalPrice));
            billEntity.setEnabled(true);
            billServiceInterface.updateBill(billEntity);

            return billEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
