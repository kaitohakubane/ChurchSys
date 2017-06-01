package com.churchsystem.common.constants;

/**
 * Created by Hung on 11/18/2016.
 */
public class SQLParamConstant {
    public static final String GET_REGISTRATION = "SELECT a.regisId as regisId,a.username as username," +
            "a.subId as subId, b.subName as subName,a.regisDate as regisDate,a.estTime as estTime," +
            " a.message as message,c.categoryName as categoryName" +
            "FROM registration a,subject b,category c " +
            "WHERE a.subId=b.subId AND b.categoryId=c.categoryId";


}
