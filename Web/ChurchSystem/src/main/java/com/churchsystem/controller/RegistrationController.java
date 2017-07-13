package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.*;
import com.churchsystem.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<EventDisplayEntity> result = null;
        try {
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


            eventServiceInterface.createSlotForUserEvent(eventEntity.getEventId(), startTime, endTime, churchId, slotDate);


            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(eventEntity.getEventId());
            List<SlothourEntity> slothourEntities = slotServiceInterface.getSlotHourByTimeRange(startTimeStr, estTime);
            for (int i = 0; i < slothourEntities.size(); i++) {
                eventServiceInterface.mappingResource(slotEntities.get(0).getSlotId(), slothourEntities.get(i).getSlotHourId());
            }

            //Notify manager
            String managerAccount = userServiceInterface.getChurchManagerAccount(churchId);
            UserEntity user = userServiceInterface.getUserByAccountId(managerAccount);
            String subjectName = subjectServiceInterface.getSubjectById(subId).getSubName();
            String information = ParamConstant.EVENT_NAME_PRE + subjectName + ParamConstant.REGISTRATION_MESSAGE;
            Timestamp time = new Timestamp(System.currentTimeMillis());
            NotificationEntity notificationEntity = new NotificationEntity();
            notificationEntity.setTime(time);
            notificationEntity.setType(ParamConstant.DEFAULT_TYPE);
            notificationEntity.setUserId(user.getUserId());
            notificationEntity.setInformation(information);
            ////////////////////////////////////
            notificationEntity.setLink("");
            notificationServiceInterface.addNotification(notificationEntity);
            notificationServiceInterface.notify(notificationEntity, managerAccount);
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
            modelAndView.addObject(ParamConstant.ON_PLAN_CLASS_LIST, classList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelAndView;
    }

}
