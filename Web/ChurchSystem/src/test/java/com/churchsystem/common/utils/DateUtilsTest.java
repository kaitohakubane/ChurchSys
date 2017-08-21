package com.churchsystem.common.utils;

import com.churchsystem.entity.TypeEntity;
import com.churchsystem.service.interfaces.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.text.ParseException;
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

    @Test
    public void getCurrentDate() throws Exception {
    }

    @Test
    public void getCurrentYear() throws Exception {

    }

    @Test
    public void getNDateBeforeDate() throws Exception {

    }

    @Test
    public void getDate() throws Exception {
    }

    @Test
    public void getDate1() throws Exception {
    }

    @Test
    public void getDayOfWeek() throws Exception {
    }

    @Test
    public void nextDayOfWeek() throws Exception {
    }

    @Test
    public void getListOfClassDate() throws Exception {
    }

    @Test
    public void getListOfAdvanceEventDate() throws Exception {
        TypeEntity typeEntity = new TypeEntity();
        System.out.println("Lặp kiểu 2 năm 1 lần vào ngày 2/9, lặp 4 lần ");
        test(typeEntity,4,2,"","2017-09-02",4);

        System.out.println("\nLặp kiểu 2 ngày 1 lần bắt đầu từ vào ngày 2/9, lặp 4 lần ");
        test(typeEntity,1,2,"","2017-09-02",4);

        System.out.println("\nLặp kiểu 2 tháng 1 lần bắt đầu từ vào ngày 2/9, lặp 4 lần ");
        test(typeEntity,3,1,"1","2017-10-03",5);

        System.out.println("\nLặp kiểu thứ bảy đầu tiên của mỗi tháng bắt đầu từ vào ngày 2/9, lặp 4 lần ");
        test(typeEntity, 3, 1, "2", "2017-09-02", 4);

    }

    public static void test(TypeEntity typeEntity, int loopType, int kind, String des, String Date, int num) throws ParseException {
        typeEntity.setLoopType(loopType);
        typeEntity.setKind(kind);
        typeEntity.setDescription(des);
        String date = Date;
        int numOfRepeat = num;
        List<Date> result = DateUtils.getListOfAdvanceEventDate(typeEntity, date, numOfRepeat);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }

    @Test
    public void getListOfIntFromString() throws Exception {
    }

    @Test
    public void parseStringToTime() throws Exception {
    }

    @Test
    public void getEndTimeFromRange() throws Exception {
    }

}