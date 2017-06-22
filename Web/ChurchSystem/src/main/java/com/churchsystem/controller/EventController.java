package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.entity.EventJsonEntity;
import com.churchsystem.entity.SlotEntity;
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
    public List<EventDisplayEntity> loadEventRegister(@RequestBody EventJsonEntity eventJsonEntity,HttpServletRequest request) {
        List<EventDisplayEntity> result=null;
        int churchId=(Integer)request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            int slotHour = Integer.parseInt(eventJsonEntity.getSlotHour());
            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());
            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }

            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), slotDate, subId, slotHour
                    , privacy,churchId);

            SlotEntity slotEntity=eventServiceInterface.createSlotForEvent(slotDate,slotHour,churchId,subId);

            eventServiceInterface.mappingResource(slotEntity.getEventId(),slotHour);

            result=eventServiceInterface.getCreatedEvent(slotEntity.getEventId());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
    public List<EventDisplayEntity> loadPublicEventRegister(@PathVariable(value = "id") String id) {
        int churchId = UtilsConstant.ZERO;
        try {
            churchId = Integer.parseInt(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<EventDisplayEntity> data = eventServiceInterface.getListOfPublicEvent(churchId);
        return data;
    }


}
