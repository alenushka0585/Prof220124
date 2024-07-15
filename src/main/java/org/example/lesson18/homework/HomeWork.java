package org.example.lesson18.homework;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork {
    public static void main(String[] args) {
        //    1. Дана строка "michael;levanov|34|34000"
        //    Разбейте ее по резделителям (;|) и распечатайте составные части

        String s1 = "michael;levanov|34|34000";
        System.out.println(Arrays.toString(s1.split("[;|]")));

        //    2. В строке "Today's temperature is 18 degrees centigrade, yesterday it was 14"
        //    Замените все чиcла на 21 и замените centi на multi

        String s2 = "Today's temperature is 18 degrees centigrade, yesterday it was 14";
        System.out.println(s2
                .replaceAll("\\d+", "21")
                .replaceAll("centi", "multi"));

        System.out.println("Password123! " + isGoodPassword("Password123!"));
        System.out.println("Pass! " + isGoodPassword("Pass!"));
        System.out.println("Password123 " + isGoodPassword("Password123"));
        System.out.println("Password! " + isGoodPassword("Password!"));


        System.out.println("29 feb 2001 " + isDate("29 feb 2001")); // true
        System.out.println("5 feb 1999 " + isDate("5 feb 1999")); // true
        System.out.println("29 feb 2000 " + isDate("29 feb 2000")); // true
        System.out.println("31 apr 2020 " + isDate("31 apr 2020")); // false (апрель имеет только 30 дней)
        System.out.println("29 feb 2020 " + isDate("29 feb 2020")); // false (февраль имеет максимум 29 дней)
        System.out.println("32 jan 2020 " + isDate("32 jan 2020")); // false (нет 32-го дня)
        System.out.println("24 jan2001 " + isDate("24 jan2001")); // false (нет пробела)
        System.out.println("24 januar 2001 " + isDate("24 januar 2001")); // false (неверный формат месяца)


        String htmlLink1 = "<a href=\"https://www.google.com\">Example</a>";
        String htmlLink2 = "<a href='https://www.google.com'>Example</a>";
        String htmlLink3 = "<a href=https://www.google.com>Example</a>";

        System.out.println(extractUrlFromLink(htmlLink1));
        System.out.println(extractUrlFromLink(htmlLink2));
        System.out.println(extractUrlFromLink(htmlLink3));

    }

//    3. Напишите метод isGoodPassword(String) проверяющий пароль на "хорошесть"
//    Хороший пароль длиной не менее 8 символов,
//    содержит как минимум одну цифру
//    и как минимум один знак из набора !@%#^&$|
//    В методе можно написать несколько проверок

    public static boolean isGoodPassword(String password) {
        if(password == null || password.length() < 8)
            return false;
        return password.matches(".*[0-9].*") && password.matches("[!@%#^&$|]");
    }

//    4. Напишите метод isDate(String) который проверит, что передаваемая строка является датой
//    Дата выглядит как "24 jan 2001" - день месяца, месяц и год
//    Месяцы могут быть только jan, feb, mar и тп
//    5.(xx) То же что и в пункте 4, но еще и с учетом високосности и правильного количества дней в месяцах

    public static boolean isDate(String date) {
        String regex = "^([0-2]?[0-9]|3[01]) (jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec) \\d{4}$";
        if (!date.matches(regex)) {
            return false;
        }
        String[] parts = date.split(" ");
        int day = Integer.parseInt(parts[0]);
        String month = parts[1];
        int year = Integer.parseInt(parts[2]);

        return isValidDayForMonth(day, month, year);
    }

    private static boolean isValidDayForMonth(int day, String month, int year) {
        switch (month) {
            case "jan":
            case "mar":
            case "may":
            case "jul":
            case "aug":
            case "oct":
            case "dec":
                return day <= 31;
            case "apr":
            case "jun":
            case "sep":
            case "nov":
                return day <= 30;
            case "feb":
                if (isLeapYear(year)) {
                    return day <= 29;
                } else {
                    return day <= 28;
                }
            default:
                return false;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year%400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year %4==0;
    }


//    6.(xxx) Напишите метод extractUrlFromLink(String) выкусывающий url из ссылки html

    public static String extractUrlFromLink(String link) {
        String regex = "<a\\s+href\\s*=\\s*['\"]?(https?://[^'\">\\s]+)['\"]?[^>]*>";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(link);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
