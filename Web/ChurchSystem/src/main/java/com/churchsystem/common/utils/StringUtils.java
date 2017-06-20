package com.churchsystem.common.utils;

import com.churchsystem.common.constants.UtilsConstant;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thanh on 16/9/2016.
 */
public class StringUtils {

    public static String generateEncodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static String generateProductImageName() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return dateFormat.format(new Date());
    }

    public static String getExtension(String fileName) {
        return UtilsConstant.DOT + fileName.substring(fileName.lastIndexOf(UtilsConstant.DOT) + 1);
    }

    public static boolean matchPassword(String rawPass, String encodedPass) {
        return new BCryptPasswordEncoder().matches(rawPass, encodedPass);
    }

    public static String[] formatDate(String date){
        String delimeter = UtilsConstant.TIME_DELIMETER;
        String[] result=date.split(delimeter);
        return result;
    }

    public static String formatDateToString(Date date){
        String strDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return strDate;
    }

    public static String convertDateAndTimeToDateTime(Date date,Time time){
        String dateStr=formatDateToString(date);
        String timeStr=time.toString();
        String result=dateStr+"T"+timeStr;
        return result;
    }

}
