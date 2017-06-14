package com.churchsystem.controller;

import com.churchsystem.service.interfaces.ChurchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Controller
public class ChurchController {
    @Autowired
    ChurchServiceInterface churchServiceInterface;

}
