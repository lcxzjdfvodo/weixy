package com.eight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args)throws ParseException {

        //把时间对象按照“格式字符串制定的格式”转成相应的字符串
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str=df.format(new Date(40000000));
        System.out.println(str);

        //把字符串按照“格式字符串指定的格式”转成相应的时间对象
        DateFormat df2=new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
         Date date=df2.parse("1983年7月12日14时25分1秒");
         System.out.println(date);


    }
}
