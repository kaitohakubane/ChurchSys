package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Controller
public class ChurchController {
    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @RequestMapping(value = PageConstant.CHURCH_HOME_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView loadPublicEventRegister(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if(churchEntity!=null){
                modelAndView=new ModelAndView(PageConstant.CHURCH_HOME_PAGE);
                modelAndView.addObject(ParamConstant.CHURCH_OBJECT, churchEntity);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

}
