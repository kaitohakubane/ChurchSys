package com.churchsystem.common.utils;

import com.churchsystem.common.constants.UtilsConstant;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat(UtilsConstant.DEFAULT_DATE_FORMAT);
            java.util.Date utilDate= sdf1.parse(date);
            java.sql.Date result=new Date(utilDate.getTime());
            return result;
    }

    public static int getDayOfWeek(String date )throws ParseException {

            SimpleDateFormat sdf1 = new SimpleDateFormat(UtilsConstant.DEFAULT_DATE_FORMAT);
            java.util.Date utilDate= sdf1.parse(date);
            Calendar cal=Calendar.getInstance();
            cal.setTime(utilDate);
            int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
            return dayOfWeek;
    }

    public static Date nextDayOfWeek(int dow, Calendar cal) {
        int diff = dow - cal.get(Calendar.DAY_OF_WEEK);
        if (!(diff >= 0)) {
            diff += 7;
        }

        cal.add(Calendar.DATE, diff);
        Date date = new Date(cal.getTimeInMillis());
        return date;
    }

    public static List<Date> getListOfClassDate(String arrayOfDay, String date, int numberOfSlot) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf1.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(utilDate);
        List<Date> result = new ArrayList<Date>();
        List<Integer> arrayOfDate = getListOfIntFromString(arrayOfDay, ";");

        //Get most recent date;
        int min=UtilsConstant.WEEK_DAY;
        int recent=0;
        for(int k=0;k<arrayOfDate.size();k++){
            int item=arrayOfDate.get(k)-cal.get(Calendar.DAY_OF_WEEK);
            if(item>=0&&item<min){
                min=item;
                recent=k;
            }
        }


        for (int i = recent; i < numberOfSlot+recent; i++) {
            int k=i%arrayOfDate.size();
            Date item = nextDayOfWeek(arrayOfDate.get(k), cal);
            result.add(item);

        }
        return result;
    }

    public static List<Integer> getListOfIntFromString(String strArray, String delimeter) {
        List<String> arrayOfDayString = new ArrayList<String>(Arrays.asList(strArray.split(delimeter)));
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < arrayOfDayString.size(); i++) {
            Integer item = Integer.parseInt(arrayOfDayString.get(i));
            result.add(item);
        }
        return result;
    }


}
