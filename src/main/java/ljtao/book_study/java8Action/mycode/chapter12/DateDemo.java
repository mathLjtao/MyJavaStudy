package ljtao.book_study.java8Action.mycode.chapter12;

import org.junit.Test;

import java.time.*;
import java.util.stream.Stream;

/**
 * @author ljtao3 on 2020/4/14
 */
public class DateDemo {
    public static void main(String[] args) {

    }
    //LocalDate test
    @Test
    public void fun1(){
        LocalDate date=LocalDate.of(2020,4,14);
        int year = date.getYear();//2019
        System.out.println(year);
        Month month = date.getMonth();//APRIL
        System.out.println(month);
        int dayOfMonth = date.getDayOfMonth();//14
        System.out.println(dayOfMonth);
        int value = date.getDayOfWeek().getValue();//2
        System.out.println(value);
        int i = date.lengthOfMonth();//30
        System.out.println(i);
        boolean leapYear = date.isLeapYear();//true
        System.out.println(leapYear);

        LocalDate now = LocalDate.now();//获取当天日期 2020-04-14
        System.out.println(now);
    }
    //LocalTime
    @Test
    public void fun2(){
        LocalTime time=LocalTime.of(10,20,30);
        time.getHour();
        time.getMinute();
        time.getSecond();
    }
    //LocalDateTime 合并日期和时间
    @Test
    public void fun3(){
        LocalDateTime dateTime=LocalDateTime.of(2020,4,14,10,20,30);
        LocalDate date=LocalDate.of(2020,4,14);
        LocalTime time=LocalTime.of(10,20,30);
        LocalDateTime dt1 = date.atTime(time);//日期加上时间
        LocalDateTime dt2 = time.atDate(date);//时间加上日期
        dateTime.toLocalDate();//转日期
        dateTime.toLocalTime();//转时间

        System.out.println(dateTime);//2020-04-14T10:20:30
        System.out.println(dt1);    //2020-04-14T10:20:30

    }


}
