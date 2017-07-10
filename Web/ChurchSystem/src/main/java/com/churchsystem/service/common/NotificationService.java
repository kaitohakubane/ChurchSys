package com.churchsystem.service.common;

import com.churchsystem.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
@Service
public class NotificationService {
    @Autowired
    SimpMessagingTemplate messagingTemplate ;

    public void notify(Notification notification, String username) {
        messagingTemplate.convertAndSendToUser(
                username,
                "/queue/notify",
                notification
        );
        return;
    }

}
