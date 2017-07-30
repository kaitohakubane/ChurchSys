package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.*;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Controller
public class ChurchController {
    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @RequestMapping(value = PageConstant.CHURCH_HOME_URL, method = RequestMethod.GET)
    public ModelAndView loadPublicEventRegister(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                modelAndView = new ModelAndView(PageConstant.CHURCH_HOME_PAGE);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.CHURCH_SCHEDULE_URL, method = RequestMethod.GET)
    public ModelAndView loadSchedule(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                modelAndView = new ModelAndView(PageConstant.CHURCH_SCHEDULE_PAGE);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CHURCH_SEARCH_URL, method = RequestMethod.POST)
    public List<ChurchMapEntity> getNearbyChurch(@RequestParam(value = ParamConstant.INPUT_LATITUDE) String strLatitude,
                                                 @RequestParam(value = ParamConstant.INPUT_LONGITUDE) String strLongitude) {
        List<ChurchMapEntity> result = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
        try {
            Double Latitude = Double.parseDouble(strLatitude);
            Double Longitude = Double.parseDouble(strLongitude);

            int radius = ParamConstant.DEFAULT_RADIUS;
            while (result == null && radius < ParamConstant.MAXIMUM_DISTANCE) {
                result = churchServiceInterface.getNearbyChurch(Latitude, Longitude, radius);
                if (result == null) {
                    radius = radius + ParamConstant.ADDITIONAL_DISTANCE;
                } else if (userEntity != null) {
                    List<InteractionEntity> followChurch = userServiceInterface.getUserInteraction(userEntity.getUserId());
                    if (followChurch.size() > 0) {
                        for (int i = 0; i < result.size(); i++) {
                            for (int k = 0; k < followChurch.size(); k++) {
                                if (result.get(i).getChurchId() == followChurch.get(k).getChurchId()) {
                                    result.get(i).setIsFollowed(ParamConstant.IS_FOLLOWING);
                                }
                            }
                        }
                    }
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        return result;
    }

    @RequestMapping(value = PageConstant.CHURCH_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.CHURCH_MANAGEMENT_PAGE);
        List<ChurchDisplayEntity> churchDisplayEntities = churchServiceInterface.getAllChurch();
        modelAndView.addObject(ParamConstant.CHURCH_LIST, churchDisplayEntities);
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.CHURCH_INFO_URL, method = RequestMethod.GET)
    public ModelAndView getIntroducePage(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                modelAndView = new ModelAndView(PageConstant.INTRODUCTION_PAGE)
                        .addObject(ParamConstant.CHURCH_INFORMATION, churchServiceInterface.getChurchInfo(churchId));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.CHURCH_SETTING_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView getSettingPage( HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                modelAndView = new ModelAndView(PageConstant.CHURCH_SETTING_PAGE)
                        .addObject(ParamConstant.CHURCH_OBJECT, churchServiceInterface.getChurchById(churchId));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATE_CHURCH_URL, method = RequestMethod.POST)
    public void updateChurch(@RequestParam(value = ParamConstant.CHURCH_NAME) String name,
                             @RequestParam(value = ParamConstant.CHURCH_ADDRESS) String address,
                             @RequestParam(value = ParamConstant.CHURCH_TEL) String tel,
                             @RequestParam(value = ParamConstant.CHURCH_MAIL) String mail,
                             @RequestParam(value = ParamConstant.CHURCH_DESCRIPTION) String des
            ,HttpServletRequest request){
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try{
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            churchEntity.setChurchName(name);
            churchEntity.setAddress(address);
            churchEntity.setTel(tel);
            churchEntity.setDescription(des);
            churchEntity.setMail(mail);
            churchServiceInterface.updateChurch(churchEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
