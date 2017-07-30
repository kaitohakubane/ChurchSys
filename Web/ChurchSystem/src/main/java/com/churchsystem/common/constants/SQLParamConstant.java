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

    public static final String GET_SUITABLE_ROOM_FOR_SLOT = "select r.* from roomCapable rc, " +
            "(select roomId from room where churchId =:churchId " +
            "AND roomId NOT IN (select s2.roomId From (Select s.slotId, s.roomId, s.slotDate, s1.startTime," +
            " s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, " +
            "inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 " +
            "where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime < s3.endTime AND s2.endTime > s3.startTime) AND s2.slotDate =:slotDate) ORDER BY roomId) r " +
            "WHERE r.roomId = rc.roomId AND rc.subId=:subId LIMIT 1";

    public static final String GET_LAST_SUITABLE_ROOM_FOR_SLOT = "select r.* from roomCapable rc, " +
            "(select roomId from room where churchId =:churchId " +
            "AND roomId NOT IN (select s2.roomId From (Select s.slotId, s.roomId, s.slotDate, s1.startTime," +
            " s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, " +
            "inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 " +
            "where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime < s3.endTime AND s2.endTime > s3.startTime) AND s2.slotDate =:slotDate) ORDER BY roomId) r " +
            "WHERE r.roomId = rc.roomId AND rc.subId=:subId order by r.roomId desc LIMIT 1";

    //KietTA
    public static final String GET_REGISTERED_CLASS = "SELECT s.subId as subId, s.subName as subName," +
            " count(s.subId) as numOfRegistration " +
            "FROM registration r, subject s " +
            "WHERE r.churchId =:churchId and r.subId = s.subId AND r.regisStatus = 1 AND s.categoryId > 5 AND s.categoryId < 12 " +
            "GROUP BY (s.subId)";

    public static final String GET_LIST_OF_SUBJECT = "SELECT s.subId as subId, s.subName as subName," +
            " s.categoryId as categoryId " +
            "FROM subject s, category c " +
            "WHERE s.categoryId = c.categoryId AND c.categoryId != 3 AND c.categoryId != 12";

    public static final String GET_EVENT_DISPLAY_SLOT = "SELECT sru.slotId as slotId, e.eventId as eventId, " +
            "sru.conductorId as conductorId, sru.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, sru.userName as conductorName, sru.slotDate as slotDate, sru.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName, sru.slotStatus as status, sru.streamLink as streamLink, sru.streamCode as streamCode" +
            " FROM (SELECT sr.*,u.userName " +
            "FROM (SELECT s.*,r.roomName FROM slot s LEFT JOIN room r ON s.roomId = r.roomId) " +
            "sr LEFT JOIN user u ON sr.conductorId = u.userId)sru, subject su,event e, " +
            "(SELECT i.slotId, MIN(sh.startTime) as startTime, MAX(sh.endTime) as endTime FROM slothour sh, inclusion i, slot s " +
            "WHERE i.slotId = s.slotid AND sh.slotHourId = i.slotHourId GROUP BY s.slotid) st WHERE su.subId = e.subId " +
            "AND st.slotId = sru.slotId AND sru.eventId = e.eventId AND e.churchId =:churchId AND eventStatus != 2";

    public static final String GET_PUBLIC_EVENT_DISPLAY_SLOT = "SELECT s.slotId as slotId, s.eventId as eventId, " +
            "s.conductorId as conductorId, s.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, u.userName as conductorName,s.slotDate as slotDate, r.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName FROM slot s,event e, room r, subject su, user u, " +
            "(SELECT i.slotId, MIN(sh.startTime) as startTime, MAX(sh.endTime) as endTime " +
            "FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid AND sh.slotHourId = i.slotHourId GROUP BY s.slotid) st " +
            "WHERE s.eventId = e.eventId AND s.roomId = r.roomId AND su.subId = e.subId AND s.conductorId = u.userId " +
            "AND s.slotStatus != 2 AND e.eventStatus = 3 " +
            "AND e.churchId =:churchId AND st.slotId=s.slotId AND e.privacy = true";

    public static final String GET_CREATING_EVENT = "SELECT * FROM event " +
            "WHERE startDate =:eventDate AND eventStatus =:eventStatus AND churchId =:churchId AND subId =:eventSubId AND " +
            "isRegistered =:isRegistered AND eventId" +
            " NOT IN ( SELECT eventId FROM Slot WHERE eventId IS NOT NULL)";
    ;

    public static final String GET_SUITABLE_CONDUCTOR_FOR_SLOT = "select con.* from ability a, " +
            "(select distinct u.userId from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime < s3.endTime AND s2.endTime > s3.startTime) AND s2.slotDate =:slotDate) ORDER BY userId) con " +
            "WHERE con.userId = a.conductorId AND a.subId=:subId LIMIT 1";

    public static final String GET_LAST_SUITABLE_CONDUCTOR_FOR_SLOT = "select con.* from ability a, " +
            "(select distinct u.userId from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime < s3.endTime AND s2.endTime > s3.startTime) AND s2.slotDate =:slotDate) ORDER BY userId) con " +
            "WHERE con.userId = a.conductorId AND a.subId=:subId order by con.userId desc LIMIT 1";

    public static final String GET_LIST_SUITABLE_CONDUCTOR_FOR_SLOT_HOUR = "select con.* from ability a, " +
            "(select distinct u.userId from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime < s3.endTime AND s2.endTime > s3.startTime) AND s2.slotDate =:slotDate) ORDER BY userId) con " +
            "WHERE con.userId = a.conductorId AND a.subId=:subId order by con.userId";

    public static final String GET_DISPLAY_EVENT_BY_EVENT_ID = "SELECT sru.slotId as slotId, e.eventId as eventId, " +
            "sru.conductorId as conductorId, sru.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, sru.userName as conductorName, sru.slotDate as slotDate, sru.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName, sru.slotStatus as status FROM (SELECT sr.*,u.userName FROM " +
            "(SELECT s.*,r.roomName FROM slot s LEFT JOIN room r ON s.roomId = r.roomId) sr LEFT JOIN user u " +
            "ON sr.conductorId = u.userId)sru, subject su,event e, (SELECT i.slotId, MIN(sh.startTime) as startTime, " +
            "MAX(sh.endTime) as endTime FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid AND " +
            "sh.slotHourId = i.slotHourId GROUP BY s.slotid) st WHERE e.eventId =:eventId AND su.subId = e.subId " +
            "AND st.slotId = sru.slotId AND sru.eventId = e.eventId";


    public static final String CHECK_CONDUCTOR_FOR_SLOT = "select con.* from ability a, " +
            "(select distinct u.userId from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId =:conductorId AND  u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime <= s3.endTime AND s2.endTime >= s3.startTime) AND s2.slotDate =:slotDate)) con " +
            "WHERE con.userId = a.conductorId AND a.subId=:subId";

    public static final String CHECK_ROOM_FOR_SLOT = "select r.* from roomCapable rc, " +
            "(select roomId from room where churchId =:churchId AND roomId =:roomId " +
            "AND roomId NOT IN (select s2.roomId From (Select s.slotId, s.roomId, s.slotDate, s1.startTime," +
            " s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, " +
            "inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 " +
            "where s.slotId = s1.slotId) s2, (select startTime, endTime from slothour where slotHourId =:slotHour) s3 " +
            "Where (s2.startTime <= s3.endTime AND s2.endTime >= s3.startTime) AND s2.slotDate =:slotDate)) r " +
            "WHERE r.roomId = rc.roomId AND rc.subId=:subId";

    public static final String GET_STREAMING_EVENT_IN_DATE = "SELECT e.eventName as eventName,ssh.slotId as slotId, " +
            "ssh.slotDate as slotDate, ssh.streamCode as streamCode, ssh.streamLink as streamLink, ssh.startTime as startTime," +
            " ssh.endTime as endTime FROM (SELECT s.slotId,s.slotDate,s.eventId,s.streamCode,s.streamLink, " +
            "MIN(sh.startTime) as startTime, MAX(sh.endTime) as endTime FROM slot s,slothour sh,inclusion i WHERE " +
            "s.slotDate =:slotDate AND s.streamLink IS NOT NULL AND s.slotStatus!= 3 " +
            "AND s.slotId=i.slotId AND sh.slotHourId=i.slotHourId GROUP BY s.slotId) ssh,event e WHERE ssh.eventId =e.eventId";


    public static final String GET_EVENT_FROM_SLOT_ID = "SELECT sru.slotId as slotId, e.eventId as eventId, " +
            "sru.conductorId as conductorId, sru.roomId as roomId, su.subId as subId, st.startTime as startTime, " +
            "st.endTime as endTime, sru.userName as conductorName, sru.slotDate as slotDate, sru.roomName as roomName, " +
            "e.privacy as privacy, e.description as description, su.subName as subName, e.eventStatus as eventStatus, " +
            "e.eventName as eventName, sru.slotStatus as status FROM (SELECT sr.*,u.userName FROM " +
            "(SELECT s.*,r.roomName FROM slot s LEFT JOIN room r ON s.roomId = r.roomId) sr LEFT JOIN " +
            "user u ON sr.conductorId = u.userId)sru, subject su,event e, (SELECT i.slotId, MIN(sh.startTime) as startTime, " +
            "MAX(sh.endTime) as endTime FROM slothour sh, inclusion i, slot s WHERE i.slotId = s.slotid AND " +
            "sh.slotHourId = i.slotHourId GROUP BY s.slotid) st WHERE su.subId = e.subId AND st.slotId = sru.slotId AND " +
            "sru.eventId = e.eventId AND e.churchId =:churchId AND sru.slotId =:slotId";

    public static final String GET_LIST_SUITABLE_CONDUCTOR_FOR_SLOT = "select con.* from ability a, " +
            "(select distinct u.* from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2 " +
            "Where (s2.startTime <:newEndTime AND s2.endTime >:newStartTime) AND s2.slotDate =:slotDate AND s2.conductorId IS NOT NULL) ORDER BY userId) con " +
            "WHERE con.userId = a.conductorId AND a.subId=:subId";

    public static final String GET_LIST_SUITABLE_ROOM_FOR_SLOT = "select r.* from roomCapable rc, " +
            "(select * from room where churchId =:churchId " +
            "AND roomId NOT IN (select s2.roomId From (Select s.slotId, s.roomId, s.slotDate, s1.startTime," +
            " s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, " +
            "inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 " +
            "where s.slotId = s1.slotId) s2 " +
            "Where (s2.startTime <:newEndTime AND s2.endTime >:newStartTime) AND s2.slotDate =:slotDate AND s2.roomId IS NOT NULL) ORDER BY roomId) r " +
            "WHERE r.roomId = rc.roomId AND rc.subId=:subId";

    public static final String DELETE_SLOT_HOUR_BY_SLOT_ID = "DELETE FROM inclusion where slotId =:slotId";

    public static final String DELETE_SLOT_BY_SLOT_ID = "DELETE FROM slot WHERE slotId =:slotId";

    public static final String DELETE_EVENT_BY_EVENT_ID = "DELETE FROM event WHERE eventId =:eventId";

    public static final String GET_NEARBY_LOCATION = "SELECT churchId as churchId, ( 6371 * acos( cos( radians(:inputLatitude) ) * " +
            "cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:inputLongitude) ) + sin( radians(:inputLatitude) )" +
            " * sin( radians( latitude ) ) ) ) AS distance, churchName as churchName, tel as tel, startTime as startTime, endTime as endTime," +
            " description as description, streamLink as streamLink, longitude as longitude, latitude as latitude,streamName as streamName, " +
            "address as address FROM " +
            "church HAVING distance <:distance ORDER BY distance";

    public static final String GET_ON_PLAN_CLASS = "SELECT distinct e.eventId as eventId, e.eventName as eventName, e.startDate as startDate," +
            " su.subName as subName, su.categoryId as cateId, t.description as typeName, u.userName as conductorName, r.roomName as roomName, " +
            "sh.startTime as startTime, sh.endTime as endTime FROM event e, slot s, inclusion i, slothour sh,subject su, type t, user u, room r " +
            "WHERE e.eventStatus =:eventStatus AND e.startDate > CURDATE() AND e.privacy=1 AND e.subId=su.subId AND " +
            "su.categoryId < 12 AND su.categoryId > 5 AND s.eventId=e.eventId AND s.slotId = i.slotId AND sh.slotHourId = i.slotHourId AND " +
            "e.typeId =t.typeId AND e.churchId =:churchId AND s.conductorId = u.userId AND s.roomId = r.roomId";
    public static final String GET_ON_GOING_PLAN_CLASS = "SELECT distinct e.eventId as eventId, e.eventName as eventName, e.startDate as startDate," +
            " su.subName as subName, su.categoryId as cateId, t.description as typeName, u.userName as conductorName, r.roomName as roomName, " +
            "sh.startTime as startTime, sh.endTime as endTime FROM event e, slot s, inclusion i, slothour sh,subject su, type t, user u, room r " +
            "WHERE e.eventStatus =:eventStatus AND e.startDate < CURDATE() AND e.examDate > CURDATE() AND e.privacy=1 AND e.subId=su.subId AND " +
            "su.categoryId < 12 AND su.categoryId > 5 AND s.eventId=e.eventId AND s.slotId = i.slotId AND sh.slotHourId = i.slotHourId AND " +
            "e.typeId =t.typeId AND e.churchId =:churchId AND s.conductorId = u.userId AND s.roomId = r.roomId";
    public static final String GET_LIST_SUITABLE_CONDUCTOR_ID_FOR_SLOT = "select con.* from ability a, " +
            "(select distinct u.userId from user u, church c," +
            " interaction i where i.churchid =:churchId AND i.userId = u.userId AND u.userId NOT IN (select s2.conductorId " +
            "From (Select s.slotId, s.conductorId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, " +
            "max(sh.endTime) as endTime from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId " +
            "group by s.slotid) s1 where s.slotId = s1.slotId) s2 " +
            "Where (s2.startTime <:newEndTime AND s2.endTime >:newStartTime) AND s2.slotDate =:slotDate AND s2.conductorId IS NOT NULL) ORDER BY userId) con " +
            "WHERE con.userId = a.conductorId AND a.subId=:subId";

    public static final String GET_LIST_SUITABLE_ROOM_ID_FOR_SLOT = "select r.* from roomCapable rc, " +
            "(select r.roomId from roomcapable rc, (select * from room where churchId =:churchId AND roomId NOT IN " +
            "(select s2.roomId From (Select s.slotId, s.roomId, s.slotDate, s1.startTime, s1.endTime from slot s, " +
            "(select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime from slothour sh, inclusion i, slot s " +
            "where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 where s.slotId = s1.slotId) s2 " +
            "Where (s2.startTime <:newEndTime AND s2.endTime >:newStartTime) AND s2.slotDate =:slotDate AND s2.roomId IS NOT NULL) ORDER BY roomId) r " +
            "where r.roomId = rc.roomId AND rc.subId =:subId) r " +
            "WHERE r.roomId = rc.roomId AND rc.subId=:subId";


    public static final String GET_LIST_DISPLAYED_CHURCH = "SELECT s1.*,u.accountId FROM (SELECT c.*, i.userId FROM church c " +
            "LEFT JOIN interaction i ON c.churchId = i.churchId GROUP BY c.churchId) s1 " +
            "LEFT JOIN user u ON s1.userId = u.userId AND u.role ='ROLE_MANAGER' ORDER BY s1.churchId";

    public static final String GET_ALL_PRIEST = "SELECT u.* FROM user u, interaction i WHERE u.userId = i.userId " +
            "AND u.role='ROLE_PRIEST' AND i.churchId =:churchId";


    public static final String GET_LIST_OF_CHURCH_FOLLOWER_ACCOUNT = "select u.accountId from church c, interaction i, user u " +
            "where c.churchId = i.churchId AND u.userId = i.userId AND u.role ='ROLE_USER' AND c.churchId =:churchId AND i.enabled=true";

    public static final String GET_EVENT_REGISTERED_USER_ACCOUNT = "select u.accountId from registration r , user u" +
            " where r.eventId =:eventId AND u.userId = r.userId";

    public static final String GET_CHURCH_MANAGER_ACCOUNT = "select u.accountId from church c , interaction i , user u " +
            "where i.churchId = c.churchId AND i.userId = u.userId and u.role ='ROLE_MANAGER' And c.churchId =:churchId AND i.enabled=true";


    public static final String GET_CATEGORY_ID_FROM_SLOT_ID = "SELECT c.categoryId from slot sl, event e, category c ,subject s " +
            "where sl.eventId = e.eventId AND e.subId = s.subId and s.categoryId = c.categoryId AND sl.slotId =:slotId";

    public static final String GET_LIST_SLOT_OF_CLASS = "SELECT s.* FROM slot s,(SELECT eventId FROM slot WHERE slotId =:slotId) s1 " +
            "WHERE s1.eventId = s.eventId";

    public static final String GET_ALL_ROOM = "SELECT * FROM room r WHERE r.churchId=:churchId";

    public static final String GET_FOLLOWING_CHURCH = "SELECT s.churchId as churchId, s.churchName as churchName ," +
            "s.address as address FROM church s, interaction i WHERE s.churchId=i.churchId AND i.userId =:userId ";

    public static final String GET_CHURCH_INFORMATION = "select c.churchId as churchId,c.churchName as churchName, c.tel as tel, " +
            "c.address as address, c.mail as mail, c.startTime as startTime, c.endTime as endTime, c.image as image, " +
            "c.description as description, m.userId as userId,m.userName as userName, m.certificate as certificate " +
            "from church c, user m, interaction i where m.role='ROLE_MANAGER' AND i.churchId=:churchId AND m.userId = i.userId " +
            "AND c.churchId = i.churchId";

    public static final String GET_INCOMING_EVENT_INFO = "SELECT m1.eventId as eventId,m1.eventName as eventName," +
            "m1.churchId as churchId,m1.churchName as churchName,m1.subId as subId ,m1.subName as subName, " +
            "m2.slotDate as slotDate , m2.startTime as startTime, m2.endTime as endTime " +
            "FROM (select e.eventId, e.eventName, e.churchId, ch.churchName,e.subId, s.subName " +
            "from event e , subject s, category c , church ch where e.eventStatus = 3 AND e.churchId = ch.churchId " +
            "AND e.privacy = 1 AND e.subId = s.subId AND s.categoryId = c.categoryId AND c.categoryId <6 AND c.categoryId != 3) m1," +
            "(Select s.slotId, s.eventId, s.slotDate, s1.startTime, s1.endTime from slot s, (select i.slotId, min(sh.startTime) as startTime, max(sh.endTime) as endTime " +
            "from slothour sh, inclusion i, slot s where i.slotId = s.slotid and sh.slotHourId = i.slotHourId group by s.slotid) s1 " +
            "where s.slotId = s1.slotId and s.slotStatus = 1 group by(s.eventId)) m2, user u, church ch, interaction i " +
            "WHERE m1.eventId = m2.eventId AND m1.churchId= ch.churchId AND ch.churchId = i.churchId AND i.userId = u.userId AND u.userId=:userId";

    public static final String GET_LIST_SLOT_HOUR_BY_TIME = "Select * from slothour Where startTime >=:startTime AND endTime <=:endTime";

}
