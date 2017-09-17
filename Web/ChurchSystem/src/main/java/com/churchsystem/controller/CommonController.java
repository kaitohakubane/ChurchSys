package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.SettingEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.service.ChurchService;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
    @Autowired
    ChurchServiceInterface churchServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;

    @RequestMapping(value = PageConstant.PRAY_URL, method = RequestMethod.GET)
    public ModelAndView loadPray(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
                modelAndView = new ModelAndView(PageConstant.PRAY_PAGE).addObject(ParamConstant.CHURCH_OBJECT, churchEntity).addObject(ParamConstant.CHURCH_SETTING, settingEntity);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    @RequestMapping(value = PageConstant.DONATION_URL, method = RequestMethod.GET)
    public ModelAndView loadDonation(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
                modelAndView = new ModelAndView(PageConstant.DONATION_PAGE).addObject(ParamConstant.CHURCH_OBJECT, churchEntity).addObject(ParamConstant.CHURCH_SETTING, settingEntity);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.CONTACT_URL, method = RequestMethod.GET)
    public ModelAndView loadContact(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity manager = userServiceInterface.getUserByAccountId(auth.getName());
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
                modelAndView = new ModelAndView(PageConstant.CONTACT_PAGE).addObject(ParamConstant.CHURCH_OBJECT, churchEntity)
                        .addObject(ParamConstant.CHURCH_SETTING, settingEntity).addObject(ParamConstant.USER_ID,manager.getUserId());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    @RequestMapping(value = PageConstant.BIBLE_URL, method = RequestMethod.GET)
    public ModelAndView loadBible() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            modelAndView = new ModelAndView(PageConstant.BIBLE_PAGE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.AUGUST_URL, method = RequestMethod.GET)
    public ModelAndView loadAugust() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            modelAndView = new ModelAndView(PageConstant.AUGUST_PAGE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
