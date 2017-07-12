package com.churchsystem.service.common;

import com.churchsystem.entity.NotificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hungmcse61561-admin on 7/9/2017.
 */
@Service
public class NotificationRealTimeService {
    @Autowired
    SimpMessagingTemplate messagingTemplate ;

    public void notify(NotificationEntity notification, String username) {
        messagingTemplate.convertAndSendToUser(
                username,
                "/queue/notify",
                notification
        );
        return;
    }

}
