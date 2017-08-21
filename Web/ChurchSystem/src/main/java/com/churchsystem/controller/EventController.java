package com.churchsystem.controller;

import com.churchsystem.common.api.CalendarAPI;
import com.churchsystem.common.api.PlusAPI;
import com.churchsystem.common.api.YoutubeAPI;
import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.common.utils.StringUtils;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.*;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.model.LiveBroadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
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

    @Autowired
    ChurchServiceInterface churchServiceInterface;


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
            int conductorId = Integer.parseInt(eventJsonEntity.getConductorId());
            int roomId = Integer.parseInt(eventJsonEntity.getRoomId());
            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }

            Timestamp creatingTime = new Timestamp(System.currentTimeMillis());
            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), slotDate, subId
                    , privacy, churchId, null, ParamConstant.NON_REPEAT_TYPE, false, UtilsConstant.ONE, creatingTime);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(slotDate, ParamConstant.WAITING_FOR_APPROVE_STATUS,
                    subId, churchId, false, creatingTime);
            SlotEntity slotEntity = eventServiceInterface.createSlotForEvent(slotDate, slotHour, churchId, subId, eventEntity.getEventId(), conductorId, roomId);
            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(slotEntity.getEventId());
            for (int i = 0; i < slotEntities.size(); i++) {
                eventServiceInterface.mappingResource(slotEntities.get(i).getSlotId(), slotHour);
            }


            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
            eventServiceInterface.updateEvent(eventEntity);

            result = eventServiceInterface.getCreatedEvent(slotEntity.getEventId(), eventJsonEntity.getToken());
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
                .addObject(ParamConstant.SLOT_HOUR_LIST, slotServiceInterface.getListOfSlotHour())
                .addObject(ParamConstant.CHURCH_SETTING, churchServiceInterface.getSettingOfChurch(churchId));
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
        List<UserEntity> userEntities = userServiceInterface.getListSuitableConductorForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId, eventDataEntity.getSubId());
        List<Integer> conductorIdList = userServiceInterface.getIdListSuitableConductorForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId, eventDataEntity.getSubId());

        if (eventDataEntity.getConductorId() != null) {
            UserEntity currentConductor = userServiceInterface.getUserByUserId(eventDataEntity.getConductorId());
            if (!conductorIdList.contains(currentConductor.getUserId()) && eventDataEntity.getConductorId() != ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID) {
                userEntities.add(currentConductor);
            }
            if (userEntities.size() == UtilsConstant.ZERO) {
                userEntities.add(currentConductor);
            }
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
        List<RoomEntity> roomEntities = roomServiceInterface.getListSuitableRoomForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId, eventDataEntity.getSubId());
        List<Integer> roomIdList = roomServiceInterface.getIdListSuitableRoomForSlot(startTime, endTime, eventDataEntity.getSlotDate(), churchId, eventDataEntity.getSubId());
        if (eventDataEntity.getRoomId() != null) {
            RoomEntity currentRoom = roomServiceInterface.getRoomById(eventDataEntity.getRoomId());
            if (!roomIdList.contains(currentRoom.getRoomId()) && eventDataEntity.getRoomId() != ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID) {
                roomEntities.add(currentRoom);
            }
            if (roomEntities.size() == UtilsConstant.ZERO) {
                roomEntities.add(currentRoom);
            }
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
            Integer roomId = Integer.parseInt(eventJsonEntity.getRoomId());
            Integer conductorId = Integer.parseInt(eventJsonEntity.getConductorId());
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

            List<Date> datesOfClass = DateUtils.getListOfClassDate(eventJsonEntity.getType(), eventJsonEntity.getSlotDate(), numberOfSlot);
            datesOfClass.add(examDate);
            //Create Class
            Timestamp creatingTime = new Timestamp(System.currentTimeMillis());
            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), datesOfClass.get(0), subId
                    , privacy, churchId, examDate, typeEntity.getTypeId(), false, numberOfSlot, creatingTime);


            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(datesOfClass.get(0), ParamConstant.WAITING_FOR_APPROVE_STATUS, subId, churchId, false, creatingTime);

            for (int i = 0; i < datesOfClass.size(); i++) {
                Date itemDate = datesOfClass.get(i);
                eventServiceInterface.createSlotForClass(eventEntity.getEventId(), slotHour, churchId,
                        roomId, conductorId, itemDate, subId);
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

            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
            eventServiceInterface.updateEvent(eventEntity);
            result = eventServiceInterface.getCreatedEvent(eventEntity.getEventId(), eventJsonEntity.getToken());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_CONDUCTOR_FOR_CLASS, method = RequestMethod.POST)
    public int checkConductorForClass(@RequestBody EventJsonEntity eventJsonEntity,
                                      HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            Integer currentConductorId = slotServiceInterface.getSlotById(slotId).getConductorId();
            List<SlotEntity> slotEntities = slotServiceInterface.getListSlotOfClass(slotId);

            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            Time startTime = eventJsonEntity.getStartTime();
            Time endTime = eventJsonEntity.getEndTime();
            int newConductorId = Integer.parseInt(eventJsonEntity.getConductorId());

            for (int i = 0; i < slotEntities.size(); i++) {
                int result = eventServiceInterface.checkConductorForClass(slotEntities.get(i), startTime, endTime, newConductorId, churchId, subId, currentConductorId);
                if (result == UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS) {
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
            }
            return UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
        } catch (Exception e) {
            e.printStackTrace();
            return UtilsConstant.ERROR;
        }
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_ROOM_FOR_CLASS, method = RequestMethod.POST)
    public int checkRoomForClass(@RequestBody EventJsonEntity eventJsonEntity,
                                 HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            Integer currentRoomId = slotServiceInterface.getSlotById(slotId).getRoomId();
            List<SlotEntity> slotEntities = slotServiceInterface.getListSlotOfClass(slotId);

            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            Time startTime = eventJsonEntity.getStartTime();
            Time endTime = eventJsonEntity.getEndTime();
            int newRoomId = Integer.parseInt(eventJsonEntity.getRoomId());
            for (int i = 0; i < slotEntities.size(); i++) {
                int result = eventServiceInterface.checkRoomForClass(slotEntities.get(i), startTime, endTime, newRoomId, churchId, subId, currentRoomId);
                if (result == UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS) {
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
            }
            return UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
        } catch (Exception e) {
            e.printStackTrace();
            return UtilsConstant.ERROR;
        }
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATED_SINGLE_EVENT, method = RequestMethod.POST)
    public void updateSingleEvent(@RequestBody EventJsonEntity eventJsonEntity) {
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            ArrayList<Integer> slotHour = StringUtils.convertStringToListOfSlotHour(eventJsonEntity.getSlotHour());
            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);

            //Check null Conductor
            Integer conductorId;
            if (eventJsonEntity.getConductorId() != null) {
                conductorId = Integer.parseInt(eventJsonEntity.getConductorId());
            } else {
                conductorId = ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID;
            }

            //Check null Room
            Integer roomId;
            if (eventJsonEntity.getRoomId() != null) {
                roomId = Integer.parseInt(eventJsonEntity.getRoomId());
            } else {
                roomId = ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID;
            }

            //Check status
            Integer status;
            if (roomId != ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID && conductorId != ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID) {
                status = ParamConstant.SLOT_OK_STATUS;
            } else {
                status = ParamConstant.SLOT_CONFLICT_STATUS;
            }

            //Update slot information
            slotEntity.setRoomId(roomId);
            slotEntity.setConductorId(conductorId);
            slotEntity.setSlotDate(slotDate);
            slotEntity.setSlotStatus(status);
            slotServiceInterface.updateSlot(slotEntity);

            //Update event information
            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());
            String eventName = eventJsonEntity.getEventName();
            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }
            eventServiceInterface.updateEventNameAndPrivacy(slotEntity, eventName, privacy);

            eventServiceInterface.mappingResource(slotEntity.getSlotId(), slotHour);
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
            String eventName = eventJsonEntity.getEventName();
            int conductorId = Integer.parseInt(eventJsonEntity.getConductorId());
            int roomId = Integer.parseInt(eventJsonEntity.getRoomId());
            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());

            List<SlotEntity> slotEntities = slotServiceInterface.getListSlotOfClass(slotId);

            for (SlotEntity slotEntity : slotEntities) {
                slotEntity.setConductorId(conductorId);
                slotEntity.setRoomId(roomId);
                Integer status;
                if (roomId != ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID && conductorId != ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID) {
                    status = ParamConstant.SLOT_OK_STATUS;
                } else {
                    status = ParamConstant.SLOT_CONFLICT_STATUS;
                }
                slotEntity.setSlotStatus(status);
                slotServiceInterface.updateSlot(slotEntity);
                eventServiceInterface.mappingResource(slotEntity.getSlotId(), slotHour);
            }
            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }

            eventServiceInterface.updateEventNameAndPrivacy(slotEntities.get(UtilsConstant.ZERO), eventName, privacy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATE_DRAG_DROP_EVENT, method = RequestMethod.POST)
    public EventDataEntity updateDragDropEvent(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        try {
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);
            EventDataEntity eventDataEntity = eventServiceInterface.getEventBySlotId(slotId, churchId);

            Time startTime = eventJsonEntity.getStartTime();
            Time endTime = eventJsonEntity.getEndTime();
            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            List<SlothourEntity> slotHour = slotServiceInterface.getListSlotHourByTime(startTime, endTime);

            //get current room and conductor;
            if (slotEntity.getRoomId() == null) {
                slotEntity.setRoomId(ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID);
            }
            if (slotEntity.getConductorId() == null) {
                slotEntity.setConductorId(ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID);
            }

            int curRoomId = slotEntity.getRoomId();
            int curConductorId = slotEntity.getConductorId();

            slotServiceInterface.setValueForSlot(slotEntity, null, null);

            String roomName = roomServiceInterface.getRoomById(curRoomId).getRoomName();
            String conductorName = userServiceInterface.getUserByUserId(curConductorId).getUserName();

            List<Integer> listRoomId = roomServiceInterface.getIdListSuitableRoomForSlot(startTime, endTime, slotDate, churchId, eventDataEntity.getSubId());
            List<Integer> listConductorId = userServiceInterface.getIdListSuitableConductorForSlot(startTime, endTime, slotDate, churchId, eventDataEntity.getSubId());

            //case edited slot is OK
            if (slotEntity.getSlotStatus() == ParamConstant.SLOT_OK_STATUS) {
                if (!listRoomId.contains(curRoomId)) {
                    slotEntity.setRoomId(ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID);
                    slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                    eventDataEntity.setRoomName(roomServiceInterface.getRoomById(ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID).getRoomName());
                    eventDataEntity.setStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                } else {
                    slotEntity.setRoomId(curRoomId);
                }
                if (!listConductorId.contains(curConductorId)) {
                    slotEntity.setConductorId(ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID);
                    slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                    eventDataEntity.setConductorName(userServiceInterface.getUserByUserId(ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID).getUserName());
                    eventDataEntity.setStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                } else {
                    slotEntity.setConductorId(curConductorId);
                }
                slotEntity.setSlotDate(slotDate);
                slotServiceInterface.updateSlot(slotEntity);


                // map new slot hour
                slotServiceInterface.deleteSlotHourBySlotId(slotId);
                for (int i = 0; i < slotHour.size(); i++) {
                    eventServiceInterface.mappingResource(slotId, slotHour.get(i).getSlotHourId());
                }
            } else {
                if (listRoomId == null) {
                    slotEntity.setRoomId(ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID);
                    slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                    eventDataEntity.setRoomName(roomServiceInterface.getRoomById(ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID).getRoomName());
                    eventDataEntity.setStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                }
                if (listConductorId == null) {
                    slotEntity.setConductorId(ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID);
                    slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                    eventDataEntity.setConductorName(conductorName);
                    eventDataEntity.setStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                }
                if (listRoomId != null && listConductorId != null) {
                    slotEntity.setRoomId(listRoomId.get(UtilsConstant.ZERO));
                    slotEntity.setConductorId(listConductorId.get(UtilsConstant.ZERO));
                    slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
                    slotEntity.setSlotDate(slotDate);

                    eventDataEntity.setRoomName(roomServiceInterface.getRoomById(listRoomId.get(UtilsConstant.ZERO)).getRoomName());
                    eventDataEntity.setConductorName(userServiceInterface.getUserByUserId(listConductorId.get(UtilsConstant.ZERO)).getUserName());
                    eventDataEntity.setStatus(ParamConstant.SLOT_OK_STATUS);
                }

                slotServiceInterface.updateSlot(slotEntity);

                slotServiceInterface.deleteSlotHourBySlotId(slotId);

                for (int i = 0; i < slotHour.size(); i++) {
                    eventServiceInterface.mappingResource(slotId, slotHour.get(i).getSlotHourId());
                }
            }
            return eventDataEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_IS_MANY_SLOT, method = RequestMethod.POST)
    public Integer checkIsManySlot(@RequestBody EventJsonEntity eventJsonEntity) {
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            return eventServiceInterface.checkIsManySlot(slotId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UtilsConstant.ERROR;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.REMOVE_SINGLE_SLOT, method = RequestMethod.POST)
    public void removeSingleSlot(@RequestBody EventJsonEntity eventJsonEntity) {
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);
            int isManySlot = eventServiceInterface.checkIsManySlot(slotId);

            slotServiceInterface.deleteSlotHourBySlotId(slotId);
            slotServiceInterface.deleteSlot(slotId);

            if (isManySlot == UtilsConstant.IS_ONE_SLOT) {
                EventEntity eventEntity = eventServiceInterface.getEventById(slotEntity.getEventId());
                eventEntity.setEventStatus(ParamConstant.EVENT_DENY_STATUS);
                eventServiceInterface.updateEvent(eventEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.REMOVE_MULTI_SLOT, method = RequestMethod.POST)
    public void removeMultiSlot(@RequestBody EventJsonEntity eventJsonEntity) {
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());

            List<SlotEntity> slotEntities = slotServiceInterface.getListSlotOfClass(slotId);
            for (int i = 0; i < slotEntities.size(); i++) {
                slotServiceInterface.deleteSlotHourBySlotId(slotEntities.get(i).getSlotId());
                slotServiceInterface.deleteSlot(slotEntities.get(i).getSlotId());
            }

            EventEntity eventEntity = eventServiceInterface.getEventById(slotEntities.get(UtilsConstant.ZERO).getEventId());
            eventEntity.setEventStatus(ParamConstant.EVENT_DENY_STATUS);
            eventServiceInterface.updateEvent(eventEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            slotEntity.setIsStream(ParamConstant.NOT_STREAM);
            slotServiceInterface.updateSlot(slotEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.STREAM_EVENT, method = RequestMethod.POST)
    public void registerStreamEvent(@RequestParam(value = ParamConstant.SLOT_ID) String slotIdStr) {

        try {
            int slotId = Integer.parseInt(slotIdStr);
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);
            slotEntity.setIsStream(ParamConstant.IS_STREAMED);
            slotServiceInterface.updateSlot(slotEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.FINISH_EVENT, method = RequestMethod.POST)
    public void changeStatusToFinish(@RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr) {
        try {
            int churchId = Integer.parseInt(churchIdStr);
            eventServiceInterface.changeStatusToFinish(churchId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_EVENT_URL, method = RequestMethod.POST)
    public List<Integer> checkEventConstraint(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        List<Integer> result = new ArrayList<Integer>();
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            Date slotDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            int slotHour = Integer.parseInt(eventJsonEntity.getSlotHour());
            result = eventServiceInterface.checkEventSlot(slotDate, slotHour, churchId, subId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_CLASS_URL, method = RequestMethod.POST)
    public List<Integer> checkClass(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        List<Integer> result = new ArrayList<Integer>();
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            int slotHour = Integer.parseInt(eventJsonEntity.getSlotHour());
            int numberOfSlot = Integer.parseInt(eventJsonEntity.getNumOfSlot());

            List<Date> datesOfClass = DateUtils.getListOfClassDate(eventJsonEntity.getType(), eventJsonEntity.getSlotDate(), numberOfSlot);

            return result = eventServiceInterface.checkEventClass(datesOfClass, slotHour, churchId, subId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GOOGLE_VALIDATE_URL, method = RequestMethod.POST)
    public String tesCalendar(@RequestParam(value = "token") String token, HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
        try {
            String abc = PlusAPI.checkLoginAccount(token, churchEntity.getMail(), UtilsConstant.DEFAULT_VALIDATE_PORT);
            if (abc == null) {
                return UtilsConstant.GOOGLE_API_INVALID_EMAIL;
            } else {
                return abc;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATE_NAME_AND_PRIVACY, method = RequestMethod.POST)
    public void updateNameAndPrivacy(@RequestBody EventJsonEntity eventJsonEntity) {
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);

            String eventName = eventJsonEntity.getEventName();
            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());

            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }
            eventServiceInterface.updateEventNameAndPrivacy(slotEntity, eventName, privacy);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATED_ERROR_REPEAT_EVENT, method = RequestMethod.POST)
    public void updateErrorRepeatEvent(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            ArrayList<Integer> slotHour = StringUtils.convertStringToListOfSlotHour(eventJsonEntity.getSlotHour());
            String eventName = eventJsonEntity.getEventName();
            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());

            Integer currentRoomId = slotServiceInterface.getSlotById(slotId).getRoomId();
            Integer currentConductorId = slotServiceInterface.getSlotById(slotId).getRoomId();
            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            Time startTime = eventJsonEntity.getStartTime();
            Time endTime = eventJsonEntity.getEndTime();
            int newConductorId = Integer.parseInt(eventJsonEntity.getConductorId());
            int newRoomId = Integer.parseInt(eventJsonEntity.getRoomId());


            List<SlotEntity> slotEntities = slotServiceInterface.getListSlotOfClass(slotId);

            for (int i = 0; i < slotEntities.size(); i++) {
                int isRoomAvailable = eventServiceInterface.checkRoomForClass(slotEntities.get(i), startTime, endTime, newRoomId, churchId, subId, currentRoomId);
                int isConductorAvailable = eventServiceInterface.checkConductorForClass(slotEntities.get(i), startTime, endTime, newConductorId, churchId, subId, currentConductorId);

                if (isRoomAvailable == UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS) {
                    slotEntities.get(i).setRoomId(ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID);
                    slotEntities.get(i).setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                }

                if (isConductorAvailable == UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS) {
                    slotEntities.get(i).setConductorId(ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID);
                    slotEntities.get(i).setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
                } else if (isRoomAvailable == UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS && isConductorAvailable == UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS) {
                    slotEntities.get(i).setRoomId(newRoomId);
                    slotEntities.get(i).setConductorId(newConductorId);
                    slotEntities.get(i).setSlotStatus(ParamConstant.SLOT_OK_STATUS);
                }

                eventServiceInterface.mappingResource(slotEntities.get(i).getSlotId(), slotHour);
            }

            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }
            eventServiceInterface.updateEventNameAndPrivacy(slotEntities.get(UtilsConstant.ZERO), eventName, privacy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_CONFLICT_FOR_DRAG_DROP_EVENT, method = RequestMethod.POST)
    public int checkConductorForDragDropEvent(@RequestBody EventJsonEntity eventJsonEntity,
                                              HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);

            Integer currentConductorId = slotEntity.getConductorId();
            Integer currentRoomId = slotEntity.getRoomId();

            slotServiceInterface.setValueForSlot(slotEntity, null, null);

            int subId = eventServiceInterface.getEventById(slotEntity.getEventId()).getSubId();
            Time newStartTime = eventJsonEntity.getStartTime();
            Time newEndTime = eventJsonEntity.getEndTime();
            Date newDate = DateUtils.getDate(eventJsonEntity.getSlotDate());


            List<Integer> listConductorId = userServiceInterface.getIdListSuitableConductorForSlot(newStartTime, newEndTime, newDate, churchId, subId);
            List<Integer> listRoomID = roomServiceInterface.getIdListSuitableRoomForSlot(newStartTime, newEndTime, newDate, churchId, subId);

            if (slotEntity.getSlotStatus() == ParamConstant.SLOT_OK_STATUS) {
                if (!listConductorId.contains(currentConductorId)) {
                    slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
                if (!listRoomID.contains(currentRoomId)) {
                    slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
            } else {
                int roomCheck = UtilsConstant.ZERO;
                int conductorCheck = UtilsConstant.ZERO;
                if (currentConductorId == null) {
                    if (listConductorId == null) {
                        slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                        return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                    } else {
                        conductorCheck = UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                    }
                }
                if (currentRoomId == null) {
                    if (listRoomID == null) {
                        slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                        return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                    } else {
                        roomCheck = UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                    }
                }
                if (conductorCheck == UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS && roomCheck == UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS) {
                    slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                    return UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
            }
            slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
            return UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
        } catch (Exception e) {
            e.printStackTrace();
            return UtilsConstant.ERROR;
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_CONFLICT_FOR_RESIZE_EVENT, method = RequestMethod.POST)
    public int checkConductorForResizeEvent(@RequestBody EventJsonEntity eventJsonEntity,
                                            HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int slotId = Integer.parseInt(eventJsonEntity.getSlotId());
            SlotEntity slotEntity = slotServiceInterface.getSlotById(slotId);

            Integer currentConductorId = slotEntity.getConductorId();
            Integer currentRoomId = slotEntity.getRoomId();

            //delete current conductor and room
            slotServiceInterface.setValueForSlot(slotEntity, null, null);

            Date curDate = DateUtils.getDate(eventJsonEntity.getSlotDate());
            int subId = eventServiceInterface.getEventById(slotEntity.getEventId()).getSubId();

            Time newStartTime = eventJsonEntity.getStartTime();
            Time newEndTime = eventJsonEntity.getEndTime();

            List<Integer> listConductorId = userServiceInterface.getIdListSuitableConductorForSlot(newStartTime, newEndTime, curDate, churchId, subId);
            List<Integer> listRoomID = roomServiceInterface.getIdListSuitableRoomForSlot(newStartTime, newEndTime, curDate, churchId, subId);

            if (slotEntity.getSlotStatus() == ParamConstant.SLOT_OK_STATUS) {
                if (!listConductorId.contains(currentConductorId)) {
                    slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
                if (!listRoomID.contains(currentRoomId)) {
                    slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
            } else {
                if (listConductorId == null) {
                    slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
                if (listRoomID == null) {
                    slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
                    return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
                }
            }
            slotServiceInterface.setValueForSlot(slotEntity, currentConductorId, currentRoomId);
            return UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
        } catch (Exception e) {
            e.printStackTrace();
            return UtilsConstant.ERROR;
        }
    }

    @RequestMapping(value = PageConstant.ADVANCE_CREATE_URL, method = RequestMethod.GET)
    public ModelAndView loadAdvanceCreate(@RequestParam(value = ParamConstant.DATE) String date) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.ADVANCE_CREATE_PAGE);
        modelAndView.addObject(ParamConstant.SLOT_HOUR_LIST, slotServiceInterface.getListOfSlotHour())
                .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getEventCategoryList())
                .addObject(ParamConstant.SUBJECT_LIST, subjectServiceInterface.getDisplayedSubject())
                .addObject(ParamConstant.SLOT_HOUR_LIST, slotServiceInterface.getListOfSlotHour())
                .addObject(ParamConstant.SLOT_DATE, date);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ADVANCE_CREATE_EVENT_URL, method = RequestMethod.POST)
    public List<EventDisplayEntity> createAdvanceEvent(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        List<EventDisplayEntity> result = null;
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            String eventName = eventJsonEntity.getEventName();
            int numOfSlot = Integer.parseInt(eventJsonEntity.getNumOfSlot());
            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            int intPrivacy = Integer.parseInt(eventJsonEntity.getPrivacy());
            boolean privacy = true;
            if (intPrivacy == UtilsConstant.ZERO) {
                privacy = false;
            }

            ArrayList<Integer> slotHour = StringUtils.convertStringToListOfSlotHour(eventJsonEntity.getSlotHour());
            Integer loopType = Integer.parseInt(eventJsonEntity.getSelectedType());
            Integer kind = Integer.parseInt(eventJsonEntity.getKind());
            String des = eventJsonEntity.getType();

            TypeEntity typeEntity = slotServiceInterface.getTypeByLoopTypeAndKind(loopType, kind, des);
            if (typeEntity == null) {
                typeEntity = new TypeEntity();
                typeEntity.setLoopType(loopType);
                typeEntity.setKind(kind);
                typeEntity.setDescription(des);
                slotServiceInterface.addNewType(typeEntity);
                typeEntity = slotServiceInterface.getTypeByLoopTypeAndKind(loopType, kind, des);
            }

            List<Date> datesOfClass = DateUtils.getListOfAdvanceEventDate(typeEntity, eventJsonEntity.getSlotDate(), numOfSlot);
            //Create Class
            Timestamp creatingTime = new Timestamp(System.currentTimeMillis());
            eventServiceInterface.createEvent(eventName, datesOfClass.get(0), subId
                    , privacy, churchId, null, typeEntity.getTypeId(), false, numOfSlot, creatingTime);

            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(datesOfClass.get(0), ParamConstant.WAITING_FOR_APPROVE_STATUS, subId, churchId, false, creatingTime);
            for (int i = 0; i < datesOfClass.size(); i++) {
                Date itemDate = datesOfClass.get(i);
                SlotEntity slotEntity = eventServiceInterface.createSlotForAdvanceEvent(eventEntity.getEventId(), slotHour,
                        itemDate, 0, 0);
                eventServiceInterface.mappingResource(slotEntity.getSlotId(), slotHour);
            }

            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
            eventServiceInterface.updateEvent(eventEntity);
            result = eventServiceInterface.getCreatedEvent(eventEntity.getEventId(), eventJsonEntity.getToken());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_ADVANCE_URL, method = RequestMethod.POST)
    public int checkAdvance(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
        List<Integer> result = new ArrayList<Integer>();
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            int subId = Integer.parseInt(eventJsonEntity.getSubId());
            int type=Integer.parseInt(eventJsonEntity.getType());
            int kind=Integer.parseInt(eventJsonEntity.getKind());
            String typeString=eventJsonEntity.getTypeString();
            int numberOfSlot = Integer.parseInt(eventJsonEntity.getNumOfSlot());
            TypeEntity typeEntity=new TypeEntity();
            typeEntity.setLoopType(type);
            typeEntity.setKind(kind);
            typeEntity.setDescription(typeString);
            List<Date> listOfAdvanceEventDate = DateUtils.getListOfAdvanceEventDate(typeEntity, eventJsonEntity.getSlotDate(), numberOfSlot);

            return eventServiceInterface.checkAdvanceCreate(listOfAdvanceEventDate,eventJsonEntity.getStartTime(),eventJsonEntity.getEndTime(),churchId,subId);
        } catch (Exception e) {
            e.printStackTrace();
            return UtilsConstant.NOT_STATUS;
        }
    }

//    @ResponseBody
//    @RequestMapping(value = PageConstant.CREATE_ADVANCE_URL, method = RequestMethod.POST)
//    public List<EventDisplayEntity> createAdvance(@RequestBody EventJsonEntity eventJsonEntity, HttpServletRequest request) {
//        List<EventDisplayEntity> result = null;
//        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
//        try {
//            int subId = Integer.parseInt(eventJsonEntity.getSubId());
//            int type=Integer.parseInt(eventJsonEntity.getType());
//            int kind=Integer.parseInt(eventJsonEntity.getKind());
//            String typeString=eventJsonEntity.getTypeString();
//            int numberOfSlot = Integer.parseInt(eventJsonEntity.getNumOfSlot());
//            int intPrivacy=Integer.parseInt(eventJsonEntity.getPrivacy());
//            boolean privacy = true;
//            if (intPrivacy == UtilsConstant.ZERO) {
//                privacy = false;
//            }
//
//            TypeEntity typeEntity=new TypeEntity();
//            typeEntity.setLoopType(type);
//            typeEntity.setKind(kind);
//            typeEntity.setDescription(typeString);
//            List<Date> listOfAdvanceEventDate = DateUtils.getListOfAdvanceEventDate(typeEntity, eventJsonEntity.getSlotDate(), numberOfSlot);
//
//            Timestamp creatingTime = new Timestamp(System.currentTimeMillis());
//            eventServiceInterface.createEvent(eventJsonEntity.getEventName(), listOfAdvanceEventDate.get(0), subId
//                    , privacy, churchId, null, typeEntity.getTypeId(), false, numberOfSlot, creatingTime);
//
//
//            EventEntity eventEntity = eventServiceInterface.getCreatingEvent(listOfAdvanceEventDate.get(0), ParamConstant.WAITING_FOR_APPROVE_STATUS, subId, churchId, false, creatingTime);
//
//            for (int i = 0; i < listOfAdvanceEventDate.size(); i++) {
//                Date itemDate = listOfAdvanceEventDate.get(i);
//                eventServiceInterface.createSlotForTimeRageEvent(eventEntity.getEventId(), eventJsonEntity.getStartTime(), eventJsonEntity.getEndTime(),
//                        churchId,itemDate, subId);
//            }
//
//            List<SlotEntity> slotEntities = slotServiceInterface.getSlotByEventId(eventEntity.getEventId());
//
//            for (SlotEntity slotEntity : slotEntities) {
////                eventServiceInterface.mappingResource(slotEntity.getSlotId(), slotHour);
//            }
//
//            List<RegistrationEntity> registrationEntities = registrationServiceInterface.getWaitingRegistrationBySubId(subId);
//            for (RegistrationEntity entity : registrationEntities) {
//                entity.setEventId(eventEntity.getEventId());
//                entity.setRegisStatus(ParamConstant.REGISTRATION_FINISH_STATUS);
//                registrationServiceInterface.updateRegistration(entity);
//            }
//
//            eventEntity.setEventStatus(ParamConstant.EVENT_APPROVE_STATUS);
//            eventServiceInterface.updateEvent(eventEntity);
//            result = eventServiceInterface.getCreatedEvent(eventEntity.getEventId(), eventJsonEntity.getToken());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}
