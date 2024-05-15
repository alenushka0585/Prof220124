package org.example.lesson3.homework3;

import javax.swing.*;

public class Date {
    private int year;
    private Month month;
    private int day;

    public Date(int year, Month month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean isLeapYear(int year){
        if (year%400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year %4==0;
    }

    public void add(int days) {
        int daysInMonth;

        if (month.ordinal() == 1 && isLeapYear(year)) {
            daysInMonth = 29;
        } else {
            daysInMonth = month.getDays();
        }
        day += days;

        while (day > daysInMonth) {

            day -= daysInMonth;

            int currentMonth = month.ordinal();

            if (currentMonth == 11) {
                month = Month.values()[0];
            } else {
                month = Month.values()[currentMonth + 1];
            }

            if (month == Month.JANUARY) {
                year++;
            }

            if (month.ordinal() == 1 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                daysInMonth = 29;
            } else {
                daysInMonth = month.getDays();
            }
        }
    }

    @Override
    public String toString() {
        return day + " " + month + " " + year;
    }
}
