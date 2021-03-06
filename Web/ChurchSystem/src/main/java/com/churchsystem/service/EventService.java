package com.churchsystem.service;

import com.churchsystem.common.api.CalendarAPI;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.common.utils.StringUtils;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.*;
import com.churchsystem.service.interfaces.EventServiceInterface;
import com.google.api.client.util.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.tags.Param;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by hungmcse61561-admin on 6/18/2017.
 */
@Service
@Transactional
public class EventService implements EventServiceInterface {
    @Autowired
    EventModelInterface eventModelInterface;

    @Autowired
    RoomModelInterface roomModelInterface;

    @Autowired
    UserModelInterface userModelInterface;

    @Autowired
    SlotModelInterface slotModelInterface;

    @Autowired
    SubjectModelInterface subjectModelInterface;


    @Override
    public List<EventDisplayEntity> getListOfEvent(int churchId) {

        List<EventDataEntity> data = eventModelInterface.getListOfEvent(churchId);
        List<EventDisplayEntity> result = convertEventData(data);
        return result;
    }

    @Override
    public List<EventDataEntity> getListOfEventData(int churchId) {
        List<EventDataEntity> data = eventModelInterface.getListOfPublicEvent(churchId);
        return data;
    }


    @Override
    public List<EventDisplayEntity> getListOfPublicEvent(int churchId) {
        List<EventDataEntity> data = eventModelInterface.getListOfPublicEvent(churchId);
        List<EventDisplayEntity> result = convertEventData(data);
        return result;
    }

    public List<EventDisplayEntity> convertEventData(List<EventDataEntity> data) {
        List<EventDisplayEntity> listEvent = new ArrayList<EventDisplayEntity>();
        for (int i = 0; i < data.size(); i++) {
            EventDataEntity eventDataEntity = data.get(i);
            EventDisplayEntity item = new EventDisplayEntity(eventDataEntity);
            listEvent.add(item);
        }
        return listEvent;
    }

    @Override
    public List<EventDisplayEntity> getCreatedEvent(int eventId, String token) throws IOException {
        List<EventDataEntity> eventDataEntities = eventModelInterface.getCreatedEvent(eventId);
        List<EventDisplayEntity> result = new ArrayList<EventDisplayEntity>();
        for (int i = 0; i < eventDataEntities.size(); i++) {
            EventDisplayEntity item = new EventDisplayEntity(eventDataEntities.get(i));
            result.add(item);

            if (token != "" && token != null) {
                Timestamp dateStart = new Timestamp(eventDataEntities.get(i).getStartTime().getTime() + eventDataEntities.get(i).getSlotDate().getTime() +
                        UtilsConstant.GMT_PLUSING);
                DateTime startDate = new DateTime(dateStart);
                Timestamp dateEnd = new Timestamp(eventDataEntities.get(i).getEndTime().getTime() +
                        eventDataEntities.get(i).getSlotDate().getTime() + UtilsConstant.GMT_PLUSING);
                DateTime endDate = new DateTime(dateEnd);
                CalendarAPI.createGoogleEvent(eventDataEntities.get(i).getSlotId(), eventDataEntities.get(i).getEventName() + " - " + eventDataEntities.get(i).getSubName(), eventDataEntities.get(i).getRoomName(), eventDataEntities.get(i).getConductorName(), startDate, endDate, null, UtilsConstant.SHARE_CALENDAR_GOOGLE_ACCOUNT, token);
            }
        }
        return result;
    }


    @Override
    public void createEvent(String eventName, Date eventDate, int subId, boolean privacy, int churchId
            , Date examDate, Integer typeId, boolean isRegistered, int numberOfSlot, Timestamp createdTime) {
        EventEntity inputEvent = new EventEntity();
        inputEvent.setChurchId(churchId);
        inputEvent.setEventStatus(ParamConstant.WAITING_FOR_APPROVE_STATUS);
        inputEvent.setStartDate(eventDate);
        if (eventName.equals("")) {
            eventName = ParamConstant.NO_NAME_EVENT_TITLE;
        }
        String creatingTime = new SimpleDateFormat(UtilsConstant.TIME_STAMP_DEFAULT_PATTERN).format(createdTime);
        createdTime = Timestamp.valueOf(creatingTime);
        inputEvent.setEventName(eventName);
        inputEvent.setSubId(subId);
        inputEvent.setPrivacy(privacy);
        inputEvent.setTypeId(typeId);
        inputEvent.setExamDate(examDate);
        inputEvent.setRegistered(isRegistered);
        inputEvent.setNumOfSlot(numberOfSlot);
        inputEvent.setCreatedTime(createdTime);
        eventModelInterface.addNewEvent(inputEvent);
    }

    @Override
    public SlotEntity createSlotForEvent(Date eventDate, int slotHour, int churchId, int subId, int eventId, int conductorId,
                                         int roomId) {
        SlotEntity slotEntity = new SlotEntity();

        if (conductorId == ParamConstant.NO_CONDUCTOR_AVAILABLE || roomId == ParamConstant.NO_ROOM_AVAILABLE) {
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
        } else {
            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
        }

        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setEventId(eventId);
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(eventDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }

    @Override
    public List<Integer> checkEventSlot(Date eventDate, int slotHour, int churchId, int subId) {

        List<Integer> result = new ArrayList<Integer>();
        result.add(ParamConstant.NO_CONDUCTOR_AVAILABLE);
        result.add(ParamConstant.NO_ROOM_AVAILABLE);
        Integer conductorId = userModelInterface.getSuitableConductorForSlot(slotHour, eventDate, churchId, subId);
        Integer roomId = roomModelInterface.getSuitableRoomForSlot(slotHour, eventDate, churchId, subId);
        if (conductorId != null) {
            result.add(ParamConstant.EVENT_CONDUCTOR_POSITION, conductorId);
        }
        if (roomId != null) {
            result.add(ParamConstant.EVENT_ROOM_POSITION, roomId);
        }
        return result;
    }


    @Override
    public EventEntity getEventById(int eventId) {
        return eventModelInterface.getEventById(eventId);
    }

    @Override
    public SlotEntity createSlotForClass(int eventId, int slotHour, int churchId, Integer roomId, Integer conductorId, Date itemDate, int subId) {
        //Need to fix
        SlotEntity slotEntity = new SlotEntity();

        if (conductorId == ParamConstant.NO_CONDUCTOR_AVAILABLE || roomId == ParamConstant.NO_ROOM_AVAILABLE) {
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
        } else {
            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
        }
        slotEntity.setEventId(eventId);
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(itemDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }

    @Override
    public SlotEntity createSlotForAdvanceEvent(int eventId, Time startTime, Time endTime, Date itemDate, int churchId, int subId) {
        SlotEntity slotEntity = new SlotEntity();

        List<Integer> roomList = roomModelInterface.getIdListSuitableRoomForSlot(startTime, endTime, itemDate, churchId, subId);
        List<Integer> conductorList = userModelInterface.getIdListSuitableConductorForSlot(startTime, endTime, itemDate, churchId, subId);

        slotEntity.setEventId(eventId);
        slotEntity.setSlotDate(itemDate);

        if (roomList.size() > 0 && conductorList.size() > 0) {
            slotEntity.setConductorId(conductorList.get(UtilsConstant.ZERO));
            slotEntity.setRoomId(roomList.get(UtilsConstant.ZERO));
            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
        }
        if (roomList.size() == 0) {
            slotEntity.setRoomId(ParamConstant.DEFAULT_NOT_AVAILABLE_ROOM_ID);
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
            if (conductorList.size() > 0) {
                slotEntity.setConductorId(conductorList.get(UtilsConstant.ZERO));
            }
        }
        if (conductorList.size() == 0) {
            slotEntity.setConductorId(ParamConstant.DEFAULT_NOT_AVAILABLE_CONDUCTOR_ID);
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
            if (roomList.size() > 0) {
                slotEntity.setRoomId(roomList.get(UtilsConstant.ZERO));
            }
        }

//        if (conductorId == ParamConstant.NO_CONDUCTOR_AVAILABLE || roomId == ParamConstant.NO_ROOM_AVAILABLE) {
//            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
//        } else {
//            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
//        }

//        slotEntity.setConductorId(conductorId);
//        slotEntity.setRoomId(roomId);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }

    @Override
    public List<Integer> checkEventClass(List<Date> eventDate, int slotHour, int churchId, int subId) {
        //Need to fix
        List<Integer> result = new ArrayList<Integer>();
        result.add(ParamConstant.NO_CONDUCTOR_AVAILABLE);
        result.add(ParamConstant.NO_ROOM_AVAILABLE);
        List<Integer> conductorId = userModelInterface.getListSuitableConductorForSlotHour(slotHour, eventDate.get(0), churchId, subId);
        List<Integer> roomId = roomModelInterface.getListSuitableRoomForSlotHour(slotHour, eventDate.get(0), churchId, subId);

        List<Integer> validConductor = conductorId;
        List<Integer> validRoom = roomId;
        if (conductorId != null) {
            for (Date item : eventDate) {
                List<Integer> conductorItem = userModelInterface.getListSuitableConductorForSlotHour(slotHour, item, churchId, subId);
                List<Integer> tempConductor = new ArrayList<Integer>();
                for (int i = 0; i < conductorItem.size(); i++) {
                    if (validConductor.contains(conductorItem.get(i))) {
                        tempConductor.add(conductorItem.get(i));
                    }
                }
                validConductor = tempConductor;
            }
            if (validConductor.size() != 0) {
                result.add(ParamConstant.EVENT_CONDUCTOR_POSITION, validConductor.get(0));
            }

        }

        if (roomId != null) {
            for (Date item : eventDate) {
                List<Integer> roomItem = roomModelInterface.getListSuitableRoomForSlotHour(slotHour, item, churchId, subId);
                List<Integer> tempRoom = new ArrayList<Integer>();
                for (int i = 0; i < roomItem.size(); i++) {
                    if (validRoom.contains(roomItem.get(i))) {
                        tempRoom.add(roomItem.get(i));
                    }
                }
                validRoom = tempRoom;
            }
            if (validRoom.size() != 0) {
                result.add(ParamConstant.EVENT_ROOM_POSITION, validRoom.get(0));
            }

        }
        return result;
    }

    @Override
    public void mappingResource(int slotId, int slotHour) {
        InclusionEntity inclusionEntity = new InclusionEntity();
        inclusionEntity.setSlotHourId(slotHour);
        inclusionEntity.setSlotId(slotId);
        slotModelInterface.mappingSlotHour(inclusionEntity);

    }

    @Override
    public SlotEntity createSlotForUserEvent(int eventId, Time startTime, Time endTime, int churchId, Date itemDate, int subId) {
        Integer conductorId = null;
        Integer roomId = null;

        List<Integer> listConductorId = userModelInterface.getIdListSuitableConductorForSlot(startTime, endTime, itemDate, churchId, subId);
        List<Integer> listRoomId = roomModelInterface.getIdListSuitableRoomForSlot(startTime, endTime, itemDate, churchId, subId);
        if (listConductorId.size() > 0) {
            conductorId = listConductorId.get(UtilsConstant.ZERO);
        }

        if (listRoomId.size() > 0) {
            roomId = listRoomId.get(UtilsConstant.ZERO);
        }
        SlotEntity slotEntity = new SlotEntity();

        if (conductorId == null || roomId == null) {
            slotEntity.setSlotStatus(ParamConstant.SLOT_CONFLICT_STATUS);
        } else {
            slotEntity.setSlotStatus(ParamConstant.SLOT_OK_STATUS);
        }

        slotEntity.setEventId(eventId);
        slotEntity.setConductorId(conductorId);
        slotEntity.setRoomId(roomId);
        slotEntity.setSlotDate(itemDate);
        slotModelInterface.addNewSlot(slotEntity);
        return slotEntity;
    }


    @Override
    public EventEntity getCreatingEvent(Date date, int status, int subId, int churchId, boolean isRegistered, Timestamp time) {
        return eventModelInterface.getCreatingEvent(date, status, subId, churchId, isRegistered, time);
    }

    @Override
    public void updateEvent(EventEntity eventEntity) {
        eventModelInterface.updateEvent(eventEntity);
    }

    @Override
    public EventDataEntity getEventBySlotId(int slotId, int churchId) {
        return eventModelInterface.getEventBySlotId(slotId, churchId);
    }

    @Override
    public Integer getCategoryIdFromSlotId(int slotId) {
        return eventModelInterface.getCategoryIdFromSlotId(slotId);
    }

    @Override
    public void deleteEvent(int eventId) {
        eventModelInterface.deleteEvent(eventId);
    }

    @Override
    public Integer checkIsManySlot(int slotId) {
        try {
            List<SlotEntity> slotEntities = slotModelInterface.getListSlotOfClass(slotId);
            if (slotEntities.size() == UtilsConstant.ONE) {
                return UtilsConstant.IS_ONE_SLOT;
            } else if (slotEntities.size() > UtilsConstant.ONE) {
                return UtilsConstant.IS_MANY_SLOT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UtilsConstant.ERROR;
    }

    @Override
    public void changeStatusToFinish(int churchId) {
        Date curDate = DateUtils.getCurrentDate();
        List<EventEntity> eventEntities = eventModelInterface.getListEventOfChurch(churchId);
        for (int i = 0; i < eventEntities.size(); i++) {
            List<SlotEntity> slotEntities = slotModelInterface.getSlotByEventId(eventEntities.get(i).getEventId());
            for (int j = 0; j < slotEntities.size(); j++) {
                if (slotEntities.get(j).getSlotDate().before(curDate)) {
                    slotEntities.get(j).setSlotStatus(ParamConstant.SLOT_FINISH_STATUS);
                    slotModelInterface.updateSlot(slotEntities.get(j));
                }
            }
            if (slotEntities.get(slotEntities.size() - 1).getSlotStatus() == ParamConstant.SLOT_FINISH_STATUS) {
                changeEventStatus(eventEntities.get(i), ParamConstant.EVENT_FINISH_STATUS);
            }
        }
    }

    @Override
    public void changeEventStatus(EventEntity eventEntity, int status) {
        eventEntity.setEventStatus(status);
        eventModelInterface.updateEvent(eventEntity);
    }

    @Override
    public void updateEventNameAndPrivacy(SlotEntity slotEntity, String eventName, boolean privacy) {
        EventEntity eventEntity = eventModelInterface.getEventById(slotEntity.getEventId());
        eventEntity.setEventName(eventName);
        eventEntity.setPrivacy(privacy);
        eventModelInterface.updateEvent(eventEntity);
    }

    @Override
    public String updateGoogleCalendarEvent(SlotEntity slotEntity, Time startTime, Time endTime, String eventName) throws IOException {
//        //Calendar update
//        Timestamp dateStart = new Timestamp(startTime.getTime() + slotEntity.getSlotDate().getTime() +
//                UtilsConstant.GMT_PLUSING);
//        DateTime startDate = new DateTime(dateStart);
//        Timestamp dateEnd = new Timestamp(endTime.getTime() + slotEntity.getSlotDate().getTime() +
//                UtilsConstant.GMT_PLUSING);
//        DateTime endDate = new DateTime(dateEnd);
//        String roomName = null;
//        String conductorName = null;
//        if (slotEntity.getRoomId() != null) {
//            roomName = roomModelInterface.getRoomById(slotEntity.getRoomId()).getRoomName();
//        }
//
//        if (slotEntity.getConductorId() != null) {
//            conductorName = userModelInterface.getUserByUserId(slotEntity.getConductorId()).getUserName();
//        }
//
//        String result = CalendarAPI.updateGoogleEvent(slotEntity.getSlotId(), eventName, roomName, conductorName, startDate, endDate, UtilsConstant.DEFAULT_VALIDATE_PORT);


        return null;
    }


    @Override
    public int checkConductorForClass(SlotEntity slotEntity, Time startTime, Time endTime, int newConductorId, int churchId, int subId, Integer currentConductorId) {
        List<Integer> listConductorId = userModelInterface.getIdListSuitableConductorForSlot(startTime, endTime, slotEntity.getSlotDate(), churchId, subId);
        listConductorId.add(currentConductorId);
        if (!listConductorId.contains(newConductorId)) {
            return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
        }
        return UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
    }

    @Override
    public int checkRoomForClass(SlotEntity slotEntity, Time startTime, Time endTime, int newRoomId, int churchId, int subId, Integer currentRoomId) {
        List<Integer> listRoomId = roomModelInterface.getIdListSuitableRoomForSlot(startTime, endTime, slotEntity.getSlotDate(), churchId, subId);
        listRoomId.add(currentRoomId);
        if (!listRoomId.contains(newRoomId)) {
            return UtilsConstant.NOT_AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
        }
        return UtilsConstant.AVAILABLE_FOR_ALL_SLOT_OF_CLASS;
    }

    @Override
    public List<DashboardClassEntity> getUserRegisteredClass(int userId) {
        return eventModelInterface.getUserRegisteredClass(userId);
    }

    @Override
    public int checkAdvanceCreate(List<Date> eventDate, Time startTime, Time endTime, int churchId, int subId) {
        //Need to fix
        List<Integer> result = new ArrayList<Integer>();
        result.add(ParamConstant.NO_CONDUCTOR_AVAILABLE);
        result.add(ParamConstant.NO_ROOM_AVAILABLE);
        for (Date date : eventDate) {
            List<Integer> roomList = roomModelInterface.getIdListSuitableRoomForSlot(startTime, endTime, date, churchId, subId);
            if (roomList.size() == 0) {
                return UtilsConstant.NOT_STATUS;
            }
            List<Integer> conductorList = userModelInterface.getIdListSuitableConductorForSlot(startTime, endTime, date, churchId, subId);
            if (conductorList.size() == 0) {
                return UtilsConstant.NOT_STATUS;
            }
        }
        return UtilsConstant.OK_STATUS;
    }

}
