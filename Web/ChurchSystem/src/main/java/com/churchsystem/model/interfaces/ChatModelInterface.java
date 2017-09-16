package com.churchsystem.model.interfaces;

import com.churchsystem.entity.ChatmessageEntity;

import java.util.List;

/**
 * Created by Hung on 9/12/2017.
 */
public interface ChatModelInterface {

    void createChat(ChatmessageEntity message);

    List<ChatmessageEntity> getChatHistory(int senderId, int receiverId);
}
