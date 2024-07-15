package org.example.lesson21;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

public class ZoneDateTimeTester {
    public static void main(String[] args) {
        ZonedDateTime t = ZonedDateTime.parse(
                "2022-12-20T00:35:47.023323700+02:00[Europe/Helsinki]");

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.of(date, time, zoneId);


        //имеющиеся временные зоны
        System.out.println(
                ZoneId.getAvailableZoneIds()
        );

        System.out.println(
                t.toInstant().atZone(ZoneId.of("Asia/Almaty"))
        );

        ZonedDateTime sep14 = ZonedDateTime.of(
                2015, 9, 14,
                0, 0, 0, 0, ZoneId.of("Europe/Moscow"));

        System.out.println(sep14);

        System.out.println(sep14.getDayOfWeek());

        System.out.println(
                zdt.toInstant()
                        .atZone(
                                ZoneId.of("Asia/Tokyo")));

        System.out.println(zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
