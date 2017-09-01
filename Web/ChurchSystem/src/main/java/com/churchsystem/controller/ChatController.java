package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.SettingEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Hung on 9/1/2017.
 */
@Controller
public class ChatController {
    @RequestMapping(value = PageConstant.MANAGER_CONTACT_URL, method = RequestMethod.GET)
    public ModelAndView loadManagerContact() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.MANAGER_CONTACT_PAGE);
        return modelAndView;
    }
}
