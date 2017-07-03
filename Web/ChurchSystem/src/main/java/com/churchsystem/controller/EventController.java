package com.churchsystem.controller;

import com.churchsystem.common.api.YoutubeAPI;
import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.*;
import com.google.api.services.youtube.model.LiveBroadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Controller
public class EventController {
    @Value("${server.port}")
    int serverPort;

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

    @Autowired
    UserServiceInterface userServiceInterface;


    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_EVENT_URL, method = RequestMethod.POST)
    public List<EventDisplayEntity> createEvent(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        List<EventDisplayEntity> result = null;
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
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
                    , privacy, churchId, null, null);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId);

            SlotEntity slotEntity = eventServiceInterface.createSlotForEvent(slotDate, slotHour, churchId, subId);
            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(slotEntity.getEventId());
            for (int i = 0; i < slotEntities.size(); i++) {
                eventServiceInterface.mappingResource(slotEntities.get(i).getSlotId(), slotHour);
            }


            result = eventServiceInterface.getCreatedEvent(slotEntity.getEventId());
            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
            eventServiceInterface.updateEvent(eventEntity);
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


    @RequestMapping(value = PageConstant.UPDATE_EVENT_URL, method = RequestMethod.POST)
    public ModelAndView editEvent(@RequestParam(value = ParamConstant.SLOT_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int slotId = Integer.parseInt(id);
/*
            Code to intial information here
 */
            modelAndView = new ModelAndView(PageConstant.EDIT_EVENT_PAGE);

        } catch (Exception e) {

        }

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_CLASS_URL, method = RequestMethod.POST)
    public List<EventDisplayEntity> createClass(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        List<EventDisplayEntity> result = null;
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            int slotHour = Integer.parseInt(eventJsonEntity.getSlotHour());
            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());
            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }
            int numberOfSlot = Integer.parseInt(eventJsonEntity.getNumOfSlot());
            Date examDate = DateUtils.getDate(eventJsonEntity.getExamDate());


            TypeEntity typeEntity = slotServiceInterface.getTypeByDescription(eventJsonEntity.getType());
            if (typeEntity == null) {
                typeEntity = new TypeEntity();
                typeEntity.setDescription(eventJsonEntity.getType());
                slotServiceInterface.addNewType(typeEntity);
                typeEntity = slotServiceInterface.getTypeByDescription(eventJsonEntity.getType());
            }

            //Create Class
            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), slotDate, subId, slotHour
                    , privacy, churchId, examDate, typeEntity.getTypeId());

            List<Date> datesOfClass = DateUtils.getListOfClassDate(eventJsonEntity.getType(), eventJsonEntity.getSlotDate(), numberOfSlot);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId);


            Integer conductorId = null;
            Integer roomId = null;
            Date safeDate = null;
            for (int i = 0; i < datesOfClass.size(); i++) {
                Date item = datesOfClass.get(i);
                conductorId = userServiceInterface.getSuitableConductorForSlot(slotHour, item, churchId);
                roomId = roomServiceInterface.getSuitableRoomForSlot(slotHour, item, churchId);
                if (conductorId != null && roomId != null) {
                    safeDate = item;
                    break;
                }
            }

            if (safeDate != null) {
                for (int i = 0; i < datesOfClass.size(); i++) {
                    Date itemDate = datesOfClass.get(i);
                    eventServiceInterface.createSlotForClass(eventEntity.getEventId(), slotHour, churchId,
                            roomId, conductorId, itemDate);
                }

                List<SlotEntity> slotEntities=slotServiceInterface.getSlotByEventId(eventEntity.getEventId());

                for(SlotEntity slotEntity:slotEntities){
                    eventServiceInterface.mappingResource(slotEntity.getSlotId(), slotHour);
                }

                List<RegistrationEntity> registrationEntities=registrationServiceInterface.getWaitingRegistrationBySubId(subId);
                for(RegistrationEntity entity: registrationEntities){
                    entity.setEventId(eventEntity.getEventId());
                    entity.setRegisStatus(ParamConstant.REGISTRATION_FINISH_STATUS);
                    registrationServiceInterface.updateRegistration(entity);
                }

                result = eventServiceInterface.getCreatedEvent(eventEntity.getEventId());


                eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
                eventServiceInterface.updateEvent(eventEntity);

            } else {
                eventEntity.setEventStatus(ParamConstant.EVENT_DENY_STATUS);
                eventServiceInterface.updateEvent(eventEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
