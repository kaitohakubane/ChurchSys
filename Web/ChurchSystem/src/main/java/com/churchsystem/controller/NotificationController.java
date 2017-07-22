package com.churchsystem.controller;

import com.churchsystem.common.api.CalendarAPI;
import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.common.utils.StringUtils;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.Notification;
import com.churchsystem.entity.NotificationEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.NotificationServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import com.google.api.client.util.DateTime;
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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
@Controller
public class NotificationController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    NotificationServiceInterface notificationServiceInterface;

    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @ResponseBody
    @RequestMapping(value = PageConstant.STREAM_NOTIFICATION_URL, method = RequestMethod.GET)
    public void pushNotification(@RequestParam(value = ParamConstant.NOTIFICATION_LINK) String link,
                                 @RequestParam(value = ParamConstant.STREAM_TITLE) String title, HttpServletRequest request) {

        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        String information = ParamConstant.EVENT_NAME_PRE + title + ParamConstant.STREAM_MESSAGE;
        ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        List<String> listAccount = userServiceInterface.getListOfChurchFollower(churchId);
        for (String accountId : listAccount) {
            NotificationEntity temp = new NotificationEntity();
            UserEntity user = userServiceInterface.getUserByAccountId(accountId);
            temp.setUserId(user.getUserId());
            temp.setInformation(information);
            temp.setSender(churchEntity.getChurchName());
            temp.setLink(link);
            temp.setTime(time);
            temp.setType(ParamConstant.YOUTUBE_TYPE);
            notificationServiceInterface.addNotification(temp);
            Notification msgEntity = new Notification(temp);
            notificationServiceInterface.notify(
                    msgEntity, // notification object
                    accountId                    // username
            );
        }

    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_NOTIFICATION_URL, method = RequestMethod.POST)
    public List<NotificationEntity> getNotification() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accountId = auth.getName();
        UserEntity user = userServiceInterface.getUserByAccountId(accountId);
        List<NotificationEntity> notifications = notificationServiceInterface
                .getUserNotification(user.getUserId(), UtilsConstant.NOTIFICATION_NUMBER_DEFAULT);
        return notifications;
    }


    @RequestMapping(value = PageConstant.MANAGER_NOTIFICATION_URL, method = RequestMethod.GET)
    public ModelAndView getListNotification() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accountId = auth.getName();
        UserEntity user = userServiceInterface.getUserByAccountId(accountId);
        List<NotificationEntity> notifications = notificationServiceInterface
                .getUserNotification(user.getUserId(), UtilsConstant.NOTIFICATION_LIST_NUMBER_DEFAULT);
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOTIFICATION_PAGE);
        modelAndView.addObject(ParamConstant.NOTIFICATION_LIST, notifications);
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.USER_NOTIFICATION_URL, method = RequestMethod.GET)
    public ModelAndView loadUserNotificationPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accountId = auth.getName();
        UserEntity user = userServiceInterface.getUserByAccountId(accountId);
        List<NotificationEntity> notifications = notificationServiceInterface
                .getUserNotification(user.getUserId(), UtilsConstant.NOTIFICATION_LIST_NUMBER_DEFAULT);
        ModelAndView modelAndView = new ModelAndView(PageConstant.USER_NOTIFICATION_PAGE);
        modelAndView.addObject(ParamConstant.NOTIFICATION_LIST, notifications);
        return modelAndView;
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView testNotification() {
        ModelAndView modelAndView = new ModelAndView("test-page");
//        NotificationEntity temp = new NotificationEntity();
//        UserEntity user = userServiceInterface.getUserByAccountId("hungmc");
//        temp.setUserId(user.getUserId());
//        temp.setInformation("Bạn Hưng quá giỏi giỏi quá de i luv you pặc pặc");
//        temp.setSender("Hệ thống: ");
//        temp.setLink("/manager/notifications");
//        temp.setTime(new Timestamp(System.currentTimeMillis()));
//        temp.setType(ParamConstant.DEFAULT_TYPE);
//        notificationServiceInterface.addNotification(temp);
//        Notification msgEntity = new Notification(temp);
//        notificationServiceInterface.notify(
//                msgEntity, // notification object
//                "hungmc"                    // username
//        );
//
//
//        user = userServiceInterface.getUserByAccountId("vongnlh");
//        temp.setUserId(user.getUserId());
//        temp.setInformation("Bạn Hưng User quá giỏi giỏi quá de i luv you pặc pặc");
//        temp.setSender("Hệ thống: ");
//        temp.setLink("/user/notifications");
//        temp.setTime(new Timestamp(System.currentTimeMillis()));
//        temp.setType(ParamConstant.DEFAULT_TYPE);
//        notificationServiceInterface.addNotification(temp);
//        msgEntity = new Notification(temp);
//        notificationServiceInterface.notify(
//                msgEntity, // notification object
//                "vongnlh"                    // username
//        );

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/test/post", method = RequestMethod.GET)
    public String tesCalendar() {
        Time startTime = new Time(System.currentTimeMillis() + 3600*1000*24);
        Time endTime = new Time(startTime.getTime() + 3600*1000*3);
        DateTime startDate = new DateTime( System.currentTimeMillis()+startTime.getTime());
        DateTime endDate = new DateTime(System.currentTimeMillis()+endTime.getTime());
        String result="Sida vkl";
        try{
            result=CalendarAPI.createGoogleEvent(5,"DM SS", "Room 516 KTX Sinh viên", "Hưng quá gê",  startDate,
                    endDate, null, "shengshin7@gmail.com", UtilsConstant.DEFAULT_VALIDATE_PORT);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
