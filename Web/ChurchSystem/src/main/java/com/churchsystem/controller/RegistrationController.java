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


    @RequestMapping(value = PageConstant.REGISTRATION_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllRegistration() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.REGISTRATION_PAGE);
//        List<RegisterDisplayEntity> registerList = registrationServiceInterface.getRegistration();
//        modelAndView.addObject(ParamConstant.LIST_REGISTRATION_ATTR, registerList);
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_REGISTRATION, method = RequestMethod.POST)
    public int createRegistration(@RequestParam(value = ParamConstant.SUBJECT_ID) String subIdStr,
                                  @RequestParam(value = ParamConstant.REGISTRATION_START_TIME) String startTimeStr,
                                  @RequestParam(value = ParamConstant.REGISTRATION_EST_TIME) String estTimeStr,
                                  @RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr,
                                  @RequestParam(value = ParamConstant.SLOT_DATE) String slotDateStr) {
        try {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());


            Date slotDate = DateUtils.getDate(slotDateStr);
            int subId = Integer.parseInt(subIdStr);
            int estTime = Integer.parseInt(estTimeStr);
            int churchId = Integer.parseInt(churchIdStr);
            Time startTime = DateUtils.parseStringToTime(startTimeStr);
            Time endTime = DateUtils.getEndTimeFromRange(startTime, estTime);


            eventServiceInterface.createEvent(ParamConstant.USER_DEFAULT_EVENT_NAME, slotDate, subId, false, churchId
                    , null, ParamConstant.NON_REPEAT_TYPE, true, UtilsConstant.ONE);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId, true);


            eventServiceInterface.createSlotForUserEvent(eventEntity.getEventId(), startTime, endTime, churchId, slotDate, subId);


            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(eventEntity.getEventId());
            List<SlothourEntity> slothourEntities = slotServiceInterface.getSlotHourByTimeRange(startTimeStr, estTime);
            for (int i = 0; i < slothourEntities.size(); i++) {
                eventServiceInterface.mappingResource(slotEntities.get(0).getSlotId(), slothourEntities.get(i).getSlotHourId());
            }

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


            notificationEntity.setUserId(userEntity.getUserId());
            information = ParamConstant.USER_EVENT_REGISTRATION_NOTIFICATION + subjectName +
                    ParamConstant.TIME_MESSAGE_NOTIFICATION + startTimeStr + " " + slotDateStr;
            notificationEntity.setInformation(information);
            notificationEntity.setSender(churchServiceInterface.getChurchById(churchId).getChurchName());
            notificationServiceInterface.addNotification(notificationEntity);

            msgEntity = new Notification(notificationEntity);
            notificationServiceInterface.notify(msgEntity, userEntity.getAccountId());

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @RequestMapping(value = PageConstant.GET_ON_PLAN_CLASS_URL, method = RequestMethod.GET)
    public ModelAndView getOnPlanClass(@RequestParam(value = ParamConstant.CHURCH_ID) String churchId) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.CHURCH_CLASS_PAGE);
        try {
            int churchIdInt = Integer.parseInt(churchId);
            List<ClassDisplayEntity> classList = registrationServiceInterface.getOnPlanClass(churchIdInt);
            List<ClassDisplayEntity> classOnGoingList = registrationServiceInterface.getOnGoingPlanClass(churchIdInt);
            modelAndView.addObject(ParamConstant.ON_PLAN_CLASS_LIST, classList)
                    .addObject(ParamConstant.ON_GOING_CLASS_LIST, classOnGoingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CLASS_REGISTRATION, method = RequestMethod.POST)
    public int classRegister(@RequestParam(value = ParamConstant.EVENT_ID) String eventIdStr,
                             @RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr) {
        try {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());

            int eventId = Integer.parseInt(eventIdStr);
            int churchId = Integer.parseInt(churchIdStr);

            //Notify manager
            String managerAccount = userServiceInterface.getChurchManagerAccount(churchId);
            UserEntity user = userServiceInterface.getUserByAccountId(managerAccount);
            String subjectName = subjectServiceInterface.getSubjectById(eventServiceInterface.getEventById(eventId).getSubId()).getSubName();
            String information = ParamConstant.EVENT_NAME_PRE + subjectName;
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


            notificationEntity.setUserId(userEntity.getUserId());
            information = ParamConstant.USER_EVENT_REGISTRATION_NOTIFICATION + subjectName;
            notificationEntity.setInformation(information);
            notificationEntity.setSender(churchServiceInterface.getChurchById(churchId).getChurchName());
            notificationServiceInterface.addNotification(notificationEntity);

            msgEntity = new Notification(notificationEntity);
            notificationServiceInterface.notify(msgEntity, userEntity.getAccountId());

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

}
