package com.churchsystem.common.api;

import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.StringUtils;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/18/2017.
 */
public class CalendarAPI {
    private static Calendar calendar;
    private static List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/calendar");

    public static String createGoogleEvent(int id,String summary, String location, String description, DateTime startDate,
                                           DateTime endDate, String[] rule, String attendeeMail, int port) throws IOException {
        Credential credential = Auth.authorize(scopes, "createCalendar", port);
        calendar=new Calendar.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                .setApplicationName("Church-System").build();

        Event event = new Event()
                .setSummary(summary)
                .setLocation(location)
                .setDescription(description);
        EventDateTime startTime = new EventDateTime().setDateTime(startDate);
        EventDateTime endTime = new EventDateTime().setDateTime(endDate);

        event.setStart(startTime);
        event.setEnd(endTime);

        if (rule != null) {
            event.setRecurrence(Arrays.asList(rule));

        }

        if (attendeeMail != null) {
            EventAttendee[] eventAttendees = new EventAttendee[]{
                    new EventAttendee().setEmail(attendeeMail)
            };
            event.setAttendees(Arrays.asList(eventAttendees));
        }

        EventReminder[] reminderOverrides = new EventReminder[]{
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };

        Event.Reminders reminders = new Event.Reminders().setUseDefault(false).setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);

        event.setColorId(UtilsConstant.GOOGLE_CALENDAR_EVENT_CORLOR_ID);
        String calendarId = "primary";
        String eventId= StringUtils.formatForLeadingZero(id,UtilsConstant.GOOGLE_CALENDAR_EVENT_PADDING_SIZE_ID);
        event.setId(eventId);
        event = calendar.events().insert(calendarId, event).execute();
        return event.getId();
    }
}
