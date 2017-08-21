package com.churchsystem.common.utils;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.TypeEntity;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Hung on 11/22/2016.
 */
public class DateUtils {
    public static Date getCurrentDate() {
        Date currentDate = new Date(GregorianCalendar.getInstance().getTimeInMillis());
        return currentDate;
    }

    public static int getCurrentYear() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        return year;
    }

    public static Date getNDateBeforeDate(int n) {
        Calendar cDate = GregorianCalendar.getInstance();
        cDate.add(Calendar.DATE, -n);
        Date nDate = new Date(cDate.getTimeInMillis());
        return nDate;
    }

    public static Date getDate(String year, String month, String day) {
        try {
            int intYear = Integer.parseInt(year);
            int intMonth = Integer.parseInt(month) - UtilsConstant.ONE;
            int intDay = Integer.parseInt(day);
            Calendar calendar = new GregorianCalendar(intYear, intMonth, intDay);
            Date nDate = new Date(calendar.getTimeInMillis());
            return nDate;
        } catch (NumberFormatException e) {
            return getCurrentDate();
        }
    }

    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat(UtilsConstant.DEFAULT_DATE_FORMAT);
        java.util.Date utilDate = sdf1.parse(date);
        java.sql.Date result = new Date(utilDate.getTime());
        return result;
    }

    public static int getDayOfWeek(String date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat(UtilsConstant.DEFAULT_DATE_FORMAT);
        java.util.Date utilDate = sdf1.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(utilDate);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public static Date nextDayOfWeek(int dow, Calendar cal) {
        int diff = dow - cal.get(Calendar.DAY_OF_WEEK);
        if (!(diff > 0)) {
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
        List<Integer> arrayOfDate = getListOfIntFromString(arrayOfDay, UtilsConstant.DEFAULT_DELIMETER);

        //Get most recent date;
        int min = UtilsConstant.WEEK_DAY;
        int recent = 0;
        for (int k = 0; k < arrayOfDate.size(); k++) {
            int item = arrayOfDate.get(k) - cal.get(Calendar.DAY_OF_WEEK);
            if (item >= 0 && item < min) {
                min = item;
                recent = k;
            }
        }

        int sizeOfPlus = recent;
        int dif = (arrayOfDate.get(recent % arrayOfDate.size()) - cal.get(Calendar.DAY_OF_WEEK));
        if (dif == 0) {
            Date item = new Date(cal.getTimeInMillis());
            result.add(item);
            recent++;
        }


        for (int i = recent; i < numberOfSlot + sizeOfPlus; i++) {
            int k = i % arrayOfDate.size();
            Date item = nextDayOfWeek(arrayOfDate.get(k), cal);
            result.add(item);
        }
        return result;
    }


    public static List<Date> getListOfAdvanceEventDate(TypeEntity typeEntity, String date, int numOfRepeat) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date selectedDate = sdf1.parse(date);

        List<Date> result = new ArrayList<Date>();
        Date curDate = DateUtils.getDate(date);
        result.add(curDate);

        Calendar tempDate = Calendar.getInstance();

        if (typeEntity.getLoopType() == ParamConstant.TYPE_DAYS) {
            for (int i = 0; i < numOfRepeat - 1; i++) {
                DateUtils.getList(tempDate, result, Calendar.DATE, selectedDate, typeEntity.getKind());
            }
        }
        if (typeEntity.getLoopType() == ParamConstant.TYPE_MONTHS) {
            if (typeEntity.getDescription().equals(ParamConstant.TYPE_MONTHS_DAY_OF_MONTH)) {
                for (int i = 0; i < numOfRepeat - 1; i++) {
                    DateUtils.getList(tempDate, result, Calendar.MONTH, selectedDate, typeEntity.getKind());
                }
            }
            if (typeEntity.getDescription().equals(ParamConstant.TYPE_MONTHS_DAY_OF_WEEK)) {
                tempDate.setTime(selectedDate);
                int dayOfWeekInMonth = tempDate.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                int dayOfWeeks = tempDate.get(Calendar.DAY_OF_WEEK);

                for (int i = 0; i < numOfRepeat - 1; i++) {
                    tempDate.add(Calendar.MONTH, typeEntity.getKind());
                    tempDate.set(Calendar.DAY_OF_WEEK_IN_MONTH,dayOfWeekInMonth);
                    tempDate.set(Calendar.DAY_OF_WEEK,dayOfWeeks);

                    Date newDate = new Date(tempDate.getTime().getTime());
                    newDate.setTime(tempDate.getTimeInMillis());
                    selectedDate.setTime(tempDate.getTimeInMillis());
                    result.add(newDate);
                }
            }
        }
        if (typeEntity.getLoopType() == ParamConstant.TYPE_YEARS) {
            for (int i = 0; i < numOfRepeat - 1; i++) {
                DateUtils.getList(tempDate, result, Calendar.YEAR, selectedDate, typeEntity.getKind());
            }
        }
        return result;
    }

    public static List<Date> getList(Calendar tempDate, List<Date> result, int type, java.util.Date selectedDate, int kind) {

        tempDate.setTime(selectedDate);
        tempDate.add(type, kind);
//    tempDate.add(Calendar.DATE, typeEntity.getKind());
        Date newDate = new Date(tempDate.getTime().getTime());
        newDate.setTime(tempDate.getTimeInMillis());
        selectedDate.setTime(tempDate.getTimeInMillis());
        result.add(newDate);
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

    public static Time parseStringToTime(String string) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        long ms = simpleDateFormat.parse(string).getTime();
        Time t = new Time(ms);
        return t;
    }

    public static Time getEndTimeFromRange(Time startTime, int range) throws ParseException {
        String startTimeStr = startTime.toString();
        String hour = startTimeStr.split(UtilsConstant.TIME_DELIMETER)[UtilsConstant.ZERO];
        Integer intVal = Integer.parseInt(hour);
        intVal = intVal + range;
        String resultString = intVal.toString();
        if (intVal < UtilsConstant.TEN) {
            resultString = "0" + resultString;
        }


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startTimeStr);
        stringBuilder.replace(UtilsConstant.ZERO, UtilsConstant.TWO, resultString);
        Time endTime = parseStringToTime(stringBuilder.toString());
        return endTime;
    }


}
