package com.churchsystem.controller;

import com.churchsystem.service.interfaces.RoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hungmcse61561-admin on 6/6/2017.
 */
@Controller
public class RoomController {
    @Autowired
    RoomServiceInterface roomServiceInterface;
}
