package org.example.lesson21;

import java.util.Date;
import java.util.Locale;

public class DateTester {
    public static void main(String[] args) {
        Date currentDate = new Date(); //текущая дата
        System.out.println(currentDate);

        // 1 января 1970 - Эпоха

        Date oldDate = new Date(1234567890L);
        System.out.println("old date: " + oldDate);

        System.out.println("old date is before current"
        + oldDate.before(currentDate));

        //год отсчитывается с 1900
        // мясяцы считаются с нуля
        Date nov10y2005 = new Date(105,10,10);
        System.out.println("nov 10 2005 " + nov10y2005);

        //https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html

        System.out.printf("%tY-%tm-%td\n", currentDate,currentDate,currentDate);

        Locale fr = new Locale("fr", "CA"); // Locale.CANADA_FRENCH;
        System.out.printf(fr, "%tc", currentDate);
    }
}
