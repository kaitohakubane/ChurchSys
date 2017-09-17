package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by Hung on 9/12/2017.
 */
@Entity
@Table(name = "chatmessage", schema = "churchsys", catalog = "")
public class ChatmessageEntity implements Comparable<ChatmessageEntity> {
    private int messageId;
    private Integer senderId;
    private Integer receiverId;
    private String information;

    @Id
    @Column(name = "messageId", nullable = false)
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "senderId", nullable = true)
    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "receiverId", nullable = true)
    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "information", nullable = true, length = -1)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatmessageEntity that = (ChatmessageEntity) o;

        if (messageId != that.messageId) return false;
        if (senderId != null ? !senderId.equals(that.senderId) : that.senderId != null) return false;
        if (receiverId != null ? !receiverId.equals(that.receiverId) : that.receiverId != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (receiverId != null ? receiverId.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(ChatmessageEntity o) {
        return this.getMessageId()-o.getMessageId();
    }
}
