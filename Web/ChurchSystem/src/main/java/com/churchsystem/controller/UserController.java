package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
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

import java.util.Collection;

/**
 * Created by hungmcse61561-admin on 7/1/2017.
 */
@Controller
public class UserController {
    @Autowired
    UserServiceInterface userServiceInterface;

    @RequestMapping(value = PageConstant.USER_NOTIFICATION_URL, method = RequestMethod.GET)
    public ModelAndView loadUserNotificationPage() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOTIFICATION_PAGE);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        UserEntity userEntity= userServiceInterface.getUserByAccountId(auth.getName());
        if (authorities.contains(new SimpleGrantedAuthority(UtilsConstant.MANAGER_USER))) {
            modelAndView = new ModelAndView(PageConstant.HOME_PAGE);
        } else if(authorities.contains(new SimpleGrantedAuthority(UtilsConstant.NORMAL_USER))) {
            modelAndView=new ModelAndView(PageConstant.MAP_PAGE);
        }
        return modelAndView;
    }
}
