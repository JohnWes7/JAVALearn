package Lesson._41Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        // test1();
        // test2();
        testC();
    }

    public static void test1() {
        long now = System.currentTimeMillis();
        System.out.println(now);

        Date d = new Date();
        Date d2 = new Date(0);
        System.out.println(d);
        System.out.println(d2);
        System.out.println(d.getTime());

        Date d3 = new Date(1000L * 24 * 365 * 60 * 60 * 150);
        System.out.println(d3);
    }

    // 测试dateformat 时间和字符串之间的转换
    public static void test2() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d2 = new Date();
        System.out.println(df.format(d2));

        String str = "2077-10-1 10:10:20";
        Date d3 = df.parse(str);
        System.out.println(d3);
        System.out.println(d3.getTime());

        // DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");

        // 获取当前时间时今年的第几天
        DateFormat df3 = new SimpleDateFormat("D");
        System.out.println(df3.format(new Date()));
    }

    public static void testC() {
        // 月份 默认从0~11 0:1月 1:2月 11:12月
        Calendar calendar = new GregorianCalendar(2999, 9, 10, 11, 40, 40);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        System.out.println(year + ":" + month);

        // set
        calendar.set(Calendar.YEAR, 2077);
        System.out.println(calendar.get(Calendar.YEAR));

        // get
        System.out.println(calendar.getTime()); // 返回一个Date
        System.out.println(calendar.getTimeInMillis()); // 返回毫秒数

        //日期的计算
        calendar.add(Calendar.DATE, 1000);
        System.out.println(calendar);
    }
}
