package com.churchsystem.entity;

/**
 * Created by Hung on 9/12/2017.
 */
public class MessageEntity {
    private String sender;
    private String message;
    private String senderName;

    public MessageEntity(String sender, String message, String senderName) {
        this.sender = sender;
        this.message = message;
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
