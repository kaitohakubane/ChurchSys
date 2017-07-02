package com.churchsystem.entity;

/**
 * Created by hungmcse61561-admin on 7/2/2017.
 */
public class StreamJsonEntity {
    private String streamTitle;
    private String resolution;

    public StreamJsonEntity(String streamTitle, String resolution) {
        this.streamTitle = streamTitle;
        this.resolution = resolution;
    }

    public String getStreamTitle() {
        return streamTitle;
    }

    public void setStreamTitle(String streamTitle) {
        this.streamTitle = streamTitle;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
