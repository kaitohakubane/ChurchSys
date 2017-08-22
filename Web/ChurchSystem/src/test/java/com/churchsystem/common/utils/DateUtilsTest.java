package com.churchsystem.common.utils;

import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.TypeEntity;
import com.churchsystem.service.interfaces.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class DateUtilsTest {
    @Autowired
    TypeServiceInterface typeServiceInterface;

    @Autowired
    RoomServiceInterface roomServiceInterface;

    @Autowired
    SubjectServiceInterface subjectServiceInterface;

    @Autowired
    CategoryServiceInterface categoryServiceInterface;

    @Autowired
    RegistrationServiceInterface registrationServiceInterface;

    @Autowired
    EventServiceInterface eventServiceInterface;

    @Autowired
    SlotServiceInterface slotServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    ChurchServiceInterface churchServiceInterface;

    String date = "2005-08-25";


    Time time = new Time(Calendar.getInstance().getTimeInMillis());

    @Test
    public void getCurrentDate() throws Exception {
        Date currentDate = new Date(GregorianCalendar.getInstance().getTimeInMillis());
        assertEquals(currentDate.getTime(), DateUtils.getCurrentDate().getTime(),1000);
    }

    @Test
    public void getCurrentYear() throws Exception {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        assertEquals(year, DateUtils.getCurrentYear());
    }

    @Test
    public void getNDateBeforeDate() throws Exception {
        Calendar cDate = Calendar.getInstance();
        cDate.add(Calendar.DATE, -5);
        Date nDate = new Date(cDate.getTimeInMillis());
        assertEquals(nDate.getTime(), DateUtils.getNDateBeforeDate(5).getTime(), 1000);
    }

    @Test
    public void getDate() throws Exception {
        int intYear = Integer.parseInt("2005");
        int intMonth = Integer.parseInt("8") - UtilsConstant.ONE;
        int intDay = Integer.parseInt("25");
        Calendar calendar = new GregorianCalendar(intYear, intMonth, intDay);
        Date nDate = new Date(calendar.getTimeInMillis());

        assertEquals(nDate, DateUtils.getDate("2005", "8", "25"));
    }

    @Test
    public void getDate1() throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat(UtilsConstant.DEFAULT_DATE_FORMAT);
        java.util.Date utilDate = sdf1.parse(date);
        java.sql.Date result = new Date(utilDate.getTime());
        assertEquals(result, DateUtils.getDate(date));
    }

    @Test
    public void getDayOfWeek() throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat(UtilsConstant.DEFAULT_DATE_FORMAT);
        java.util.Date utilDate = sdf1.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(utilDate);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        assertEquals(dayOfWeek, DateUtils.getDayOfWeek(date));
    }

    @Test
    public void nextDayOfWeek() throws Exception {
        int dow = 0;
        Calendar cal = Calendar.getInstance();
        int diff = dow - cal.get(Calendar.DAY_OF_WEEK);
        if (!(diff > 0)) {
            diff += 7;
        }

        cal.add(Calendar.DATE, diff);
        Date date = new Date(cal.getTimeInMillis());
        assertEquals(date, DateUtils.nextDayOfWeek(dow, cal));
    }

    @Test
    public void getListOfClassDate() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        List<Date> test = test(typeEntity, 1, 2, "", "2017-09-02", 4);
        assertEquals(test.size(), 4);
    }

    @Test
    public void getListOfAdvanceEventDate() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        //System.out.println("Lặp kiểu 2 năm 1 lần vào ngày 2/9, lặp 4 lần ");


        //System.out.println("\nLặp kiểu 2 ngày 1 lần bắt đầu từ vào ngày 2/9, lặp 4 lần ");
        List<Date> test = test(typeEntity, 1, 2, "", "2017-09-02", 4);
        assertEquals(test.size(), 4);
        //System.out.println("\nLặp kiểu 2 tháng 1 lần bắt đầu từ vào ngày 2/9, lặp 4 lần ");
        test(typeEntity, 3, 1, "1", "2017-10-03", 5);

        //System.out.println("\nLặp kiểu thứ bảy đầu tiên của mỗi tháng bắt đầu từ vào ngày 2/9, lặp 4 lần ");
        test(typeEntity, 3, 1, "2", "2017-09-02", 4);

    }

    public static List<Date> test(TypeEntity typeEntity, int loopType, int kind, String des, String Date, int num) throws ParseException {
        typeEntity.setLoopType(loopType);
        typeEntity.setKind(kind);
        typeEntity.setDescription(des);
        String date = Date;
        int numOfRepeat = num;
        List<Date> result = DateUtils.getListOfAdvanceEventDate(typeEntity, date, numOfRepeat);
        return result;
    }

    @Test
    public void getListOfIntFromString() throws Exception {
    }

    @Test
    public void parseStringToTime() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        java.util.Date test = Calendar.getInstance().getTime();
        long ms = test.getTime();
        Time t = new Time(ms);
        assertEquals(t.getTime(), time.getTime(),1000);
    }

    @Test
    public void getEndTimeFromRange() throws Exception {
        String startTimeStr = time.toString();
        String hour = startTimeStr.split(UtilsConstant.TIME_DELIMETER)[UtilsConstant.ZERO];
        Integer intVal = Integer.parseInt(hour);
        intVal = intVal + 2;
        String resultString = intVal.toString();
        if (intVal < UtilsConstant.TEN) {
            resultString = "0" + resultString;
        }


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startTimeStr);
        stringBuilder.replace(UtilsConstant.ZERO, UtilsConstant.TWO, resultString);
        Time endTime = DateUtils.parseStringToTime(stringBuilder.toString());
        assertEquals(endTime, DateUtils.getEndTimeFromRange(time, 2));
    }

}