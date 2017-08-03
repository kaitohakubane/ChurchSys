package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.*;
import com.churchsystem.service.interfaces.GraveServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */
@Controller
public class GraveController {
    @Autowired
    GraveServiceInterface graveServiceInterface;

    @RequestMapping(value = PageConstant.GRAVE_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch(HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        ModelAndView modelAndView = new ModelAndView(PageConstant.GRAVE_PAGE);
        List<GraveyardEntity> result = graveServiceInterface.getGraveYardOfChurch(churchId);
        modelAndView.addObject(ParamConstant.GRAVE_YARD_LIST,result);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_GRAVE_YARD, method = RequestMethod.POST)
    public List<GraveyardEntity> getGraveYard(HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        List<GraveyardEntity> result = graveServiceInterface.getGraveYardOfChurch(churchId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GENERATE_GRAVE_YARD, method = RequestMethod.POST)
    public List<GraveyardEntity> generate(HttpServletRequest request, @RequestParam(value = ParamConstant.WIDTH) String width,
                                          @RequestParam(value = ParamConstant.HEIGHT) String height) {
        try {
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            int widthInt = Integer.parseInt(width);
            int heightInt = Integer.parseInt(height);
            List<GraveyardEntity> result = graveServiceInterface.generateType1Prototype(widthInt, heightInt, churchId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_GRAVE, method = RequestMethod.POST)
    public List<GraveEntity> getGrave(@RequestParam(value = ParamConstant.GRAVE_YARD_ID) int graveYardId) {
        List<GraveEntity> result = graveServiceInterface.getGraveOfGraveYard(graveYardId);
        return result;
    }


}
