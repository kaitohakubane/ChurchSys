package com.churchsystem.common.constants;

/**
 * Created by Hung on 11/18/2016.
 */
public class SQLParamConstant {
    public static final String GET_REGISTRATION = "SELECT a.regisId as regisId,a.username as username," +
            "a.subId as subId, b.subName as subName,a.regisDate as regisDate,a.estTime as estTime," +
            " a.message as message,c.categoryName as categoryName " +
            "FROM registration a,subject b,category c " +
            "WHERE a.subId = b.subId AND b.categoryId = c.categoryId";

    public static final String GET_AVAILABLE_ROOM_FOR_SUBJECT = "SELECT * FROM room " + "WHERE roomStatus=true AND roomId" +
            " IN (SELECT roomId FROM roomcapable WHERE subId =: requireSubId)  ";

    public static final String GET_MANAGER_FOR_SUBJECT = "SELECT managerId,managerName FROM manager " +
            "WHERE managerId IN (SELECT managerId FROM ability WHERE subId =: requireSubId)";

    public static final String GET_SUITABLE_ROOM_FOR_SLOT = "select roomId from room where roomId NOT IN " +
            "(select s2.roomId From (Select s.slotId, s.roomId, s1.startTime, " +
            "s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime " +
            "from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) " +
            "s1 where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour ) " +
            "s3 Where s2.startTime <= s3.endTime AND s2.endTime >= s3.startTime)" +" ORDER BY roomId LIMIT 1";

    //KietTA
    public static final String GET_REGISTERED_CLASS = "SELECT s.subId as subId, s.subName as subName," +
            " count(s.subId) as numOfRegistration " +
            "FROM registration r, subject s " +
            "WHERE r.churchId =:requireChurchId and r.subId = s.subId " +
            "GROUP BY (s.subId)";

    public static final String GET_LIST_OF_SUBJECT = "SELECT s.subId as subId, s.subName as subName," +
            " s.categoryId as categoryId " +
            "FROM subject s, category c " +
            "WHERE s.categoryId = c.categoryId AND c.categoryId != 3";

    public static final String GET_EVENT_DISPLAY_SLOT ="SELECT s.slotId as slotId, s.eventId as eventId, " +
            "s.conductorId as conductorId, s.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, u.userName as conductorName,s.slotDate as slotDate, r.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName FROM slot s,event e, room r, subject su, user u, " +
            "(SELECT i.slotId, MIN(sh.startTime) as startTime, MAX(sh.endTime) as endTime " +
            "FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid AND sh.slotHourId = i.slotHourId GROUP BY s.slotid) st " +
            "WHERE s.eventId = e.eventId AND s.roomId = r.roomId AND su.subId = e.subId AND s.conductorId = u.userId " +
            "AND e.churchId =:requireChurchId AND st.slotId=s.slotId";

    public static final String GET_PUBLIC_EVENT_DISPLAY_SLOT ="SELECT s.slotId as slotId, s.eventId as eventId, " +
            "s.conductorId as conductorId, s.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, u.userName as conductorName,s.slotDate as slotDate, r.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName FROM slot s,event e, room r, subject su, user u, " +
            "(SELECT i.slotId, MIN(sh.startTime) as startTime, MAX(sh.endTime) as endTime " +
            "FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid AND sh.slotHourId = i.slotHourId GROUP BY s.slotid) st " +
            "WHERE s.eventId = e.eventId AND s.roomId = r.roomId AND su.subId = e.subId AND s.conductorId = u.userId " +
            "AND e.churchId =:requireChurchId AND st.slotId=s.slotId AND e.privacy = true";

    public static final String GET_CREATING_EVENT="SELECT * FROM event " +
            "WHERE startDate =:eventDate AND eventStatus =:status AND churchId =:churchId AND subId =:eventSubId"
            ;

    public static final String GET_SUITABLE_CONDUCTOR_FOR_SLOT="select userId from user where userId NOT IN " +
            "(select s2.conductorId From (Select s.slotId, s.conductorId, s1.startTime, s1.endTime from slot s, " +
            "(select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, inclusion i, " +
            "slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 where s.slotId = s1.slotId) s2," +
            " (select startTime, endTime from slothour where slotHourId =:slotHour ) s3 Where s2.startTime <= s3.endTime " +
            "AND s2.endTime >= s3.startTime) ORDER BY userId LIMIT 1";

    public static final String GET_EVENT_BY_SLOTID="SELECT s.slotId as slotId, s.eventId as eventId, s.conductorId as conductorId," +
            " s.roomId as roomId, su.subId as subId, st.startTime as startTime, st.endTime as endTime, " +
            "u.userName as conductorName,s.slotDate as slotDate, r.roomName as roomName, e.privacy as privacy, " +
            "e.description as description, su.subName as subName, e.eventStatus as eventStatus, e.eventName as eventName " +
            "FROM slot s,event e, room r, subject su, user u, (SELECT i.slotId, MIN(sh.startTime) as startTime, " +
            "MAX(sh.endTime) as endTime FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid " +
            "AND sh.slotHourId = i.slotHourId GROUP BY s.slotid) st WHERE s.slotId =:slotId AND " +
            "s.eventId = e.eventId AND s.roomId = r.roomId AND su.subId = e.subId AND s.conductorId = u.userId " +
            "AND st.slotId = s.slotId ";

}
