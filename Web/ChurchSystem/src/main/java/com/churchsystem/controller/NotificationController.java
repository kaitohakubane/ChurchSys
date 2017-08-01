package com.churchsystem.controller;

import com.churchsystem.common.api.Auth;
import com.churchsystem.common.api.CalendarAPI;
import com.churchsystem.common.api.PlusAPI;
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
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.client.util.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
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


    @ResponseBody
    @RequestMapping(value = PageConstant.MOBILE_GET_NOTIFICATION_URL, method = RequestMethod.POST)
    public List<NotificationEntity> getMobileNotification(@RequestParam(value=ParamConstant.USER_ID)String userId) {
        try{
            int userIdInt=Integer.parseInt(userId);
            List<NotificationEntity> notifications = notificationServiceInterface
                    .getUserNotification((userIdInt), UtilsConstant.NOTIFICATION_NUMBER_DEFAULT);
            return notifications;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

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

        return modelAndView;
    }

    public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    /**
     * Define a global instance of the JSON factory.
     */
    public static final JsonFactory JSON_FACTORY = new JacksonFactory();

    /**
     * This is the directory that will be used under the user's home directory where OAuth tokens will be stored.
     */
    private static final String CREDENTIALS_DIRECTORY = ".oauth-credentials";

    @ResponseBody
    @RequestMapping(value = "/test/post", method = RequestMethod.POST)
    public String tesCalendar(@RequestParam(value="token") String token) {
        try {
            String abc = PlusAPI.checkLoginAccount(token,"kaitohakubane@gmail.com",UtilsConstant.DEFAULT_VALIDATE_PORT);
            if(abc==null){
                return UtilsConstant.GOOGLE_API_INVALID_EMAIL;
            }else{
                return abc;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception";
        }
    }





    @RequestMapping(value = "/test/init", method = RequestMethod.GET)
    public ModelAndView tesCalendar3() {
        ModelAndView modelAndView=new ModelAndView("test-page");
     return modelAndView;
    }

}
