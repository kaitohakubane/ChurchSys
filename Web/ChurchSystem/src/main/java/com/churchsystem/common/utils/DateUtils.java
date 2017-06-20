package com.churchsystem.common.utils;

import com.churchsystem.common.constants.UtilsConstant;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Hung on 11/22/2016.
 */
public class DateUtils {
    public static Date getCurrentDate(){
        Date currentDate = new Date(GregorianCalendar.getInstance().getTimeInMillis());
        return currentDate;
    }

    public static int getCurrentYear(){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        return year;
    }

    public static Date getNDateBeforeDate(int n){
        Calendar cDate=GregorianCalendar.getInstance();
        cDate.add(Calendar.DATE,-n);
        Date nDate=new Date(cDate.getTimeInMillis());
        return nDate;
    }

    public static Date getDate(String year,String month,String day){
        try{
            int intYear=Integer.parseInt(year);
            int intMonth=Integer.parseInt(month)- UtilsConstant.ONE;
            int intDay=Integer.parseInt(day);
            Calendar calendar = new GregorianCalendar(intYear,intMonth,intDay);
            Date nDate=new Date(calendar.getTimeInMillis());
            return nDate;
        }
        catch(NumberFormatException e){
            return getCurrentDate();
        }
    }

    public static Date getDate(String date) throws ParseException{
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate= sdf1.parse(date);
        java.sql.Date result=new Date(utilDate.getTime());
        return result;
    }

}