package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.EventDisplayEntity;
import com.churchsystem.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Controller
public class EventController {
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

    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_EVENT_URL, method = RequestMethod.POST)
    public EventDisplayEntity loadEventRegister(@RequestBody EventDisplayEntity eventDisplayEntity) {
//        EventDisplayEntity eventDisplayEntity=new EventDisplayEntity();
    try{
//        JSONObject jsonObject=new JSONObject(strEvent);
//        EventEntity eventEntity=new EventEntity();
//        SlotEntity slotEntity=new SlotEntity();

//        eventDisplayEntity=new EventDisplayEntity(1,"HungMC-Event","1","1","2017-06-13T06:00","1","03:00");

    }catch(Exception e){
        e.printStackTrace();
    }
        return eventDisplayEntity;
    }

    @RequestMapping(value = PageConstant.SCHEDULE_URL, method = RequestMethod.GET)
    public ModelAndView loadSchedule(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.SCHEDULE_PAGE);
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);

        modelAndView.addObject(ParamConstant.LIST_REGISTERED_CLASS_ATTR,
                registrationServiceInterface.getNumberOfRegisteredClassByChurchId(churchId))
                .addObject(ParamConstant.SUBJECT_LIST, subjectServiceInterface.getDisplayedSubject())
                .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getEventCategoryList());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_EVENT_URL, method = RequestMethod.POST)
    public List<EventDisplayEntity> loadEventRegister() {
        List<EventDataEntity>data= eventServiceInterface.getListOfEvent();
        List<EventDisplayEntity>listEvent=new ArrayList<EventDisplayEntity>();
        Iterator<EventDataEntity> itr=data.iterator();
        while(itr.hasNext()){
            EventDataEntity item=itr.next();

        }

        return null;
    }


}
