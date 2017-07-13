package com.churchsystem.common.constants;

/**
 * Created by Hung on 11/18/2016.
 */
public class ParamConstant {

    public static final String FROM_DATE = "fromDate";
    public static final String TO_DATE = "toDate";

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
     * Account
     */
    public static final String ACCOUNT_ID = "accountId";
    public static final String NAME = "username";
    public static final String BIRTHDAY = "birthday";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    /**
     * Church
     */
    public static final String CHURCH_ID = "churchId";

    public static final String CHURCH_LIST = "churchList";

    public static final String CATEGORY_LIST = "categoryList";
    public static final int NOT_EVENT_CATEGORY_ID = 3;
    public static final String CHURCH_OBJECT = "churchObj";
    public static final String INPUT_LONGITUDE = "inputLongitude";
    public static final String INPUT_LATITUDE = "inputLatitude";
    public static final String DISTANCE = "distance";
    public static final int DEFAULT_RADIUS = 10;
    public static final int ADDITIONAL_DISTANCE = 20;
    public static final int MAXIMUM_DISTANCE = 50;

    /**
     * Registration
     */
    public static final String LIST_REGISTRATION_ATTR = "registrationList";
    public static final String LIST_REGISTERED_CLASS_ATTR = "registeredClass";
    public static final String ON_PLAN_CLASS_LIST="onPlanClassList";
    public static final int REGISTRATION_WAITING_STATUS=1;
    public static final int REGISTRATION_DENY_STATUS=2;
    public static final int REGISTRATION_FINISH_STATUS=3;
    public static final String REGISTRATION_STATUS="regisStatus";
    public static final String REGISTRATION_START_TIME="regisStartTime";
    public static final String REGISTRATION_EST_TIME="estTime";



    /**
     * Event
     */
    public static final String EVENT_OBJECT = "normalizedEvent";
    public static final String EVENT_TITLE = "eventTitle";
    public static final String EVENT_DATE = "eventDate";
    public static final String IS_PUBLIC = "isPublic";
    public static final String EVENT_STATUS = "status";
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
    public static final String EVENT_NAME_PRE="Sự kiện ";
    public static final String STREAM_MESSAGE = " đang được trực tuyến";
    public static final String REGISTRATION_MESSAGE=" mới vừa được đăng ký ở nhà thờ của bạn";
    public static final String NOTIFICATION_TIME="time";
    public static final int YOUTUBE_TYPE=1;
    public static final int DEFAULT_TYPE=0;


    /**
     * Slot
     */
    public static final String SLOT_HOUR_LIST = "slotHourList";
    public static final String SLOT_HOUR = "slotHour";
    public static final String CONDUCTOR_ID = "conductorId";
    public static final String CONDUCTOR_LIST = "conductorList";
    public static final String SLOT_ID = "slotId";
    public static final String SLOT_DATE = "slotDate";
    public static final int SLOT_CONFLICT_STATUS = 0;
    public static final int SLOT_OK_STATUS = 1;
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


}
