package com.churchsystem.controller;

import com.churchsystem.common.api.YoutubeAPI;
import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.common.utils.StringUtils;
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
import java.sql.Time;
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

            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), slotDate, subId
                    , privacy, churchId, null, ParamConstant.NON_REPEAT_TYPE, false, UtilsConstant.ONE);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId, false);
            SlotEntity slotEntity = eventServiceInterface.createSlotForEvent(slotDate, slotHour, churchId, subId, eventEntity.getEventId());
            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(slotEntity.getEventId());
            for (int i = 0; i < slotEntities.size(); i++) {
                eventServiceInterface.mappingResource(slotEntities.get(i).getSlotId(), slotHour);
            }


            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
            eventServiceInterface.updateEvent(eventEntity);

            result = eventServiceInterface.getCreatedEvent(slotEntity.getEventId());
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
    public ModelAndView editEvent(@RequestParam(value = ParamConstant.SLOT_ID) String id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int slotId = Integer.parseInt(id);
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            EventDataEntity eventDataEntity = eventServiceInterface.getEventBySlotId(slotId, churchId);
            List<SlothourEntity> slothourEntities = slotServiceInterface.getListOfSlotHour();
            modelAndView = new ModelAndView(PageConstant.EDIT_EVENT_PAGE);
            modelAndView.addObject(ParamConstant.SLOT_ENTITY, eventDataEntity)
                    .addObject(ParamConstant.SLOT_HOUR_LIST, slothourEntities);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.LOAD_CONDUCTOR, method = RequestMethod.POST)
    public List<UserEntity> loadEventConductor(@RequestParam(value = ParamConstant.SLOT_ID) String id,
                                               @RequestParam(value = ParamConstant.START_TIME) String currentStartTime,
                                               @RequestParam(value = ParamConstant.END_TIME) String currentEndTime,
                                               HttpServletRequest request) {
        int slotId = Integer.parseInt(id);
        Time startTime = Time.valueOf(currentStartTime);
        Time endTime = Time.valueOf(currentEndTime);

        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        EventDataEntity eventDataEntity = eventServiceInterface.getEventBySlotId(slotId, churchId);
        UserEntity currentConductor = userServiceInterface.getUserByUserId(eventDataEntity.getConductorId());
        List<UserEntity> userEntities = userServiceInterface.getListSuitableConductorForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId);
        List<Integer> conductorIdList = userServiceInterface.getIdListSuitableConductorForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId);
        if (!conductorIdList.contains(currentConductor.getUserId())) {
            userEntities.add(currentConductor);
        }
        return userEntities;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.LOAD_ROOM, method = RequestMethod.POST)
    public List<RoomEntity> loadEventRoom(@RequestParam(value = ParamConstant.SLOT_ID) String id,
                                          @RequestParam(value = ParamConstant.START_TIME) String currentStartTime,
                                          @RequestParam(value = ParamConstant.END_TIME) String currentEndTime,
                                          HttpServletRequest request) {
        int slotId = Integer.parseInt(id);
        Time startTime = Time.valueOf(currentStartTime);
        Time endTime = Time.valueOf(currentEndTime);

        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        EventDataEntity eventDataEntity = eventServiceInterface.getEventBySlotId(slotId, churchId);
        RoomEntity currentRoom = roomServiceInterface.getRoomById(eventDataEntity.getRoomId());
        List<RoomEntity> roomEntities = roomServiceInterface.getListSuitableRoomForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId);
        List<Integer> roomIdList = roomServiceInterface.getIdListSuitableRoomForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId);

        if (!roomIdList.contains(currentRoom.getRoomId())) {
            roomEntities.add(currentRoom);
        }
        return roomEntities;
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
            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), slotDate, subId
                    , privacy, churchId, examDate, typeEntity.getTypeId(), false, numberOfSlot);

            List<Date> datesOfClass = DateUtils.getListOfClassDate(eventJsonEntity.getType(), eventJsonEntity.getSlotDate(), numberOfSlot);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId, false);


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

                List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(eventEntity.getEventId());

                for (SlotEntity slotEntity : slotEntities) {
                    eventServiceInterface.mappingResource(slotEntity.getSlotId(), slotHour);
                }

                List<RegistrationEntity> registrationEntities = registrationServiceInterface.getWaitingRegistrationBySubId(subId);
                for (RegistrationEntity entity : registrationEntities) {
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


    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATED_SINGLE_EVENT, method = RequestMethod.POST)
    public void updateSingleEvent(@RequestBody EventJsonEntity eventJsonEntity) {
        //int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            ArrayList<Integer> slotHour = StringUtils.convertStringToListOfSlotHour(eventJsonEntity.getSlotHour());
            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            int conductorId = Integer.parseInt(eventJsonEntity.getConductorId());
            int roomId = Integer.parseInt(eventJsonEntity.getRoomId());
            int privacy = Integer.parseInt(eventJsonEntity.getPrivacy());

            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);
            slotEntity.setSlotDate(slotDate);
            slotEntity.setConductorId(conductorId);
            slotEntity.setRoomId(roomId);
            slotEntity.setSlotStatus(privacy);

            slotServiceInterface.updateSlot(slotEntity);

            slotServiceInterface.deleteSlotHourBySlotId(slotId);

            for (int i = 0; i < slotHour.size(); i++) {
                eventServiceInterface.mappingResource(slotId, slotHour.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATED_REPEAT_EVENT, method = RequestMethod.POST)
    public void updateRepeatEvent(@RequestBody EventJsonEntity eventJsonEntity) {
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            ArrayList<Integer> slotHour = StringUtils.convertStringToListOfSlotHour(eventJsonEntity.getSlotHour());
//            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            int conductorId = Integer.parseInt(eventJsonEntity.getConductorId());
            int roomId = Integer.parseInt(eventJsonEntity.getRoomId());
            int privacy = Integer.parseInt(eventJsonEntity.getPrivacy());

            List<SlotEntity> slotEntities = slotServiceInterface.getListSlotOfClass(slotId);

            for (SlotEntity slotEntity : slotEntities) {
                slotEntity.setConductorId(conductorId);
                slotEntity.setRoomId(roomId);
                slotEntity.setSlotStatus(privacy);
                slotServiceInterface.updateSlot(slotEntity);

                slotServiceInterface.deleteSlotHourBySlotId(slotEntity.getSlotId());

                for (int i = 0; i < slotHour.size(); i++) {
                    eventServiceInterface.mappingResource(slotEntity.getSlotId(), slotHour.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_IS_CLASS, method = RequestMethod.POST)
    public Integer checkIsClass(@RequestBody EventJsonEntity eventJsonEntity) {
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            int categoryId = eventServiceInterface.getCategoryIdFromSlotId(slotId);
            if (categoryId == UtilsConstant.CLASS_CATEGORY_ID) {
                return UtilsConstant.IS_CLASS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UtilsConstant.IS_NOT_CLASS;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.REGISTER_STREAM_URL, method = RequestMethod.POST)
    public void registerStreamEvent(@RequestParam(value = ParamConstant.SLOT_ID) String slotIdStr,
                                    @RequestParam(value = ParamConstant.STREAM_RESOLUTION) String resolution) {
        try {
            int slotId = Integer.parseInt(slotIdStr);
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);

            EventEntity eventEntity = eventServiceInterface.getEventById(slotEntity.getEventId());


            String streamLink = YoutubeAPI.createBroadcast(eventEntity.getEventName(),
                    new java.util.Date(slotEntity.getSlotDate().getTime())
                    , UtilsConstant.DEFAULT_VALIDATE_PORT);
            String streamCode = YoutubeAPI.createStream(streamLink, resolution, streamLink);
            slotEntity.setStreamLink(streamLink);
            slotEntity.setStreamCode(streamCode);
            slotServiceInterface.updateSlot(slotEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
