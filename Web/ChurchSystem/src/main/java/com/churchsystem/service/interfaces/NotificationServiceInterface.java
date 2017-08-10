package com.churchsystem.service.interfaces;

import com.churchsystem.entity.Notification;
import com.churchsystem.entity.NotificationEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
public interface NotificationServiceInterface {

    void addNotification(NotificationEntity notificationEntity);

    void updateNotification(NotificationEntity notificationEntity);

    List<NotificationEntity> getUserNotification(int userId, int numberOfNoti);

    void sendNotification(int senderId, int userId, String information,int type,String streamLink);
}
