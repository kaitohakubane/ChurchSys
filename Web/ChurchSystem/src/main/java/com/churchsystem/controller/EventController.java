package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Controller
public class EventController {
    @Autowired
    TypeServiceInterface typeServiceInterface;

    @Autowired
    RoomServiceInterface roomServiceInterface;

    @Autowired
    SubjectServiceInterface subjectServiceInterface;

    @Autowired
    CategoryServiceInterface categoryServiceInterface;

    @Autowired
    RegistrationServiceInterface registrationServiceInterface;

    @Autowired
    EventServiceInterface eventServiceInterface;

    @Autowired
    SlotServiceInterface slotServiceInterface;

    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_EVENT_URL, method = RequestMethod.POST)
    public EventDisplayEntity loadEventRegister(@RequestParam(value = ParamConstant.EVENT_TITLE) String title,
                                                @RequestParam(value = ParamConstant.EVENT_DATE) String date,
                                                @RequestParam(value = ParamConstant.SUBJECT_ID) String inputSubId,
                                                @RequestParam(value = ParamConstant.SLOT_HOUR) String inputSlotHour) {
        EventDisplayEntity eventDisplayEntity=new EventDisplayEntity();
        try {
            Date slotDate= DateUtils.getDate(date);
            int subId=Integer.parseInt(inputSubId);
            int slotHour=Integer.parseInt(inputSlotHour);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventDisplayEntity;
    }

    @RequestMapping(value = PageConstant.SCHEDULE_URL, method = RequestMethod.GET)
    public ModelAndView loadSchedule(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.SCHEDULE_PAGE);
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);

        modelAndView.addObject(ParamConstant.LIST_REGISTERED_CLASS_ATTR,
                registrationServiceInterface.getNumberOfRegisteredClassByChurchId(churchId))
                .addObject(ParamConstant.SUBJECT_LIST, subjectServiceInterface.getDisplayedSubject())
                .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getEventCategoryList())
                .addObject(ParamConstant.SLOT_HOUR_LIST, slotServiceInterface.getListOfSlotHour());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.LOAD_EVENT_REGISTER_URL, method = RequestMethod.POST)
    public List<EventDisplayEntity> loadEventRegister(HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        List<EventDisplayEntity> data = eventServiceInterface.getListOfEvent(churchId);
        return data;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.LOAD_PUBLIC_EVENT_REGISTER_URL, method = RequestMethod.POST)
    public List<EventDisplayEntity> loadPublicEventRegister(HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        List<EventDisplayEntity> data = eventServiceInterface.getListOfPublicEvent(churchId);
        return data;
    }

}
