package com.churchsystem.service;

import com.churchsystem.entity.NotificationEntity;
import com.churchsystem.model.interfaces.NotificationModelInterface;
import com.churchsystem.service.interfaces.NotificationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/11/2017.
 */
@Transactional
@Service
public class NotificationService implements NotificationServiceInterface {
    @Autowired
    NotificationModelInterface notificationModelInterface;

    @Autowired
    SimpMessagingTemplate messagingTemplate ;

    @Override
    public void addNotification(NotificationEntity notificationEntity) {
        notificationModelInterface.addNotification(notificationEntity);
    }

    @Override
    public void updateNotification(NotificationEntity notificationEntity){
        notificationModelInterface.updateNotification(notificationEntity);
    }

    @Override
    public List<NotificationEntity> getUserNotification(int userId,int numberOfNoti){
        return notificationModelInterface.getUserNotification(userId,numberOfNoti);
    }

    @Override
    public void notify(NotificationEntity notification, String username) {
        messagingTemplate.convertAndSendToUser(
                username,
                "/queue/notify",
                notification
        );

    }
}
