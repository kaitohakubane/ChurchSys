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

    public static final String GET_SUITABLE_ROOM_FOR_SLOT = "select roomId from room where churchId =:churchId " +
            "AND roomId NOT IN (select s2.roomId From (Select s.slotId, s.roomId, s.slotDate, s1.startTime," +
            " s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, " +
            "inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 " +
            "where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime <= s3.endTime AND s2.endTime >= s3.startTime) AND s2.slotDate =:slotDate) ORDER BY roomId LIMIT 1";


    //KietTA
    public static final String GET_REGISTERED_CLASS = "SELECT s.subId as subId, s.subName as subName," +
            " count(s.subId) as numOfRegistration " +
            "FROM registration r, subject s " +
            "WHERE r.churchId =:churchId and r.subId = s.subId AND regisStatus = 1 " +
            "GROUP BY (s.subId)";

    public static final String GET_LIST_OF_SUBJECT = "SELECT s.subId as subId, s.subName as subName," +
            " s.categoryId as categoryId " +
            "FROM subject s, category c " +
            "WHERE s.categoryId = c.categoryId AND c.categoryId != 3";

    public static final String GET_EVENT_DISPLAY_SLOT ="SELECT sru.slotId as slotId, e.eventId as eventId, " +
            "sru.conductorId as conductorId, sru.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, sru.userName as conductorName, sru.slotDate as slotDate, sru.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName, sru.slotStatus as status FROM (SELECT sr.*,u.userName " +
            "FROM (SELECT s.*,r.roomName FROM slot s LEFT JOIN room r ON s.roomId = r.roomId) " +
            "sr LEFT JOIN user u ON sr.conductorId = u.userId)sru, subject su,event e, " +
            "(SELECT i.slotId, MIN(sh.startTime) as startTime, MAX(sh.endTime) as endTime FROM slothour sh, inclusion i, slot s " +
            "WHERE i.slotId = s.slotid AND sh.slotHourId = i.slotHourId GROUP BY s.slotid) st WHERE su.subId = e.subId " +
            "AND st.slotId = sru.slotId AND sru.eventId = e.eventId AND churchId =:churchId";

    public static final String GET_PUBLIC_EVENT_DISPLAY_SLOT ="SELECT s.slotId as slotId, s.eventId as eventId, " +
            "s.conductorId as conductorId, s.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, u.userName as conductorName,s.slotDate as slotDate, r.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName FROM slot s,event e, room r, subject su, user u, " +
            "(SELECT i.slotId, MIN(sh.startTime) as startTime, MAX(sh.endTime) as endTime " +
            "FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid AND sh.slotHourId = i.slotHourId GROUP BY s.slotid) st " +
            "WHERE s.eventId = e.eventId AND s.roomId = r.roomId AND su.subId = e.subId AND s.conductorId = u.userId " +
            "AND e.churchId =:churchId AND st.slotId=s.slotId AND e.privacy = true";

    public static final String GET_CREATING_EVENT="SELECT * FROM event " +
            "WHERE startDate =:eventDate AND eventStatus =:status AND churchId =:churchId AND subId =:eventSubId AND eventId" +
            " NOT IN ( SELECT eventId FROM Slot WHERE eventId IS NOT NULL)";
            ;

    public static final String GET_SUITABLE_CONDUCTOR_FOR_SLOT="select distinct u.userId from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime <= s3.endTime AND s2.endTime >= s3.startTime) AND s2.slotDate =:slotDate) ORDER BY userId LIMIT 1";

    public static final String GET_DISPLAY_EVENT_BY_EVENT_ID="SELECT sru.slotId as slotId, e.eventId as eventId, " +
            "sru.conductorId as conductorId, sru.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, sru.userName as conductorName, sru.slotDate as slotDate, sru.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName, sru.slotStatus as status FROM (SELECT sr.*,u.userName FROM " +
            "(SELECT s.*,r.roomName FROM slot s LEFT JOIN room r ON s.roomId = r.roomId) sr LEFT JOIN user u " +
            "ON sr.conductorId = u.userId)sru, subject su,event e, (SELECT i.slotId, MIN(sh.startTime) as startTime, " +
            "MAX(sh.endTime) as endTime FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid AND " +
            "sh.slotHourId = i.slotHourId GROUP BY s.slotid) st WHERE e.eventId =:eventId AND su.subId = e.subId " +
            "AND st.slotId = sru.slotId AND sru.eventId = e.eventId";


    public static final String CHECK_CONDUCTOR_FOR_SLOT="select distinct u.userId from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId =:conductorId AND  u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime <= s3.endTime AND s2.endTime >= s3.startTime) AND s2.slotDate =:slotDate)";

    public static final String CHECK_ROOM_FOR_SLOT = "select roomId from room where churchId =:churchId AND roomId =:roomId " +
            "AND roomId NOT IN (select s2.roomId From (Select s.slotId, s.roomId, s.slotDate, s1.startTime," +
            " s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, " +
            "inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 " +
            "where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime <= s3.endTime AND s2.endTime >= s3.startTime) AND s2.slotDate =:slotDate)";
}
