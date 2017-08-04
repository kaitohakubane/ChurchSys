package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.*;
import com.churchsystem.service.interfaces.GraveServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/30/2017.
 */
@Controller
public class GraveController {
    @Autowired
    GraveServiceInterface graveServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @RequestMapping(value = PageConstant.GRAVE_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.GRAVE_PAGE);
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
                                          @RequestParam(value = ParamConstant.HEIGHT) String height,
                                          @RequestParam(value = ParamConstant.GRAVE_YARD_PROTOTYPE) String prototypeStr) {
        List<GraveyardEntity> result = new ArrayList<GraveyardEntity>();
        try {

            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            int widthInt = Integer.parseInt(width);
            int heightInt = Integer.parseInt(height);
            int prototype = Integer.parseInt(prototypeStr);
            if (prototype == 1) {
                result = graveServiceInterface.generateType1Prototype(widthInt, heightInt, churchId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_GRAVE, method = RequestMethod.POST)
    public List<GraveDisplayEntity> getGrave(@RequestParam(value = ParamConstant.GRAVE_YARD_ID) int graveYardId) {
        List<GraveDisplayEntity> result = graveServiceInterface.getGraveOfGraveYard(graveYardId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GENERATE_GRAVE, method = RequestMethod.POST)
    public GraveyardEntity generateGrave(@RequestParam(value = ParamConstant.WIDTH) String width,
                                         @RequestParam(value = ParamConstant.HEIGHT) String height,
                                         @RequestParam(value = ParamConstant.GRAVE_YARD_ID) String graveYard) {
        GraveyardEntity result = new GraveyardEntity();
        try {
            int widthInt = Integer.parseInt(width);
            int heightInt = Integer.parseInt(height);
            int graveYardId = Integer.parseInt(graveYard);
            result = graveServiceInterface.getGraveYardById(graveYardId);
            result.setWidth(widthInt);
            result.setHeight(heightInt);
            result.setStatus(ParamConstant.GRAVE_YARD_INITIAL);
            result.setGraveAvailable(heightInt * widthInt);
            graveServiceInterface.updateGraveYard(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.REGISTER_GRAVE, method = RequestMethod.POST)
    public GraveDisplayEntity registerGrave(@RequestParam(value = ParamConstant.GRAVE_YARD_ID) String graveYardId) {
        GraveDisplayEntity result = new GraveDisplayEntity();
        try {
            int graveYardIdInt = Integer.parseInt(graveYardId);
            GraveEntity graveEntity = new GraveEntity();
            graveEntity.setStatus(ParamConstant.GRAVE_PROCESSING);


            graveEntity.setGraveYardId(graveYardIdInt);
            /**
             * Code add cho Param lay tu grave-form
             *
             *
             *
             *
             */
            graveServiceInterface.addGrave(graveEntity);
            graveEntity = graveServiceInterface.getCreatingGrave(graveYardIdInt, ParamConstant.GRAVE_PROCESSING);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            if (authorities.contains(new SimpleGrantedAuthority(UtilsConstant.MANAGER_USER))) {
                graveEntity.setStatus(ParamConstant.GRAVE_APPROVED);
            } else {
                graveEntity.setStatus(ParamConstant.GRAVE_WAITING_FOR_APPROVE);
            }
            graveServiceInterface.updateGrave(graveEntity);
            result = graveServiceInterface.getGravebyId(graveEntity.getGraveId());

            GraveyardEntity graveyardEntity = graveServiceInterface.getGraveYardById(graveYardIdInt);
            graveyardEntity.setGraveAvailable(graveyardEntity.getGraveAvailable() - 1);
            graveServiceInterface.updateGraveYard(graveyardEntity);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.APPROVE_GRAVE_STATUS, method = RequestMethod.POST)
    public GraveEntity generateGrave(@RequestParam(value = ParamConstant.GRAVE_ID) String graveId,
                                         @RequestParam(value=ParamConstant.GRAVE_STATUS_TYPE) String type) {
        GraveEntity result = new GraveEntity();
        try {
            int typeInt = Integer.parseInt(type);
            int graveInt = Integer.parseInt(graveId);
            if(typeInt==ParamConstant.ACCEPT_TYPE){

                /**
                 *
                 *  Lay object Grave ra update status thanh approved
                 *
                 */
            }else {

                /**
                 *
                 * Xoa object grave trong DB
                 */

            }



            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
