package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.service.common.ChurchMailSender;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.security.Principal;
import java.sql.Time;
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
    @Autowired
    ChurchMailSender mailMail;

    @RequestMapping(value = {PageConstant.MANAGER_ROOT_PATH_URL}, method = RequestMethod.GET)
    public ModelAndView initManagerHomePage(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity= userServiceInterface.getUserByAccountId(auth.getName());
        int churchId=userServiceInterface.getChurchIdByUserId(userEntity.getUserId());
        request.getSession().setAttribute(ParamConstant.CHURCH_ID,churchId);
        ModelAndView modelAndView = new ModelAndView(PageConstant.HOME_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = {PageConstant.ROOT_PATH_URL}, method = RequestMethod.GET)
    public ModelAndView initHomePage(@RequestParam(value=ParamConstant.STREAM_LINK,required = false) String streamLink) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.MAP_PAGE);
        if(streamLink!=null){
            modelAndView.addObject(ParamConstant.STREAM_LINK,streamLink);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView loginHandler(HttpServletRequest request) {
        ModelAndView modelAndView;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority(UtilsConstant.MANAGER_USER))) {
            modelAndView = new ModelAndView(PageConstant.HOME_PAGE);
            UserEntity userEntity= userServiceInterface.getUserByAccountId(auth.getName());
            int churchId=userServiceInterface.getChurchIdByUserId(userEntity.getUserId());
            request.getSession().setAttribute(ParamConstant.CHURCH_ID,churchId);
        } else if(authorities.contains(new SimpleGrantedAuthority(UtilsConstant.NORMAL_USER))) {
            modelAndView=new ModelAndView(PageConstant.MAP_PAGE);
        }else if(authorities.contains(new SimpleGrantedAuthority(UtilsConstant.ADMIN_USER))){
            modelAndView=new ModelAndView(PageConstant.HOME_PAGE);
        }else{
            modelAndView = new ModelAndView(PageConstant.LOGIN_PAGE);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutHandler(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = {PageConstant.ADMIN_ROOT_PATH_URL}, method = RequestMethod.GET)
    public ModelAndView initAdminPage() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.HOME_PAGE);
        return modelAndView;
    }

}
