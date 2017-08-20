package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.*;
import com.churchsystem.service.interfaces.*;
import com.mysql.fabric.xmlrpc.base.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Controller
public class RegistrationController {
    @Autowired
    RegistrationServiceInterface registrationServiceInterface;

    @Autowired
    EventServiceInterface eventServiceInterface;

    @Autowired
    SlotServiceInterface slotServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    SubjectServiceInterface subjectServiceInterface;

    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @Autowired
    private NotificationServiceInterface notificationServiceInterface;

    @Autowired
    private CategoryServiceInterface categoryServiceInterface;


//    @RequestMapping(value = PageConstant.REGISTRATION_MANAGEMENT_URL, method = RequestMethod.GET)
//    public ModelAndView getAllRegistration() {
//        ModelAndView modelAndView = new ModelAndView(PageConstant.REGISTRATION_PAGE);
////        List<RegisterDisplayEntity> registerList = registrationServiceInterface.getRegistration();
////        modelAndView.addObject(ParamConstant.LIST_REGISTRATION_ATTR, registerList);
//        return modelAndView;
//    }


    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_REGISTRATION, method = RequestMethod.POST)
    public EventDisplayEntity createRegistration(@RequestParam(value = ParamConstant.SUBJECT_ID) String subIdStr,
                                                 @RequestParam(value = ParamConstant.REGISTRATION_START_TIME) String startTimeStr,
                                                 @RequestParam(value = ParamConstant.REGISTRATION_EST_TIME) String estTimeStr,
                                                 @RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr,
                                                 @RequestParam(value = ParamConstant.SLOT_DATE) String slotDateStr,
                                                 @RequestParam(value = ParamConstant.REGISTRATION_MESSAGE) String message) {
        try {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());


            Date slotDate = DateUtils.getDate(slotDateStr);
            int subId = Integer.parseInt(subIdStr);
            int estTime = Integer.parseInt(estTimeStr);
            int churchId = Integer.parseInt(churchIdStr);
            Time startTime = DateUtils.parseStringToTime(startTimeStr);
            Time endTime = DateUtils.getEndTimeFromRange(startTime, estTime);

            String eventName = subjectServiceInterface.getSubjectById(subId).getSubName() + "-" + userEntity.getUserName();

            Timestamp creatingTime = new Timestamp(System.currentTimeMillis());
            eventServiceInterface.createEvent(eventName, slotDate, subId, false, churchId
                    , null, ParamConstant.NON_REPEAT_TYPE, true, UtilsConstant.ONE, creatingTime);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId, true, creatingTime);

            registrationServiceInterface.addNewRegistration(userEntity.getUserId(), churchId, subId, eventEntity.getEventId(), message);

            eventServiceInterface.createSlotForUserEvent(eventEntity.getEventId(), startTime, endTime, churchId, slotDate, subId);


            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(eventEntity.getEventId());
            List<SlothourEntity> slothourEntities = slotServiceInterface.getSlotHourByTimeRange(startTimeStr, estTime);
            for (int i = 0; i < slothourEntities.size(); i++) {
                eventServiceInterface.mappingResource(slotEntities.get(0).getSlotId(), slothourEntities.get(i).getSlotHourId());
            }

            EventDisplayEntity eventDisplayEntity = eventServiceInterface.getCreatedEvent(eventEntity.getEventId(), null).get(0);
            eventDisplayEntity.setDescription(message);

            //Notify manager
            Integer manager = userServiceInterface.getChurchManager(churchId);
            String subjectName = subjectServiceInterface.getSubjectById(subId).getSubName();

            String information = ParamConstant.EVENT_NAME_PRE + subjectName + ParamConstant.TIME_MESSAGE_NOTIFICATION +
                    startTimeStr + " " + slotDateStr + ParamConstant.MANAGER_REGISTRATION_MESSAGE;
            notificationServiceInterface.sendNotification(ParamConstant.SYSTEM_ID, manager, information, ParamConstant.DEFAULT_TYPE, null);

            //Notify user
            information = ParamConstant.USER_EVENT_REGISTRATION_NOTIFICATION + subjectName +
                    ParamConstant.TIME_MESSAGE_NOTIFICATION + startTimeStr + " " + slotDateStr;
            notificationServiceInterface.sendNotification(manager, userEntity.getUserId(), information, ParamConstant.DEFAULT_TYPE, null);
            return eventDisplayEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = PageConstant.GET_ON_PLAN_CLASS_URL, method = RequestMethod.GET)
    public ModelAndView getOnPlanClass(@RequestParam(value = ParamConstant.CHURCH_ID) String churchId) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.CHURCH_CLASS_PAGE);
        try {
            int churchIdInt = Integer.parseInt(churchId);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());

            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchIdInt);
            SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchIdInt);
            List<ClassDisplayEntity> classList = registrationServiceInterface.getOnPlanClass(churchIdInt);
            List<ClassDisplayEntity> classOnGoingList = registrationServiceInterface.getOnGoingPlanClass(churchIdInt);
            if (userEntity != null) {
                List<RegistrationEntity> registrationEntities = userServiceInterface.getAllRegistrationByUserId(userEntity.getUserId());
                if (registrationEntities != null) {
                    if (classList != null) {
                        registrationServiceInterface.changeStatusToDisplay(classList, registrationEntities);
                    }
                    if (classOnGoingList != null) {
                        registrationServiceInterface.changeStatusToDisplay(classOnGoingList, registrationEntities);
                    }
                }
            }
            modelAndView.addObject(ParamConstant.ON_PLAN_CLASS_LIST, classList)
                    .addObject(ParamConstant.ON_GOING_CLASS_LIST, classOnGoingList)
                    .addObject(ParamConstant.CHURCH_OBJECT, churchEntity)
                    .addObject(ParamConstant.SUBJECT_LIST, subjectServiceInterface.getDisplayedClass())
                    .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getClassCategoryList())
                    .addObject(ParamConstant.CHURCH_SETTING, settingEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    //KietTA
    @ResponseBody
    @RequestMapping(value = PageConstant.CLASS_REGISTRATION, method = RequestMethod.POST)
    public int registerNewClass(
            @RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr,
            @RequestParam(value = ParamConstant.SUBJECT_ID) String subIdStr,
            @RequestParam(value = ParamConstant.REGISTRATION_MESSAGE) String message) {
        try {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
            int subId = Integer.parseInt(subIdStr);

            int churchId = Integer.parseInt(churchIdStr);

            registrationServiceInterface.addNewRegistration(userEntity.getUserId(), churchId, subId, null, message);

            //Notify manager
            Integer manager = userServiceInterface.getChurchManager(churchId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.FOLLOW_CHURCH, method = RequestMethod.POST)
    public int followChurch(@RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
            int churchId = Integer.parseInt(churchIdStr);
            userServiceInterface.mapUserToChurch(userEntity.getUserId(), churchId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.PREDEFINED_CLASS_REGISTRATION, method = RequestMethod.POST)
    public int registerPredefinedClass(@RequestParam(value = ParamConstant.EVENT_ID) String eventIdStr) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
            int eventId = Integer.parseInt(eventIdStr);
            EventEntity eventEntity = eventServiceInterface.getEventById(eventId);
            registrationServiceInterface.addNewRegistration(userEntity.getUserId(), eventEntity.getChurchId(), eventEntity.getSubId(), eventId, null);


            //Notify
            String subjectName = subjectServiceInterface.getSubjectById(eventEntity.getSubId()).getSubName();
            int managerId = userServiceInterface.getChurchManager(eventEntity.getChurchId());
            String information = ParamConstant.DEFINED_CLASS_NAME_PRE + subjectName + ParamConstant.MANAGER_REGISTRATION_MESSAGE;
            notificationServiceInterface.sendNotification(ParamConstant.SYSTEM_ID, managerId, information, ParamConstant.DEFAULT_TYPE, null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.GET_USER_REGISTRATION, method = RequestMethod.POST)
    public UserRegistrationInformation getUserInformation(@RequestParam(value = ParamConstant.SLOT_ID) String slotIdStr) {
        UserRegistrationInformation result = new UserRegistrationInformation();
        try {
            int slotId = Integer.parseInt(slotIdStr);
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);
            RegistrationEntity entity = registrationServiceInterface.getRegistrationByEventId(slotEntity.getEventId());
            result.setDescription(entity.getMessage());
            UserEntity userEntity = userServiceInterface.getUserByUserId(entity.getUserId());
            result.setMail(userEntity.getEmail());
            result.setPhone(userEntity.getTel());
            result.setUserName(userEntity.getUserName());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ACCEPT_REGISTRATION_URL, method = RequestMethod.POST)
    public EventDisplayEntity acceptRegistration(@RequestParam(value = ParamConstant.SLOT_ID) String slotIdStr) {
        EventDisplayEntity result = new EventDisplayEntity();
        try {
            int slotId = Integer.parseInt(slotIdStr);
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);

            RegistrationEntity registrationEntity = registrationServiceInterface.getRegistrationByEventId(slotEntity.getEventId());
            registrationEntity.setRegisStatus(ParamConstant.REGISTRATION_FINISH_STATUS);
            registrationServiceInterface.updateRegistration(registrationEntity);

            EventEntity eventEntity = eventServiceInterface.getEventById(slotEntity.getEventId());
            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
            eventServiceInterface.updateEvent(eventEntity);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.REJECT_REGISTRATION_URL, method = RequestMethod.POST)
    public EventDisplayEntity rejectRegistration(@RequestParam(value = ParamConstant.SLOT_ID) String slotIdStr) {
        EventDisplayEntity result = new EventDisplayEntity();
        try {
            int slotId = Integer.parseInt(slotIdStr);
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);

            RegistrationEntity registrationEntity = registrationServiceInterface.getRegistrationByEventId(slotEntity.getEventId());
            registrationEntity.setRegisStatus(ParamConstant.REGISTRATION_DENY_STATUS);
            registrationServiceInterface.updateRegistration(registrationEntity);

            EventEntity eventEntity = eventServiceInterface.getEventById(slotEntity.getEventId());
            eventEntity.setEventStatus(ParamConstant.EVENT_DENY_STATUS);
            eventServiceInterface.updateEvent(eventEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = PageConstant.REGISTRATION_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.REGISTRATION_MANAGEMENT_PAGE);
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        List<RegisDisplayEntity> regisEventDisplayEntities = registrationServiceInterface.getAllRegisEvent(churchId);
        List<RegisDisplayEntity> regisClassDisplayEntities = registrationServiceInterface.getAllRegisClass(churchId);
        modelAndView.addObject(ParamConstant.REGISTRATION_EVENT_DISPLAY, regisEventDisplayEntities)
                .addObject(ParamConstant.REGISTRATION_CLASS_DISPLAY, regisClassDisplayEntities);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ACCEPT_EVENT_REGISTRATION_URL, method = RequestMethod.POST)
    public EventDisplayEntity acceptEventRegistration(@RequestParam(value = ParamConstant.REGISTRATION_ID) String regisIdStr) {
        EventDisplayEntity result = new EventDisplayEntity();
        try {
            int regisId = Integer.parseInt(regisIdStr);

            RegistrationEntity registrationEntity = registrationServiceInterface.getRegistrationById(regisId);
            registrationEntity.setRegisStatus(ParamConstant.REGISTRATION_FINISH_STATUS);
            registrationServiceInterface.updateRegistration(registrationEntity);

            EventEntity eventEntity = eventServiceInterface.getEventById(registrationEntity.getEventId());
            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
            eventServiceInterface.updateEvent(eventEntity);

            //Notify user
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity manager = userServiceInterface.getUserByAccountId(auth.getName());
            SubjectEntity subjectEntity = subjectServiceInterface.getSubjectById(eventEntity.getSubId());
            String information = ParamConstant.USER_ACCEPT_MESSAGE_PRE + subjectEntity.getSubName() +
                    ParamConstant.USER_TIME_MESSAGE + eventEntity.getStartDate().toString() + ParamConstant.USER_ACCEPT_MESSAGE_POST;
            notificationServiceInterface.sendNotification(manager.getUserId(), registrationEntity.getUserId(), information, ParamConstant.DEFAULT_TYPE, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.REJECT_EVENT_REGISTRATION_URL, method = RequestMethod.POST)
    public EventDisplayEntity rejectEventRegistration(@RequestParam(value = ParamConstant.REGISTRATION_ID) String regisIdStr) {
        EventDisplayEntity result = new EventDisplayEntity();
        try {
            int regisId = Integer.parseInt(regisIdStr);

            RegistrationEntity registrationEntity = registrationServiceInterface.getRegistrationById(regisId);
            registrationEntity.setRegisStatus(ParamConstant.REGISTRATION_DENY_STATUS);
            registrationServiceInterface.updateRegistration(registrationEntity);

            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(registrationEntity.getEventId());
            for (int i = 0; i < slotEntities.size(); i++) {
                slotServiceInterface.deleteSlotHourBySlotId(slotEntities.get(i).getSlotId());
                slotServiceInterface.deleteSlot(slotEntities.get(i).getSlotId());
            }

            EventEntity eventEntity = eventServiceInterface.getEventById(registrationEntity.getEventId());
            eventEntity.setEventStatus(ParamConstant.EVENT_DENY_STATUS);
            eventServiceInterface.updateEvent(eventEntity);

            //Notify user
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity manager = userServiceInterface.getUserByAccountId(auth.getName());
            SubjectEntity subjectEntity = subjectServiceInterface.getSubjectById(eventEntity.getSubId());
            String information = ParamConstant.USER_REJECT_MESSAGE_PRE + subjectEntity.getSubName() +
                    ParamConstant.USER_TIME_MESSAGE + eventEntity.getStartDate().toString() + ParamConstant.USER_REJECT_MESSAGE_POST;
            notificationServiceInterface.sendNotification(manager.getUserId(), registrationEntity.getUserId(), information, ParamConstant.DEFAULT_TYPE, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.REJECT_CLASS_REGISTRATION_URL, method = RequestMethod.POST)
    public EventDisplayEntity rejectClassRegistration(@RequestParam(value = ParamConstant.REGISTRATION_ID) String regisIdStr) {
        EventDisplayEntity result = new EventDisplayEntity();
        try {
            int regisId = Integer.parseInt(regisIdStr);

            RegistrationEntity registrationEntity = registrationServiceInterface.getRegistrationById(regisId);
            registrationEntity.setRegisStatus(ParamConstant.REGISTRATION_DENY_STATUS);
            registrationServiceInterface.updateRegistration(registrationEntity);

            //Notify user
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity manager = userServiceInterface.getUserByAccountId(auth.getName());
            EventEntity eventEntity = eventServiceInterface.getEventById(registrationEntity.getEventId());
            String information = ParamConstant.USER_CLASS_PRE + eventEntity.getEventName() +
                    ParamConstant.USER_TIME_MESSAGE + eventEntity.getStartDate().toString() + ParamConstant.USER_REJECT_MESSAGE_POST;
            notificationServiceInterface.sendNotification(manager.getUserId(), registrationEntity.getUserId(),
                    information, ParamConstant.DEFAULT_TYPE, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ACCEPT_CLASS_REGISTRATION_URL, method = RequestMethod.POST)
    public EventDisplayEntity acceptClassRegistration(@RequestParam(value = ParamConstant.REGISTRATION_ID) String regisIdStr) {
        EventDisplayEntity result = new EventDisplayEntity();
        try {
            int regisId = Integer.parseInt(regisIdStr);

            RegistrationEntity registrationEntity = registrationServiceInterface.getRegistrationById(regisId);
            registrationEntity.setRegisStatus(ParamConstant.REGISTRATION_FINISH_STATUS);
            registrationServiceInterface.updateRegistration(registrationEntity);

            //Notify user
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity manager = userServiceInterface.getUserByAccountId(auth.getName());
            EventEntity eventEntity = eventServiceInterface.getEventById(registrationEntity.getEventId());
            String information = ParamConstant.USER_CLASS_PRE + eventEntity.getEventName() +
                    ParamConstant.USER_TIME_MESSAGE + eventEntity.getStartDate().toString() + ParamConstant.USER_ACCEPT_MESSAGE_POST;
            notificationServiceInterface.sendNotification(manager.getUserId(), registrationEntity.getUserId(),
                    information, ParamConstant.DEFAULT_TYPE, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
