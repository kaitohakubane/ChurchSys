package com.churchsystem.model.interfaces;

import com.churchsystem.entity.NotificationEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/11/2017.
 */
public interface NotificationModelInterface {
    void updateNotification(NotificationEntity notificationEntity);

    void addNotification(NotificationEntity notificationEntity);

    List<NotificationEntity> getUserNotification(int userId,int numberOfNoti);
}
