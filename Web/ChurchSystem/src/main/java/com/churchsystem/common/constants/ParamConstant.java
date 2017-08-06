package com.churchsystem.common.constants;

/**
 * Created by Hung on 11/18/2016.
 */
public class ParamConstant {

    public static final String FROM_DATE = "fromDate";
    public static final String TO_DATE = "toDate";

    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;


    /**
     * Homepage
     */
    public static final String NUMBER_OF_PRODUCT = "numberOfProduct";
    public static final String NUMBER_OF_BILL = "numberOfBill";
    public static final String NUMBER_OF_STOCK = "numberOfStock";
    public static final String NUMBER_OF_AVAILABLE_STOCK = "numberOfAvailableStock";
    public static final String NUMBER_OF_SALE = "numberOfSale";
    public static final String TOP_SELL_PRODUCT = "topProduct";

    /**
     * Church
     */
    public static final String CHURCH_ID = "churchId";
    public static final String CHURCH_NAME = "churchName";
    public static final String CHURCH_TEL = "tel";
    public static final String CHURCH_ADDRESS = "address";
    public static final String CHURCH_MAIL = "mail";
    public static final String CHURCH_DESCRIPTION = "description";
    public static final String CHURCH_LONGITUDE = "longitude";
    public static final String CHURCH_LATITUDE = "latitude";


    public static final String CHURCH_LIST = "churchList";

    public static final String CATEGORY_LIST = "categoryList";
    public static final int NOT_FIRST_EVENT_CATEGORY_ID = 3;
    public static final int NOT_SECOND_EVENT_CATEGORY_ID = 12;
    public static final String CHURCH_OBJECT = "churchObj";
    public static final String INPUT_LONGITUDE = "inputLongitude";
    public static final String INPUT_LATITUDE = "inputLatitude";
    public static final String DISTANCE = "distance";
    public static final int DEFAULT_RADIUS = 10;
    public static final int ADDITIONAL_DISTANCE = 20;
    public static final int MAXIMUM_DISTANCE = 50;
    public static final String CHURCH_INFORMATION = "churchInformationEntity";
    public static final String INCOMING_EVENT = "listIncomingEvent";
    public static final String INCOMING_CLASS = "listIncomingClass";
    public static final String CHURCH_SETTING = "setting";
    public static final String CHURCH_IS_SYNC = "isSync";

    /**
     * Registration
     */
    public static final String LIST_REGISTRATION_ATTR = "registrationList";
    public static final String LIST_REGISTERED_CLASS_ATTR = "registeredClass";
    public static final String ON_PLAN_CLASS_LIST = "onPlanClassList";
    public static final String ON_GOING_CLASS_LIST = "onGoingClassList";
    public static final int REGISTRATION_WAITING_STATUS = 1;
    public static final int REGISTRATION_DENY_STATUS = 2;
    public static final int REGISTRATION_FINISH_STATUS = 3;
    public static final String REGISTRATION_STATUS = "regisStatus";
    public static final String REGISTRATION_START_TIME = "regisStartTime";
    public static final String REGISTRATION_EST_TIME = "estTime";
    public static final String REGISTRATION_MESSAGE = "message";
    public static final String REGISTRATION_EVENT_DISPLAY = "registrationEventDisplayList";
    public static final String REGISTRATION_CLASS_DISPLAY = "registrationClassDisplayList";

    public static final String REGISTRATION_ID = "regisId";

    /**
     * Event
     */
    public static final String EVENT_OBJECT = "normalizedEvent";
    public static final String EVENT_TITLE = "eventTitle";
    public static final String EVENT_DATE = "eventDate";
    public static final String IS_PUBLIC = "isPublic";
    public static final String EVENT_STATUS = "eventStatus";
    public static final String IS_EVENT_REGISTERED = "isRegistered";
    public static final String EVENT_SUBJECT_ID = "eventSubId";
    public static final int WAITING_FOR_APPROVE_STATUS = 1;
    public static final int EVENT_DENY_STATUS = 2;
    public static final int EVENT_APPROVE_STATUS = 3;
    public static final int EVENT_FINISH_STATUS = 4;
    public static final String EVENT_ID = "eventId";
    public static final String USER_DEFAULT_EVENT_NAME = "Registered Event";
    public static final String CATEGORY_ID = "categoryId";
    public static final int CLASS_CATEGORY = 4;
    public static final String NO_NAME_EVENT_TITLE = "No name";
    public static final int NO_ROOM_AVAILABLE = -1;
    public static final int NO_CONDUCTOR_AVAILABLE = -1;
    /**
     * Grave
     */

    public static final String GRAVE_YARD_ID="graveYardId";
    public static final int GRAVE_YARD_NOT_INITIAL=0;
    public static final int GRAVE_YARD_INITIAL=1;
    public static final int GRAVE_YARD_FULL=2;
    public static final int GRAVE_YARD_GATE=3;
    public static final int GRAVE_YARD_STATUE=4;
    public static final int GRAVE_WAITING_FOR_APPROVE=0;
    public static final int GRAVE_APPROVED=1;
    public static final int GRAVE_PROCESSING=0;
    public static final String WIDTH="width";
    public static final String HEIGHT="height";
    public static final String GRAVE_YARD_LIST="graveYardList";
    public static final String GRAVE_YARD_PROTOTYPE="prototype";
    public static final String GRAVE_YARD_DEFAULT_NAME="Tủ ";
    public static final String GATE_DEFAULT_NAME="Cửa vào ";
    public static final String STATUE_DEFAULT_NAME="Tủ ";
    public static final int GRAVE_YARD_DEFAULT_START_NUMBER=1;
    public static final String GRAVE_ID="graveId";
    public static final String GRAVE_STATUS="status";
    public static final String GRAVE_NAME="graveName";
    public static final String GRAVE_BIRTH="graveBirth";
    public static final String GRAVE_HOME_TOWN="graveHomeTown";
    public static final String GRAVE_DEATH_DAY="graveDeathDay";
    public static final String GRAVE_PARISH="graveParish";
    public static final String GRAVE_IMAGE="graveImage";
    public static final String GRAVE_POSITION_X="positionX";
    public static final String GRAVE_POSITION_Y="positionY";
    public static final String GRAVE_STATUS_TYPE="statusType";
    public static final int  ACCEPT_TYPE=1;
    public static final int  REJECT_TYPE=0;


    public static final int IS_SYNC = 1;
    public static final int IS_NOT_SYNC = 0;



    /**
     * Subject
     */
    public static final String SUBJECT_LIST = "subjectList";
    public static final String SUBJECT_ID = "subId";

    /**
     * Notification
     */
    public static final String NOTIFICATION_LINK = "notificationLink";
    public static final String NOTIFICATION_INFORMATION = "notificationInformation";
    public static final String EVENT_NAME_PRE = "Sự kiện ";
    public static final String STREAM_MESSAGE = " đang được trực tuyến";
    public static final String MANAGER_REGISTRATION_MESSAGE = " mới vừa được đăng ký ở nhà thờ của bạn";
    public static final String NOTIFICATION_TIME = "time";
    public static final int YOUTUBE_TYPE = 1;
    public static final int DEFAULT_TYPE = 0;
    public static final String NOTIFICATION_LIST = "notificationList";
    public static final String USER_EVENT_REGISTRATION_NOTIFICATION = "Bạn đã đăng ký sự kiện ";
    public static final String USER_CLASS_REGISTRATION_NOTIFICATION = "Bạn đã đăng ký lớp ";
    public static final String TIME_MESSAGE_NOTIFICATION = " diễn ra vào lúc ";


    /**
     * Slot
     */
    public static final String SLOT_HOUR_LIST = "slotHourList";
    public static final String SLOT_HOUR = "slotHour";
    public static final String CONDUCTOR_ID = "conductorId";
    public static final String CONDUCTOR_LIST = "conductorList";
    public static final String SLOT_ID = "slotId";
    public static final String SLOT_DATE = "slotDate";
    public static final int SLOT_CONFLICT_STATUS = 2;
    public static final int SLOT_OK_STATUS = 1;
    public static final int SLOT_FINISH_STATUS = 3;
    public static final String SLOT_ENTITY = "slotEntity";
    public static final String NEW_START_TIME = "newStartTime";
    public static final String NEW_END_TIME = "newEndTime";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";


    /**
     * Room
     */

    public static final String ROOM_ID = "roomId";
    public static final String ROOM_LIST = "roomList";
    public static final int NO_SUBJECT_STATUS = 0;
    public static final int ENABLE_STATUS = 1;

    /**
     * Type
     */

    public static final String TYPE_DESCRIPTION = "description";
    public static final int NON_REPEAT_TYPE = 1;

    /**
     * Stream
     */
    public static final String STREAM_RESOLUTION = "resolution";
    public static final String STREAM_LINK = "streamLink";
    public static final String STREAM_CODE = "streamCode";
    public static final String STREAM_TITLE = "streamTitle";

    /**
     * User
     */
    public static final String PRIEST_LIST = "priestList";
    public static final String USER_ID = "userId";
    public static final String ACCOUNT_ID = "accountId";
    public static final String PASSWORD = "password";
    public static final String DEFAULT_PASSWORD = "Abcd1234";
    public static final String PRIEST_ROLE = "ROLE_PRIEST";
    public static final String MANAGER_ROLE = "ROLE_MANAGER";
    public static final boolean DEFAULT_ENABLE = true;
    public static final String INTERACTION_IS_ENABLE = "enabled";
    public static final int IS_FOLLOWING = 1;
    public static final String CURRENT_USER = "currentUser";
    public static final String USER_NAME = "userName";
    public static final String MANAGER_MAIL = "email";
    public static final String MANAGER_PHONE = "phone";
    public static final String MANAGER_CERT = "cert";
    /**
     * Status
     */

    /*Event*/
    public static final int EVENT_STATUS_WAITING_FOR_APPROVE = 1;
    public static final int EVENT_STATUS_DENY = 2;
    public static final int EVENT_STATUS_APPROVED = 3;
    public static final int EVENT_STATUS_FINISH = 4;
    public static final int EVENT_CONDUCTOR_POSITION = 0;
    public static final int EVENT_ROOM_POSITION = 1;
    public static final int EVENT_NO_ROOM_VALUE = -1;
    public static final int EVENT_NO_CONDUCTOR_VALUE = -1;

    /*Slot*/
    public static final int SLOT_STATUS_OK = 1;
    public static final int SLOT_STATUS_CONFLICT = 2;
    public static final int SLOT_STATUS_FINISH = 3;
    public static final int SLOT_UNAVAILABLE = 1;
    public static final int SLOT_AVAILABLE = 0;



    public static final int REGISTERED = 1;
    public static final int UNREGISTERED = 0;
}
