package com.churchsystem.common.api;

/**
 * Created by hungmcse61561-admin on 6/26/2017.
 */

import com.churchsystem.common.constants.UtilsConstant;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Use the YouTube Live Streaming API to insert a broadcast and a stream
 * and then bind them together. Use OAuth 2.0 to authorize the API requests.
 *
 * @author Ibrahim Ulukaya
 */
public class YoutubeAPI {

    /**
     * Define a global instance of a Youtube object, which will be used
     * to make YouTube Data API requests.
     */
    private static YouTube youtube;
    private static List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube"
            , "https://www.googleapis.com/auth/youtube.force-ssl");

    public static String createBroadcast(String broadcastTitle, Date startTime, int port) throws IOException {
        // Authorize the request.
        Credential credential = Auth.authorize(scopes, "createbroadcast", port);

        // This object is used to make YouTube Data API requests.
        youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                .setApplicationName("youtube-cmdline-createbroadcast-sample").build();
        // Create a snippet with the title and scheduled start and end
        // times for the broadcast. Currently, those times are hard-coded.
        LiveBroadcastSnippet broadcastSnippet = new LiveBroadcastSnippet();
        broadcastSnippet.setTitle(broadcastTitle);
        broadcastSnippet.setScheduledStartTime(new DateTime(startTime, TimeZone.getTimeZone("Asia/Ho_Chi_Minh")));
        // Set the broadcast's privacy status to "private". See:
        // https://developers.google.com/youtube/v3/live/docs/liveBroadcasts#status.privacyStatus
        LiveBroadcastStatus status = new LiveBroadcastStatus();
        status.setPrivacyStatus("public");
        LiveBroadcast broadcast = new LiveBroadcast();
        broadcast.setKind("youtube#liveBroadcast");
        broadcast.setSnippet(broadcastSnippet);
        broadcast.setStatus(status);
        YouTube.LiveBroadcasts.Insert liveBroadcastInsert =
                youtube.liveBroadcasts().insert("snippet,status", broadcast);
        LiveBroadcast returnedBroadcast = liveBroadcastInsert.execute();
        return returnedBroadcast.getId();
    }


    public static String createStream(String streamTitle, String resolution) throws IOException {
        // Create a snippet with the video stream's title.
        LiveStreamSnippet streamSnippet = new LiveStreamSnippet();
        streamSnippet.setTitle(streamTitle);
        CdnSettings cdnSettings = new CdnSettings();
        cdnSettings.setFormat(resolution);
        cdnSettings.setIngestionType("rtmp");

        LiveStream stream = new LiveStream();
        stream.setKind("youtube#liveStream");
        stream.setSnippet(streamSnippet);
        stream.setCdn(cdnSettings);
        YouTube.LiveStreams.Insert liveStreamInsert =
                youtube.liveStreams().insert("snippet,cdn", stream);
        LiveStream returnedStream = liveStreamInsert.execute();
        return returnedStream.getCdn().getIngestionInfo().getStreamName();
    }


    public static String bindingBroadcastAndStream(String streamId, String broadcastId) throws IOException {
        YouTube.LiveBroadcasts.Bind liveBroadcastBind =
                youtube.liveBroadcasts().bind(broadcastId, "id,contentDetails");
        liveBroadcastBind.setStreamId(streamId);
        LiveBroadcast returnedBroadcast = liveBroadcastBind.execute();
        return returnedBroadcast.getId();
    }


    public static String liveStream(String broadcastId) throws IOException, InterruptedException {
        LiveBroadcast workingBroadcast = null;
        YouTube.LiveBroadcasts.List liveBroadcastRequest =
                youtube.liveBroadcasts().list("id,snippet,status,contentDetails");
        liveBroadcastRequest.setId(broadcastId);
        LiveBroadcastListResponse returnedListResponse = liveBroadcastRequest.execute();
        List<LiveBroadcast> returnedList = returnedListResponse.getItems();
        workingBroadcast = returnedList.get(0);
        YouTube.LiveBroadcasts.Transition broadcastTransition = youtube.liveBroadcasts().transition("testing", workingBroadcast.getId(),
                "status,id");
        workingBroadcast = broadcastTransition.execute();

        do {
            liveBroadcastRequest = youtube.liveBroadcasts().list("id,snippet,status,contentDetails");
            liveBroadcastRequest.setId(workingBroadcast.getId());
            returnedListResponse = liveBroadcastRequest.execute();
            returnedList = returnedListResponse.getItems();
            workingBroadcast = returnedList.get(0);
            System.out.println("[DEBUG] Waiting for broadcast change transition" + workingBroadcast.getStatus().getLifeCycleStatus());
        } while (!workingBroadcast.getStatus().getLifeCycleStatus().equalsIgnoreCase("testing"));
        broadcastTransition = youtube.liveBroadcasts().transition("live", workingBroadcast.getId(),
                "status,id");

        workingBroadcast = broadcastTransition.execute();
        return workingBroadcast.getId();
    }


    public static String completeStream(String broadcastId) throws IOException {
        LiveBroadcast workingBroadcast = null;
        YouTube.LiveBroadcasts.List liveBroadcastRequest =
                youtube.liveBroadcasts().list("id,snippet,status,contentDetails");
        liveBroadcastRequest.setId(broadcastId);
        LiveBroadcastListResponse returnedListResponse = liveBroadcastRequest.execute();
        List<LiveBroadcast> returnedList = returnedListResponse.getItems();
        workingBroadcast = returnedList.get(0);
        YouTube.LiveBroadcasts.Transition broadcastTransition = youtube.liveBroadcasts().transition("complete", workingBroadcast.getId(),
                "status,id");
        workingBroadcast = broadcastTransition.execute();
        return workingBroadcast.getId();
    }

}