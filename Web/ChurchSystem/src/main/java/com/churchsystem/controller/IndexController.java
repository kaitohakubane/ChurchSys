package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Hung on 11/21/2016.
 */
@Controller
public class IndexController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @RequestMapping(value = {PageConstant.MANAGER_ROOT_PATH_URL}, method = RequestMethod.GET)
    public ModelAndView initManagerHomePage(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity= userServiceInterface.getUserByAccountId(auth.getName());
        int churchId=userServiceInterface.getChurchIdByUserId(userEntity.getUserId());
        request.getSession().setAttribute("churchId",churchId);
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
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority(UtilsConstant.MANAGER_USER))) {
            modelAndView = new ModelAndView(PageConstant.HOME_PAGE);
        } else if(authorities.contains(new SimpleGrantedAuthority(UtilsConstant.NORMAL_USER))) {
            modelAndView=new ModelAndView(PageConstant.MAP_PAGE);
        }else{
            modelAndView = new ModelAndView(PageConstant.LOGIN_PAGE);
        }

        return modelAndView;
    }

}
