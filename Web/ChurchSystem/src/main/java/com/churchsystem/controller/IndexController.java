package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.UtilsConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Hung on 11/21/2016.
 */
@Controller
public class IndexController {


    @RequestMapping(value = {PageConstant.MANAGER_ROOT_PATH_URL}, method = RequestMethod.GET)
    public ModelAndView initManagerHomePage() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.HOME_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = {PageConstant.ROOT_PATH_URL}, method = RequestMethod.GET)
    public ModelAndView initHomePage() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.MAP_PAGE);
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getAccount() {
        ModelAndView modelAndView;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (name.equalsIgnoreCase(UtilsConstant.NORMAL_USER)) {
            modelAndView=new ModelAndView(PageConstant.ROOT_PATH_URL);
        } else if(name.equalsIgnoreCase(UtilsConstant.MANAGER_USER)) {
            modelAndView = new ModelAndView(PageConstant.MANAGER_ROOT_PATH_URL);

        }else{
            modelAndView = new ModelAndView(PageConstant.LOGIN_PAGE);
        }

        return modelAndView;
    }

}
