package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.service.interfaces.CategoryServiceInterface;
import com.churchsystem.service.interfaces.RegistrationServiceInterface;
import com.churchsystem.service.interfaces.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Controller
public class RegistrationController {
    @Autowired
    RegistrationServiceInterface registrationServiceInterface;



    @RequestMapping(value = PageConstant.REGISTRATION_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllRegistration() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.REGISTRATION_PAGE);
        List<RegisterDisplayEntity> registerList = registrationServiceInterface.getRegistration();
        modelAndView.addObject(ParamConstant.LIST_REGISTRATION_ATTR, registerList);
        return modelAndView;
    }





}
