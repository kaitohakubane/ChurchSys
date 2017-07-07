package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.entity.EventJsonEntity;
import com.churchsystem.entity.RegisterDisplayEntity;
import com.churchsystem.service.interfaces.CategoryServiceInterface;
import com.churchsystem.service.interfaces.RegistrationServiceInterface;
import com.churchsystem.service.interfaces.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Controller
public class RegistrationController {
    @Autowired
    RegistrationServiceInterface registrationServiceInterface;



    @RequestMapping(value = PageConstant.REGISTRATION_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllRegistration() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.REGISTRATION_PAGE);
        List<RegisterDisplayEntity> registerList = registrationServiceInterface.getRegistration();
        modelAndView.addObject(ParamConstant.LIST_REGISTRATION_ATTR, registerList);
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_REGISTRATION, method = RequestMethod.POST)
    public List<EventDisplayEntity> createRegistration(@RequestParam(value=ParamConstant.SUBJECT_ID) String subId,
                                                       @RequestParam(value=ParamConstant.REGISTRATION_START_TIME) String startTime,
                                                       @RequestParam(value=ParamConstant.REGISTRATION_START_TIME) String estTime) {
        List<EventDisplayEntity> result = null;
//        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
//        try {
//            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
//            int subId = Integer.parseInt(eventJsonEntity.getSubId());
//            int slotHour = Integer.parseInt(eventJsonEntity.getSlotHour());
//            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());
//            boolean privacy = true;
//            if (intPrivacy == UtilsConstant.ZERO) {
//                privacy = false;
//            }
//
//            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), slotDate, subId, slotHour
//                    , privacy, churchId, null, null);
//
//            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
//                    subId, churchId);
//
//            SlotEntity slotEntity = eventServiceInterface.createSlotForEvent(slotDate, slotHour, churchId, subId);
//            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(slotEntity.getEventId());
//            for (int i = 0; i < slotEntities.size(); i++) {
//                eventServiceInterface.mappingResource(slotEntities.get(i).getSlotId(), slotHour);
//            }
//
//
//            result = eventServiceInterface.getCreatedEvent(slotEntity.getEventId());
//            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
//            eventServiceInterface.updateEvent(eventEntity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return result;
    }


}
