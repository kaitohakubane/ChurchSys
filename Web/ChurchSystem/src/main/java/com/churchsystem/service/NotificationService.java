package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.ChatModelInterface;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import com.churchsystem.model.interfaces.NotificationModelInterface;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.NotificationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
    SimpMessagingTemplate messagingTemplate;

    @Autowired
    ChatModelInterface chatModelInterface;

    @Autowired
    UserModelInterface userModelInterface;

    @Autowired
    ChurchModelInterface churchModelInterface;

    @Override
    public void addNotification(NotificationEntity notificationEntity) {
        notificationModelInterface.addNotification(notificationEntity);
    }

    @Override
    public void updateNotification(NotificationEntity notificationEntity) {
        notificationModelInterface.updateNotification(notificationEntity);
    }

    @Override
    public List<NotificationEntity> getUserNotification(int userId, int numberOfNoti) {
        return notificationModelInterface.getUserNotification(userId, numberOfNoti);
    }

    public void notify(Notification notification, String username) {
        messagingTemplate.convertAndSendToUser(
                username,
                "/queue/notify",
                notification
        );
    }

    @Override
    public void sendNotification(int senderId, int userId, String information, int type, String streamLink) {
        Timestamp time = new Timestamp(System.currentTimeMillis());

        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setTime(time);

        notificationEntity.setUserId(userId);
        notificationEntity.setInformation(information);
        if (senderId == ParamConstant.SYSTEM_ID) {
            notificationEntity.setSender(UtilsConstant.SYSTEM_NAME);
        } else {
            UserEntity userEntity = userModelInterface.getUserByUserId(senderId);
            if (userEntity.getRole().equals(UtilsConstant.MANAGER_USER)) {
                int churchId = userModelInterface.getChurchIdByUserId(userEntity.getUserId());
                ChurchEntity churchEntity = churchModelInterface.getChurchById(churchId);
                notificationEntity.setSender(churchEntity.getChurchName());
            }

        }
        UserEntity receiver = userModelInterface.getUserByUserId(userId);
        if (type == ParamConstant.DEFAULT_TYPE) {
            if (receiver.getRole().equals(UtilsConstant.MANAGER_USER)) {
                notificationEntity.setLink("/manager/notifications");
            } else {
                notificationEntity.setLink("/user/notifications");
            }
        } else {
            notificationEntity.setLink("/?" + ParamConstant.STREAM_LINK + "=" + streamLink);
        }

        notificationModelInterface.addNotification(notificationEntity);
        Notification msgEntity = new Notification(notificationEntity);
        notify(msgEntity, receiver.getAccountId());
    }
}
