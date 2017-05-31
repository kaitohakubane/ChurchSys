package com.sneakergo.controller;

import com.mysql.jdbc.Util;
import com.sneakergo.common.constants.PageConstant;
import com.sneakergo.common.constants.ParamConstant;
import com.sneakergo.common.constants.SQLParamConstant;
import com.sneakergo.common.constants.UtilsConstant;
import com.sneakergo.entity.ProductEntity;
import com.sneakergo.entity.ProductSellEntity;
import com.sneakergo.service.interfaces.BillServiceInterface;
import com.sneakergo.service.interfaces.ProductServiceInterface;
import com.sneakergo.service.interfaces.SaleServiceInterface;
import com.sneakergo.service.interfaces.StockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
@Controller
public class IndexController {
    @Autowired
    ProductServiceInterface productServiceInterface;

    @Autowired
    BillServiceInterface billServiceInterface;

    @Autowired
    StockServiceInterface stockServiceInterface;

    @Autowired
    SaleServiceInterface saleServiceInterface;

    @RequestMapping(value = {PageConstant.ADMIN_ROOT_PATH_URL, PageConstant.HOME_PAGE_URL}, method = RequestMethod.GET)
    public ModelAndView initHomePage() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.HOME_PAGE);
        int numberOfProduct = productServiceInterface.countProductRecord();
        int numberOfOrder = billServiceInterface.countTodayBillRecord();
        int numberOfStock = stockServiceInterface.countStockRecord();
        int numberOfAvailableStock=stockServiceInterface.countAvailableStockRecord();
        int numberOfSale = saleServiceInterface.countSaleRecordToday();
        ProductEntity productEntity = productServiceInterface.getProductByID(UtilsConstant.ONE);
        modelAndView.addObject(ParamConstant.TOP_SELL_PRODUCT, productEntity)
                .addObject(ParamConstant.NUMBER_OF_PRODUCT, numberOfProduct)
                .addObject(ParamConstant.NUMBER_OF_BILL, numberOfOrder)
                .addObject(ParamConstant.NUMBER_OF_STOCK, numberOfStock)
                .addObject(ParamConstant.NUMBER_OF_AVAILABLE_STOCK,numberOfAvailableStock)
                .addObject(ParamConstant.NUMBER_OF_SALE, numberOfSale);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getAccount() {
        ModelAndView modelAndView;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        if (!name.equalsIgnoreCase(UtilsConstant.ANONYMOUS_USER)) {
            modelAndView = new ModelAndView(PageConstant.HOME_PAGE_URL);
        } else {
            modelAndView = new ModelAndView(PageConstant.LOGIN_PAGE);
        }

        return modelAndView;
    }

}
