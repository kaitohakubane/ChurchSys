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

            eventServiceInterface.createEvent(eventName, slotDate, subId, false, churchId
                    , null, ParamConstant.NON_REPEAT_TYPE, true, UtilsConstant.ONE);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId, true);

            registrationServiceInterface.addNewRegistration(userEntity.getUserId(), churchId, subId, eventEntity.getEventId(), null);

            eventServiceInterface.createSlotForUserEvent(eventEntity.getEventId(), startTime, endTime, churchId, slotDate, subId);


            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(eventEntity.getEventId());
            List<SlothourEntity> slothourEntities = slotServiceInterface.getSlotHourByTimeRange(startTimeStr, estTime);
            for (int i = 0; i < slothourEntities.size(); i++) {
                eventServiceInterface.mappingResource(slotEntities.get(0).getSlotId(), slothourEntities.get(i).getSlotHourId());
            }

            EventDisplayEntity eventDisplayEntity = eventServiceInterface.getCreatedEvent(eventEntity.getEventId(), null).get(0);
            eventDisplayEntity.setDescription(message);
            //Notify manager
            String managerAccount = userServiceInterface.getChurchManagerAccount(churchId);
            UserEntity user = userServiceInterface.getUserByAccountId(managerAccount);
            String subjectName = subjectServiceInterface.getSubjectById(subId).getSubName();
            String information = ParamConstant.EVENT_NAME_PRE + subjectName + ParamConstant.TIME_MESSAGE_NOTIFICATION +
                    startTimeStr + " " + slotDateStr + ParamConstant.MANAGER_REGISTRATION_MESSAGE;
            Timestamp time = new Timestamp(System.currentTimeMillis());
            NotificationEntity notificationEntity = new NotificationEntity();
            notificationEntity.setTime(time);
            notificationEntity.setType(ParamConstant.DEFAULT_TYPE);
            notificationEntity.setUserId(user.getUserId());
            notificationEntity.setInformation(information);
            notificationEntity.setSender(UtilsConstant.SYSTEM_NAME);
            ////////////////////////////////////
            notificationEntity.setLink("");
            notificationServiceInterface.addNotification(notificationEntity);
            Notification msgEntity = new Notification(notificationEntity);
            notificationServiceInterface.notify(msgEntity, managerAccount);

            //Notify user
//            notificationEntity.setUserId(userEntity.getUserId());
//            information = ParamConstant.USER_EVENT_REGISTRATION_NOTIFICATION + subjectName +
//                    ParamConstant.TIME_MESSAGE_NOTIFICATION + startTimeStr + " " + slotDateStr;
//            notificationEntity.setInformation(information);
//            notificationEntity.setSender(churchServiceInterface.getChurchById(churchId).getChurchName());
//            notificationServiceInterface.addNotification(notificationEntity);
//
//            msgEntity = new Notification(notificationEntity);
//            notificationServiceInterface.notify(msgEntity, userEntity.getAccountId());
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
            List<RegistrationEntity> registrationEntities = userServiceInterface.getAllRegistrationByUserId(userEntity.getUserId());
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchIdInt);

            List<ClassDisplayEntity> classList = registrationServiceInterface.getOnPlanClass(churchIdInt);
            for (int i = 0; i < classList.size(); i++) {
                for (int j = 0; j < registrationEntities.size(); j++) {
                    if(classList.get(i).getEventId() == registrationEntities.get(j).getEventId()){
                        classList.get(i).setUserStatus(ParamConstant.REGISTERED);
                        break;
                    }
                }
            }
            List<ClassDisplayEntity> classOnGoingList = registrationServiceInterface.getOnGoingPlanClass(churchIdInt);
            for (int i = 0; i < classOnGoingList.size(); i++) {
                for (int j = 0; j < registrationEntities.size(); j++) {
                    if(classOnGoingList.get(i).getEventId() == registrationEntities.get(j).getEventId()){
                        classOnGoingList.get(i).setUserStatus(ParamConstant.REGISTERED);
                        break;
                    }
                }
            }
            modelAndView.addObject(ParamConstant.ON_PLAN_CLASS_LIST, classList)
                    .addObject(ParamConstant.ON_GOING_CLASS_LIST, classOnGoingList)
                    .addObject(ParamConstant.CHURCH_OBJECT, churchEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return modelAndView;
    }

    //KietTA
    @ResponseBody
    @RequestMapping(value = PageConstant.CLASS_REGISTRATION, method = RequestMethod.POST)
    public int classRegister(
            @RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr,
            @RequestParam(value = ParamConstant.SUBJECT_ID) String subIdStr,
            @RequestParam(value = ParamConstant.REGISTRATION_MESSAGE) String message,
            @RequestParam(value = ParamConstant.REGISTRATION_EST_TIME) String estTime) {
        try {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());


            int churchId = Integer.parseInt(churchIdStr);

            //Notify manager
            String managerAccount = userServiceInterface.getChurchManagerAccount(churchId);
            UserEntity user = userServiceInterface.getUserByAccountId(managerAccount);


//            String information = ParamConstant.EVENT_NAME_PRE + subjectName;
            Timestamp time = new Timestamp(System.currentTimeMillis());
            NotificationEntity notificationEntity = new NotificationEntity();
            notificationEntity.setTime(time);
            notificationEntity.setType(ParamConstant.DEFAULT_TYPE);
            notificationEntity.setUserId(user.getUserId());
//            notificationEntity.setInformation(information);
            notificationEntity.setSender(UtilsConstant.SYSTEM_NAME);
            ////////////////////////////////////
            notificationEntity.setLink("");
            notificationServiceInterface.addNotification(notificationEntity);
            Notification msgEntity = new Notification(notificationEntity);
            notificationServiceInterface.notify(msgEntity, managerAccount);

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
}
