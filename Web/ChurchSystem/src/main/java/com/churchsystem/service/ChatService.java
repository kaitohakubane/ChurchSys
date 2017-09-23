package com.churchsystem.service;

import com.churchsystem.entity.ChatmessageEntity;
import com.churchsystem.entity.MessageEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.interfaces.ChatModelInterface;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.ChatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Hung on 9/12/2017.
 */

@Transactional
@Service
public class ChatService implements ChatServiceInterface {
    @Autowired
    ChatModelInterface chatModelInterface;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Autowired
    UserModelInterface userModelInterface;

    @Override
    public void createChat(ChatmessageEntity message) {
        chatModelInterface.createChat(message);
    }

    @Override
    public List<ChatmessageEntity> getChatHistory(int senderId, int receiverId) {
        return chatModelInterface.getChatHistory(senderId, receiverId);
    }

    public void chat(MessageEntity notification, String username) {
        messagingTemplate.convertAndSendToUser(
                username,
                "/queue/chat",
                notification
        );
    }

    @Override
    public void sendChat(int senderId, int userId, String information) {
        //save message
        ChatmessageEntity chatmessageEntity = new ChatmessageEntity();
        chatmessageEntity.setInformation(information);
        chatmessageEntity.setReceiverId(userId);
        chatmessageEntity.setSenderId(senderId);
        chatModelInterface.createChat(chatmessageEntity);
        //get info chatter
        UserEntity sender = userModelInterface.getUserByUserId(senderId);
        UserEntity receiver = userModelInterface.getUserByUserId(userId);

        MessageEntity messageEntity = new MessageEntity(sender.getAccountId(), information,sender.getUserName());
        //send message
        chat(messageEntity, receiver.getAccountId());
    }
}
