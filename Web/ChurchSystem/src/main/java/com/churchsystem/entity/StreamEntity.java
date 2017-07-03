package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 7/2/2017.
 */
public class StreamEntity {
    private String streamLink;
    private String streamCode;

    public StreamEntity(String streamLink, String streamCode) {
        this.streamLink = streamLink;
        this.streamCode = streamCode;
    }

    public StreamEntity() {
    }

    public String getStreamLink() {
        return streamLink;
    }

    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }

    public String getStreamCode() {
        return streamCode;
    }

    public void setStreamCode(String streamCode) {
        this.streamCode = streamCode;
    }
}

