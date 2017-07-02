package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChurchEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hungmcse61561-admin on 7/1/2017.
 */
@Controller
public class UserController {

    @RequestMapping(value = PageConstant.USER_NOTIFICATION_URL, method = RequestMethod.GET)
    public ModelAndView loadPublicEventRegister() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOTIFICATION_PAGE);

        return modelAndView;
    }
}
