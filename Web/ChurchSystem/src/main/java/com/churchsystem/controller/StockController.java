package com.sneakergo.controller;

import com.sneakergo.common.constants.PageConstant;
import com.sneakergo.common.constants.ParamConstant;
import com.sneakergo.entity.StockDisplayEntity;
import com.sneakergo.service.interfaces.StockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Hung on 11/22/2016.
 */
@Controller
public class StockController {
    @Autowired
    StockServiceInterface stockServiceInterface;

    @RequestMapping(value = {PageConstant.STOCK_PAGE_URL}, method = RequestMethod.GET)
    public ModelAndView initHomePage() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.STOCK_PAGE);
        List<StockDisplayEntity> stockDisplayEntityList=stockServiceInterface.getStock();
        modelAndView.addObject(ParamConstant.LIST_STOCK_ATTR,stockDisplayEntityList);
        return modelAndView;
    }
}
