package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.CreatingEventEntity;
import com.churchsystem.entity.EventEntity;
import com.churchsystem.entity.EventRegisterEntity;
import com.churchsystem.entity.SlotEntity;
import com.churchsystem.service.interfaces.RoomServiceInterface;
import com.churchsystem.service.interfaces.TypeServiceInterface;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = PageConstant.CREATE_EVENT_URL, method = RequestMethod.POST)
    public CreatingEventEntity loadEventRegister(@RequestBody CreatingEventEntity creatingEventEntity) {
//        CreatingEventEntity creatingEventEntity=new CreatingEventEntity();
    try{
//        JSONObject jsonObject=new JSONObject(strEvent);
//        EventEntity eventEntity=new EventEntity();
//        SlotEntity slotEntity=new SlotEntity();
        creatingEventEntity.getDuration();
        creatingEventEntity=new CreatingEventEntity(1,"HungMC-Event","1","1","2017-06-13T06:00","1","03:00");

    }catch(Exception e){
        e.printStackTrace();
    }
        return creatingEventEntity;
    }



}
