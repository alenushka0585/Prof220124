package org.example.lesson3;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekDay() {
        return ordinal() < 5;
    }

    public boolean isWeekEnd() {
        return !isWeekDay();
    }
}
