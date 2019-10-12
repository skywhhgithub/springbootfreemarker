package com.sky;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2019-10-10 09:03:55.033");
        Date date2 = format2.parse("2019-10-10 09:03:55");
        System.out.println(String.valueOf(date.getTime()));
        System.out.println(String.valueOf(date2.getTime()));

    }
}
