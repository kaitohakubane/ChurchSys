package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.entity.EventRegisterEntity;
import com.churchsystem.service.interfaces.RoomServiceInterface;
import com.churchsystem.service.interfaces.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @ResponseBody
    @RequestMapping(value = PageConstant.LOAD_EVENT_REGISTER_URL, method = RequestMethod.GET)
    public List<EventRegisterEntity> loadEventRegister() {
        List<EventRegisterEntity> results = new ArrayList<EventRegisterEntity>();
        return null;
    }



}
