package com.churchsystem.common.api;

/**
 * Created by hungmcse61561-admin on 6/26/2017.
 */

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
    private static List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");

    public static String createBroadcast(String broadcastTitle, Date startTime) throws IOException {
        // Authorize the request.
        Credential credential = Auth.authorize(scopes, "createbroadcast");

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
        return returnedStream.getId();
    }


    public static LiveBroadcast bindingBroadcastAndStream(String streamId, String broadcastId) throws IOException {
        YouTube.LiveBroadcasts.Bind liveBroadcastBind =
                youtube.liveBroadcasts().bind(broadcastId, "id,contentDetails");
        liveBroadcastBind.setStreamId(streamId);
        LiveBroadcast returnedBroadcast = liveBroadcastBind.execute();
        return returnedBroadcast;
    }

    // Construct and execute the API request to insert the broadcast.
            // Print information from the API response.
//            System.out.println("\n================== Returned Broadcast ==================\n");
//            System.out.println("  - Id: " + returnedBroadcast.getId());
//            System.out.println("  - Title: " + returnedBroadcast.getSnippet().getTitle());
//            System.out.println("  - Description: " + returnedBroadcast.getSnippet().getDescription());
//            System.out.println("  - Published At: " + returnedBroadcast.getSnippet().getPublishedAt());
//            System.out.println(
//                    "  - Scheduled Start Time: " + returnedBroadcast.getSnippet().getScheduledStartTime());
//            System.out.println(
//                    "  - Scheduled End Time: " + returnedBroadcast.getSnippet().getScheduledEndTime());

            // Prompt the user to enter a title for the video stream.


            // Define the content distribution network settings for the
            // video stream. The settings specify the stream's format and
            // ingestion type. See:
            // https://developers.google.com/youtube/v3/live/docs/liveStreams#cdn


            // Construct and execute the API request to insert the stream.


            // Print information from the API response.
//            System.out.println("\n================== Returned Stream ==================\n");
//            System.out.println("  - Id: " + returnedStream.getId());
//            System.out.println("  - Stream Name: " + returnedStream.getCdn().getIngestionInfo().getStreamName());
//            System.out.println("  - Description: " + returnedStream.getSnippet().getDescription());
//            System.out.println("  - Published At: " + returnedStream.getSnippet().getPublishedAt());

            // Construct and execute a request to bind the new broadcast
            // and stream.


            // Print information from the API response.
//            System.out.println("\n================== Returned Bound Broadcast ==================\n");
//            System.out.println("  - Broadcast Id: " + returnedBroadcast.getId());
//            System.out.println(
//                    "  - Bound Stream Id: " + returnedBroadcast.getContentDetails().getBoundStreamId());

//        } catch (GoogleJsonResponseException e) {
//            System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
//                    + e.getDetails().getMessage());
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            System.err.println("IOException: " + e.getMessage());
//            e.printStackTrace();
//        } catch (Throwable t) {
//            System.err.println("Throwable: " + t.getMessage());
//            t.printStackTrace();
//        }

}