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

    /**
     * Registration
     */
    public static final String LIST_REGISTRATION_ATTR = "registrationList";
    public static final String LIST_REGISTERED_CLASS_ATTR = "registeredClass";

    /**
     * Event
     */
    public static final String EVENT_OBJECT = "normalizedEvent";
    public static final String EVENT_TITLE="eventTitle";
    public static final String EVENT_DATE="eventDate";
    public static final String IS_PUBLIC="isPublic";
    public static final String EVENT_STATUS="status";
    public static final String EVENT_SUBJECT_ID="eventSubId";
    public static final int WAITING_FOR_APPROVE_STATUS=1;
    public static final int DENY_STATUS=2;
    public static final int APPROVE_STATUS=3;
    public static final int CONFLICT_STATUS=4;
    public static final int FINISH_STATUS=5;
    public static final String EVENT_ID="eventId";


    /**
     * Subject
     */
    public static final String SUBJECT_LIST = "subjectList";
    public static final String SUBJECT_ID="subId";

    /**
     * Church
     */
    public static final String CATEGORY_LIST = "categoryList";
    public static final int NOT_EVENT_CATEGORY_ID = 3;

    /**
     * Church
     */
    public static final String CHURCH_OBJECT = "churchObj";


    /**
     * Slot
     */
    public static final String SLOT_HOUR_LIST = "slotHourList";
    public static final String SLOT_HOUR="slotHour";
    public static final String CONDUCTOR_ID="conductorId";
    public static final String SLOT_ID="slotId";
    /**
     * Room
     */
    public static final String ROOM_ID="roomId";
}
