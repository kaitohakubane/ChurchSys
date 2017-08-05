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

    public static final String LOGIN_URL = "/login";


    // Login
    public static final String LOGIN_PAGE_URL = "/login";
    public static final String GET_ACCOUNT_URL = "/admin/account/get-account";

    //Account
    public static final String ACCOUNT_REGISTER_URL = "/api/register";
    public static final String CHECK_LOGIN_URL = "/api/login";

    // Event
    public static final String LOAD_EVENT_REGISTER_URL = "/manager/event/load-event";
    public static final String LOAD_PUBLIC_EVENT_REGISTER_URL = "/church/{id}/schedule/load-event/";

    public static final String SCHEDULE_URL = "/manager/schedule";
    public static final String UPDATED_EVENT = "/manager/event/Updated";
    public static final String UPDATED_SINGLE_EVENT = "/manager/event/update-single-event";
    public static final String UPDATED_REPEAT_EVENT = "/manager/event/update-repeat-event";
    public static final String UPDATED_ERROR_REPEAT_EVENT = "/manager/event/update-error-repeat-event";

    public static final String CREATE_EVENT_URL = "/manager/event/Add";
    public static final String CHECK_EVENT_URL = "/manager/event/Check";
    public static final String UPDATE_EVENT_URL = "/manager/event/Update";
    public static final String LOAD_CONDUCTOR = "/manager/event/load-conductor";
    public static final String LOAD_ROOM = "/manager/event/load-room";

    public static final String CHECK_IS_MANY_SLOT = "/manager/event/check-is-many-slot";
    public static final String REMOVE_SINGLE_SLOT = "/manager/schedule/remove-single-slot";
    public static final String REMOVE_MULTI_SLOT = "/manager/schedule/remove-multi-slot";
    public static final String REMOVE_EVENT = "/manager/schedule/remove-event";

    public static final String UPDATE_DRAG_DROP_EVENT = "/manager/schedule/update-drag-drop-event";
    public static final String FINISH_EVENT = "/automation/finishEvent";

    public static final String UPDATE_NAME_AND_PRIVACY = "/manager/schedule/update-name-privacy";
    public static final String GET_EXAM_DATE = "/manager/event/Add/get-exam-date";

    //Stream
    public static final String STREAM_URL = "/manager/stream";
    public static final String SCHEDULE_STREAM_URL = "/manager/stream/Schedule";
    public static final String CREATE_STREAM_URL = "/manager/stream/Add";
    public static final String REMOVE_STREAM_URL = "/manager/stream/Delete";
    public static final String START_STREAM_URL = "/manager/stream/Start";
    public static final String FINISH_STREAM_URL = "/manager/stream/Finish";
    public static final String REGISTER_STREAM_URL = "/manager/stream/Register";
    public static final String STREAM_INSTRUCTION_URL = "/manager/stream/instruction";

    //Notification
    public static final String STREAM_NOTIFICATION_URL = "/manager/stream/notification";
    public static final String GET_NOTIFICATION_URL = "/notification/getNotification";
    public static final String MANAGER_NOTIFICATION_URL = "/manager/notifications";
    public static final String USER_NOTIFICATION_URL = "/user/notifications";


    //Class
    public static final String CREATE_CLASS_URL = "/manager/class/Add";
    public static final String CHECK_CLASS_URL = "/manager/class/Check";

    public static final String CHECK_CONDUCTOR_FOR_CLASS = "/manager/class/check-conductor";
    public static final String CHECK_ROOM_FOR_CLASS = "/manager/class/check-room";

    public static final String CHECK_CONFLICT_FOR_DRAG_DROP_EVENT = "/manager/event/check-drag-drop-valid";
    public static final String CHECK_CONFLICT_FOR_RESIZE_EVENT = "/manager/event/check-resize-valid";


    // Registration
    public static final String REGISTRATION_MANAGEMENT_URL = "/manager/registration-management";
    public static final String ADD_REGISTRATION = "/user/registration/Add";
    public static final String GET_ON_PLAN_CLASS_URL = "/church/class";
    public static final String CLASS_REGISTRATION = "/user/registration/Class";
    public static final String PREDEFINED_CLASS_REGISTRATION = "/user/registration/PredefinedClass";
    public static final String FOLLOW_CHURCH = "/user/church/Follow";
    public static final String GET_USER_REGISTRATION = "/manager/registration/GetInformation";
    public static final String ACCEPT_REGISTRATION_URL = "/manager/registration/Accept";
    public static final String REJECT_REGISTRATION_URL = "/manager/registration/Reject";


    // Room


    // Church

    public static final String CHURCH_HOME_URL = "/church";
    public static final String CHURCH_SCHEDULE_URL = "/church/schedule";
    public static final String CHURCH_SEARCH_URL = "/church/Search";
    public static final String CHURCH_INFO_URL = "/church/info";
    public static final String CHURCH_SETTING_PAGE_URL = "/church/setting";
    public static final String CHURCH_MANAGEMENT_URL = "/admin/church-management";
    public static final String ADD_CHURCH_URL = "/admin/new-church";
    public static final String UPDATE_CHURCH_URL = "/admin/setting/update-church";

    // Contribution


    // User
    public static final String PRIEST_MANAGEMENT_URL = "/manager/priest-management";
    public static final String ADD_NEW_PRIEST_URL = "/manager/priest-management/add-new-priest";
    public static final String USER_DASHBOARD_URL = "/user/dashboard";
    public static final String FOLLOW_ACTION = "/follow-action";

    // Validate
    public static final String GOOGLE_VALIDATE_URL = "/manager/google/Validate";

    //Grave
    public static final String GRAVE_MANAGEMENT_URL = "/manager/grave";
    public static final String GET_GRAVE_YARD = "/manager/graveYard/Get";
    public static final String GET_GRAVE = "/manager/grave/Get";
    public static final String GENERATE_GRAVE_YARD = "/manager/graveYard/Generate";
    public static final String GENERATE_GRAVE = "/manager/grave/Generate";
    public static final String REGISTER_GRAVE="/grave/Register";
    public static final String APPROVE_GRAVE_STATUS="/manager/grave/Approve";

    //Mobile
    public static final String MOBILE_GET_NOTIFICATION_URL = "/mobile/notification/Get";
    public static final String MOBILE_LOGIN_URL = "/mobile/user/login";

    /**
     * Common
     */
    public static final String DONATION_URL = "/church/donation";
    public static final String PRAY_URL = "/church/pray";
    public static final String CONTACT_URL = "/church/contact";
    public static final String BIBLE_URL = "/bible";
    public static final String AUGUST_URL = "/calendar/august";


    /**
     * For jsp page constant
     */

    // Home
    public static final String HOME_PAGE = "home-page";
    public static final String MAP_PAGE = "map-page";

    // Login
    public static final String LOGIN_PAGE = "login-page";

    // Event

    public static final String SCHEDULE_PAGE = "schedule-page";
    public static final String EDIT_EVENT_PAGE = "edit-event-page";
    public static final String STREAM_PAGE = "stream-page";
    public static final String STREAM_INSTRUCTION_PAGE = "instruction-page";

    // Registration
    public static final String REGISTRATION_PAGE = "registration-page";
    public static final String REGISTRATION_MANAGEMENT_PAGE = "registration-management-page";


    // Room
    public static final String SALE_PAGE = "sale-management-page";
    public static final String ROOM_MANAGEMENT_PAGE = "room-management-page";
    public static final String ROOM_MANAGEMENT_URL = "/manager/room-management";
    public static final String ADD_NEW_ROOM_URL = "/manager/room-management/add-new-room";
    // Church
    public static final String CHURCH_HOME_PAGE = "/user-pages/information-page";
    public static final String CHURCH_SCHEDULE_PAGE = "/user-pages/event-page";
    public static final String CHURCH_CLASS_PAGE = "/user-pages/class-registration-page";
    public static final String INTRODUCTION_PAGE = "/user-pages/introduce-page";
    public static final String CHURCH_MANAGEMENT_PAGE = "church-management-page";
    public static final String CHURCH_SETTING_PAGE = "setting-page";
    public static final String ADD_CHURCH_PAGE = "add-church-page";


    // User
    public static final String NOTIFICATION_PAGE = "notification-page";
    public static final String USER_NOTIFICATION_PAGE = "/user-pages/user-notification-page";
    public static final String PRIEST_MANAGEMENT_PAGE = "priest-management-page";
    public static final String USER_DASHBOARD_PAGE = "/user-pages/dashboard-page";


    // Slot
    public static final String DAILY_REPORT_PAGE = "daily-report-page";
    public static final String CHART_PAGE = "chart-page";

    //Error
    public static final String NOT_FOUND_PAGE = "error-pages/404-page";

    //Grave
    public static final String GRAVE_PAGE = "grave-page";

    //Common
    public static final String DONATION_PAGE = "/info-page/donation-page";
    public static final String PRAY_PAGE = "/info-page/pray-page";
    public static final String CONTACT_PAGE = "/info-page/contact-page";
    public static final String BIBLE_PAGE = "/info-page/bible-page";
    public static final String AUGUST_PAGE = "/info-page/august-page";


}
