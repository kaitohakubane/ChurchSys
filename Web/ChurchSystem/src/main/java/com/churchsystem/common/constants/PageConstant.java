package com.churchsystem.common.constants;

/**
 * Created by Hung on 11/18/2016.
 */
public class PageConstant {
    public static final String REDIRECT = "redirect:";

    /**
     * For page request constant
     */

    // Home
    public static final String ROOT_PATH_URL = "/";

    public static final String ADMIN_ROOT_PATH_URL = "/admin";

    public static final String MANAGER_ROOT_PATH_URL = "/manager";

    public static final String MANAGER_HOME_PAGE_URL = "/manager/home";

    public static final String LOGIN_URL="/login";



    // Login
    public static final String LOGIN_PAGE_URL = "/login";
    public static final String GET_ACCOUNT_URL = "/admin/account/get-account";

    //Account
    public static final String ACCOUNT_REGISTER_URL="/api/register";
    public static final String CHECK_LOGIN_URL="/api/login";

    // Event
    public static final String LOAD_EVENT_REGISTER_URL = "/manager/event/load-event";
    public static final String LOAD_PUBLIC_EVENT_REGISTER_URL = "/church/{id}/schedule/load-event/";
    public static final String SCHEDULE_URL="/manager/schedule";
    public static final String CREATE_EVENT_URL="/manager/event/Add";
    public static final String UPDATE_EVENT_URL="/manager/event/Update";

    //Stream
    public static final String STREAM_URL="/manager/stream";
    public static final String SCHEDULE_STREAM_URL="/manager/stream/Schedule";
    public static final String CREATE_STREAM_URL="/manager/stream/Add";
    public static final String REMOVE_STREAM_URL="/manager/stream/Delete";

    //Class
    public static final String CREATE_CLASS_URL="/manager/class/Add";

    // Registration
    public static final String REGISTRATION_MANAGEMENT_URL = "/manager/registration-management";


    // Room


    // Church
    public static final String CHURCH_HOME_URL="/church/{id}";
    public static final String CHURCH_SCHEDULE_URL="/church/{id}/schedule";

    // Contribution


    // User
    public static final String USER_NOTIFICATION_URL="/user/notification";

    // Slot


    //Subject

    /**
     * For jsp page constant
     */

    // Home
    public static final String HOME_PAGE = "home-page";
    public static final String MAP_PAGE="map-page";

    // Login
    public static final String LOGIN_PAGE = "login-page";

    // Event
    public static final String SCHEDULE_PAGE="schedule-page";
    public static final String EDIT_EVENT_PAGE="edit-event-page";
    public static final String STREAM_PAGE="stream-page";

    // Registration
    public static final String BILL_PAGE = "bill-management-page";
    public static final String REGISTRATION_PAGE="registration-page";

    // Room
    public static final String SALE_PAGE = "sale-management-page";

    // Church
    public static final String CHURCH_HOME_PAGE = "/user-pages/information-page";
    public static final String CHURCH_SCHEDULE_PAGE="/user-pages/event-page";

    // User
   public static final String NOTIFICATION_PAGE="notification-page";

    // Slot
    public static final String DAILY_REPORT_PAGE = "daily-report-page";
    public static final String CHART_PAGE = "chart-page";

    //Error
    public static final String NOT_FOUND_PAGE="error-pages/404-page";


}
