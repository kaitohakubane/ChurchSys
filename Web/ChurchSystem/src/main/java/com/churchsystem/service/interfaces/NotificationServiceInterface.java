package com.churchsystem.service.interfaces;

import com.churchsystem.entity.NotificationEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
public interface NotificationServiceInterface {

    public void addNotification(NotificationEntity notificationEntity);

    void updateNotification(NotificationEntity notificationEntity);

    List<NotificationEntity> getUserNotification(int userId);

    void notify(NotificationEntity notification, String username);
}
