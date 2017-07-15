package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.NotificationEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.service.interfaces.NotificationServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
@Controller
public class NotificationController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    NotificationServiceInterface notificationServiceInterface;

    @ResponseBody
    @RequestMapping(value = PageConstant.STREAM_NOTIFICATION_URL, method = RequestMethod.GET)
    public void pushNotification(@RequestParam(value = ParamConstant.NOTIFICATION_LINK) String link,
                                 @RequestParam(value = ParamConstant.STREAM_TITLE) String title, HttpServletRequest request) {

        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        String information = ParamConstant.EVENT_NAME_PRE + title + ParamConstant.STREAM_MESSAGE;
        Timestamp time = new Timestamp(System.currentTimeMillis());
        List<String> listAccount = userServiceInterface.getListOfChurchFollower(churchId);
        for (String accountId : listAccount) {
            NotificationEntity temp = new NotificationEntity();
            UserEntity user = userServiceInterface.getUserByAccountId(accountId);
            temp.setUserId(user.getUserId());
            temp.setInformation(information);
            temp.setLink(link);
            temp.setTime(time);
            temp.setType(ParamConstant.YOUTUBE_TYPE);
            notificationServiceInterface.addNotification(temp);
            notificationServiceInterface.notify(
                    temp, // notification object
                    accountId                    // username
            );
        }

    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_NOTIFICATION_URL, method = RequestMethod.POST)
    public List<NotificationEntity> getNotification() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accountId=auth.getName();
        UserEntity user=userServiceInterface.getUserByAccountId(accountId);
        List<NotificationEntity> notifications=notificationServiceInterface
                .getUserNotification(user.getUserId(),UtilsConstant.NOTIFICATION_NUMBER_DEFAULT);
        return notifications;
    }



    @RequestMapping(value = PageConstant.GET_NOTIFICATION_LIST_URL, method = RequestMethod.GET)
    public ModelAndView getListNotification() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accountId=auth.getName();
        UserEntity user=userServiceInterface.getUserByAccountId(accountId);
        List<NotificationEntity> notifications=notificationServiceInterface
                .getUserNotification(user.getUserId(),UtilsConstant.NOTIFICATION_LIST_NUMBER_DEFAULT);
        ModelAndView modelAndView=new ModelAndView(PageConstant.NOTIFICATION_PAGE);
        modelAndView.addObject(ParamConstant.NOTIFICATION_LIST,notifications);
        return modelAndView;
    }
}
