package org.example.lesson21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarTester {
    public static void main(String[] args) throws ParseException {
        //текущая дата
        Calendar calendar = Calendar.getInstance();
        System.out.println("now: " + calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH,2);
        calendar.add(Calendar.MONTH, 3);// добавдение месяца
        System.out.println("2 число текущего месяца: " + calendar.getTime());

        Calendar july4 = new GregorianCalendar(1975, Calendar.JULY, 4);

        //https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2024-07-10 20:29:33
        System.out.println(format.format(calendar.getTime()));

        Date nov10 = format.parse("1975-11-10 19:22:33"); // через форматер передать дату
        System.out.println(nov10);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss MMMM EEEE", Locale.GERMANY);
        System.out.println(format1.format(calendar.getTime()));
    }
}
