package com.sneakergo.controller;

import com.sneakergo.common.constants.PageConstant;
import com.sneakergo.common.constants.ParamConstant;
import com.sneakergo.common.constants.UtilsConstant;
import com.sneakergo.common.utils.NumbericUtils;
import com.sneakergo.common.utils.StringUtils;
import com.sneakergo.entity.*;
import com.sneakergo.service.interfaces.AttributeServiceInterface;
import com.sneakergo.service.interfaces.ImportServiceInterface;
import com.sneakergo.service.interfaces.StockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/27/2016.
 */
@Controller
public class ImportController {
    @Autowired
    ImportServiceInterface importServiceInterface;

    @Autowired
    StockServiceInterface stockServiceInterface;

    @Autowired
    AttributeServiceInterface attributeServiceInterface;

    @RequestMapping(value = PageConstant.IMPORT_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView initImportPage() {
        Date currentDate = NumbericUtils.getCurrentDate();
        Date aMonthAgo = NumbericUtils.getNDateBeforeDate(UtilsConstant.THIRTY);
        List<ImportDisplayEntity> listImport = importServiceInterface.getImportByTime(aMonthAgo, currentDate);
        ModelAndView modelAndView = new ModelAndView(PageConstant.IMPORT_PAGE);
        modelAndView.addObject(ParamConstant.LIST_IMPORT_ATTR, listImport).addObject(ParamConstant.FROM_DATE, StringUtils.formatDateToString(aMonthAgo))
                .addObject(ParamConstant.TO_DATE, StringUtils.formatDateToString(currentDate));
        return modelAndView;
    }


    @RequestMapping(value = PageConstant.SEARCH_IMPORT_URL, method = RequestMethod.POST)
    public ModelAndView searchImport(@RequestParam(value = ParamConstant.FROM_DATE) String fromDate,
                                     @RequestParam(value = ParamConstant.TO_DATE) String toDate) {

        String[] from = StringUtils.formatDate(fromDate);
        String[] to = StringUtils.formatDate(toDate);
        Date fromTime = NumbericUtils.getDate(from[UtilsConstant.TWO],
                from[UtilsConstant.ONE], from[UtilsConstant.ZERO]);
        Date toTime = NumbericUtils.getDate(to[UtilsConstant.TWO],
                to[UtilsConstant.ONE], to[UtilsConstant.ZERO]);
        List<ImportDisplayEntity> listImport = importServiceInterface.getImportByTime(fromTime, toTime);
        ModelAndView modelAndView = new ModelAndView(PageConstant.IMPORT_PAGE);
        modelAndView.addObject(ParamConstant.LIST_IMPORT_ATTR, listImport)
                .addObject(ParamConstant.FROM_DATE, fromDate)
                .addObject(ParamConstant.TO_DATE, toDate);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_IMPORT_URL, method = RequestMethod.POST)
    public boolean importProduct(@RequestParam(value = ParamConstant.PRODUCT_ID) int productID,
                                 @RequestParam(value = ParamConstant.SIZE) String size,
                                 @RequestParam(value = ParamConstant.IMPORT_QUANTITY) int quantity,
                                 @RequestParam(value = ParamConstant.IMPORT_PRICE) String price,
                                 @RequestParam(value = ParamConstant.SUPPLIER) String supplier) {
        try {

            AttributeEntity attributeEntity=attributeServiceInterface.getAttributeBySize(size);
            if(attributeEntity==null){
                attributeEntity=new AttributeEntity();
                attributeEntity.setSize(size);
                attributeServiceInterface.insertAttribute(attributeEntity);
            }

            attributeEntity=attributeServiceInterface.getAttributeBySize(size);
            //Add quantity to stock
            StockEntity stockEntity = stockServiceInterface.
                    getStockByProductIDAndAttributeID(productID,attributeEntity.getAttributeId());
            if (stockEntity != null) {
                stockEntity.setQuantity(quantity + stockEntity.getQuantity());
                stockServiceInterface.updateStockQuantity(stockEntity);
            } else {
                stockEntity=new StockEntity();
                stockEntity.setAttributeId(attributeEntity.getAttributeId());
                stockEntity.setEnabled(true);
                stockEntity.setProductId(productID);
                stockEntity.setQuantity(quantity);
                stockServiceInterface.createStock(stockEntity);

                //Remove no stock product record
                AttributeEntity zeroSize= attributeServiceInterface.getAttributeBySize(UtilsConstant.ZERO_STRING);
                StockEntity zeroSizeEntity=stockServiceInterface.getStockByProductIDAndAttributeID
                        (stockEntity.getProductId(),zeroSize.getAttributeId());
                zeroSizeEntity.setEnabled(false);
                stockServiceInterface.updateStockQuantity(zeroSizeEntity);
            }

            //Get stock ID
            stockEntity = stockServiceInterface.
                    getStockByProductIDAndAttributeID(productID,attributeEntity.getAttributeId());

            //New import information
            ImportEntity importEntity = new ImportEntity();
            importEntity.setQuantity(quantity);
            importEntity.setImportDate(NumbericUtils.getCurrentDate());
            importEntity.setStockId(stockEntity.getStockId());
            importEntity.setPrice(price);
            importEntity.setSupplier(supplier);
            importServiceInterface.importProduct(importEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
