package com.churchsystem.service.interfaces;

import com.churchsystem.entity.ChatmessageEntity;

import java.util.List;

/**
 * Created by Hung on 9/12/2017.
 */
public interface ChatServiceInterface {
    void createChat(ChatmessageEntity message);

    List<ChatmessageEntity> getChatHistory(int senderId, int receiverId);

    void sendChat(int senderId, int userId, String information);
}
