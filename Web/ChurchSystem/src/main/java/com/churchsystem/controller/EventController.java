package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.entity.EventRegisterEntity;
import com.churchsystem.service.interfaces.ManagerServiceInterface;
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

    @Autowired
    ManagerServiceInterface managerServiceInterface;

    @ResponseBody
    @RequestMapping(value= PageConstant.LOAD_EVENT_REGISTER,method= RequestMethod.GET)
    public List<EventRegisterEntity> loadEventRegister(){
        List<EventRegisterEntity> results=new ArrayList<EventRegisterEntity>();

//
//        for(int k=UtilsConstant.ZERO;k)
//
//
//
//        Iterator<TypeEntity> itr= typeServiceInterface.getAllType().iterator();
//        while(itr.hasNext()){
//            EventRegisterEntity eventRegisterEntity=new EventRegisterEntity();
//            TypeEntity typeVar=itr.next();
//            eventRegisterEntity.setTypeId(typeVar.getTypeId());
//            eventRegisterEntity.setDescription(typeVar.getDescription());
//        }
    return null;
    }
}
