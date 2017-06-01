package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.service.interfaces.RegistrationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.jsp.PageContext;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Controller
public class RegistrationController {
    @Autowired
    RegistrationServiceInterface registrationServiceInterface;

    @RequestMapping(value= PageConstant.BILL_PAGE_URL,method= RequestMethod.GET)
    public ModelAndView getAllRegistration(){
        ModelAndView modelAndView=new ModelAndView(PageConstant.BILL_DETAIL_PAGE);
        List<RegisterDisplayEntity> registerList=registrationServiceInterface.getRegistration();
        modelAndView.addObject("registrationList",registerList);
        return modelAndView;
    }
}
