package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChurchDisplayEntity;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.ChurchMapEntity;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Controller
public class ChurchController {
    @Autowired
    ChurchServiceInterface churchServiceInterface;

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
        try {
            Double Latitude = Double.parseDouble(strLatitude);
            Double Longitude = Double.parseDouble(strLongitude);

            int radius = ParamConstant.DEFAULT_RADIUS;
            while (result == null && radius < ParamConstant.MAXIMUM_DISTANCE) {
                result = churchServiceInterface.getNearbyChurch(Latitude, Longitude, radius);
                if (result == null) {
                    radius = radius + ParamConstant.ADDITIONAL_DISTANCE;
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
}
