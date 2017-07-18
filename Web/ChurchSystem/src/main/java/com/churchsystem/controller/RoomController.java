package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.RoomEntity;
import com.churchsystem.entity.ManagementJsonEntity;
import com.churchsystem.service.interfaces.CategoryServiceInterface;
import com.churchsystem.service.interfaces.RoomServiceInterface;
import com.churchsystem.service.interfaces.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/6/2017.
 */
@Controller
public class RoomController {
    @Autowired
    RoomServiceInterface roomServiceInterface;
    @Autowired
    CategoryServiceInterface categoryServiceInterface;
    @Autowired
    SubjectServiceInterface subjectServiceInterface;

    @RequestMapping(value = PageConstant.ROOM_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.ROOM_MANAGEMENT_PAGE);
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        List<RoomEntity> roomEntities = roomServiceInterface.getAllRoom(churchId);
        modelAndView.addObject(ParamConstant.ROOM_LIST, roomEntities).addObject(ParamConstant.SUBJECT_LIST, subjectServiceInterface.getDisplayedSubject())
                .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getEventCategoryList());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_NEW_ROOM_URL, method = RequestMethod.POST)
    public int addNewRoom(HttpServletRequest request, @RequestBody ManagementJsonEntity managementJsonEntity) {
        try {
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            String roomName = managementJsonEntity.getRoomName();
            Integer[] selectedSubject = managementJsonEntity.getSelectedSubjectList();

            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setChurchId(churchId);
            roomEntity.setRoomName(roomName);
            roomEntity.setRoomStatus(ParamConstant.NO_SUBJECT_STATUS);

            //insert new room
            roomServiceInterface.insertRoom(roomEntity);

            //get inserted room
            RoomEntity newRoom = roomServiceInterface.getRoomByNameAndChurchId(roomName, churchId,ParamConstant.NO_SUBJECT_STATUS);

            //map inserted room with subjects
            for (int i = 0; i < selectedSubject.length; i++) {
                roomServiceInterface.mapRoomWithSubject(newRoom.getRoomId(), selectedSubject[i]);
            }

            newRoom.setRoomStatus(ParamConstant.ENABLE_STATUS);
            roomServiceInterface.updateRoom(newRoom);
            return ParamConstant.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ParamConstant.FAILURE;
    }
}

