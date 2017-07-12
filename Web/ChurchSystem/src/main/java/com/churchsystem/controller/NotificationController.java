package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.service.common.NotificationRealTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
@Controller
public class NotificationController {
    @Autowired
    private NotificationRealTimeService notificationRealTimeService;

    @ResponseBody
    @RequestMapping(value = PageConstant.STREAM_NOTIFICATION_URL, method = RequestMethod.GET)
    public void someAction(@RequestParam(value = ParamConstant.NOTIFICATION_LINK) String link,
                           @RequestParam(value=ParamConstant.STREAM_TITLE) String title, HttpServletRequest request) {

        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        String information= UtilsConstant.EVENT_NAME_PRE +title+ParamConstant.STREAM_MESSAGE;


//        notificationService.notify(
//                new Notification("SS", 1, "https://www.youtube.com/watch?v=nqUpqUJ3ZNo"), // notification object
//                loginUser                    // username
//        );
    }

    @RequestMapping(value = "/test/websocket", method = RequestMethod.GET)
    public ModelAndView testPage() {
        ModelAndView modelAndView = new ModelAndView("test-page");
        return modelAndView;
    }

}
