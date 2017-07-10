package com.churchsystem.controller;

import com.churchsystem.entity.Notification;
import com.churchsystem.service.common.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void someAction() {

        // Do an action here
        // ...

        // Send the notification to "UserA" (by username)
        notificationService.notify(
                new Notification("SS", 1, "https://www.youtube.com/watch?v=nqUpqUJ3ZNo"), // notification object
                "hungmc"                    // username
        );
    }

    @RequestMapping(value = "/test/websocket", method = RequestMethod.GET)
    public ModelAndView testPage() {
        ModelAndView modelAndView = new ModelAndView("test-page");
        return modelAndView;
    }

}
