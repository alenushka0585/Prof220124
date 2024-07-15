package org.example.lesson21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class LocalDateTester {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("year: " + now.getYear() + " " + now.isLeapYear());

        LocalDate test = now
                .plusDays(5)
                .with(ChronoField.DAY_OF_WEEK, 4);

        System.out.println(test);
        System.out.println(
                test.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd"))
        );


        // LocalDateTime - не прогадаете, если будете использовать

        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime change = ldt
                .plusYears(2)
                .minusHours(12)
                .plusMinutes(5);

        System.out.println(
                change.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        );

    }
}
