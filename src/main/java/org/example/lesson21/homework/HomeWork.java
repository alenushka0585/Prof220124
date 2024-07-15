package org.example.lesson21.homework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork {
    public static void main(String[] args) {
        //     1. (x) Напишите шаблонную функцию, которая принимает на вход список чего угодно и varargs из целых.
//    Нужно вернуть коллекцию из элементов, номера которых и передаются в виде varargs
//    public static  Collection getElements(List list, int … elements)
//    Например, если в функцию передается список ["Cuba", "Ecuador", "Brazil", "Canada"] и
//    номера 1 и 2, то нужно вернуть коллекцию из ["Ecuador", "Brazil"]
//    На всякий случай, доступ к varargs происходит аналогично элементам массива

        List<String> countries = List.of("Cuba", "Ecuador", "Brazil", "Canada");
        Collection<String> result = getElements(countries, 1, 2);
        System.out.println(result); // [Ecuador, Brazil]


        //    2. Каким днем недели был день возвращения Колумба из его первого плавания в америку?

        LocalDate arrivalOfColumbus = LocalDate.of(1493,03,15);
        System.out.println("День недели возвращения Колумба из его первого плавания в америку: "
                + arrivalOfColumbus.getDayOfWeek());


        //    3. Распечатайте количество секунд, прошедшие между днем взятия Бастилии и полетом в космос Гагарина
//
//
        LocalDateTime stormingOfTheBastille = LocalDateTime.of(1789, 7,14,12, 0);
        LocalDateTime spaceFlightOfGagarin = LocalDateTime.of(1961, 4,12,9, 7);

        System.out.println("Количество секунд между днем взятия Бастилии и полетом Гагарина: " +
                ChronoUnit.SECONDS.between(stormingOfTheBastille,spaceFlightOfGagarin));


        //    4. (xxx) То-же самое с учетом временной зоны (Париж и Байконур) -
//    считать время взятия Бастилии полуднем, время запуска ракеты лучше посмотреть в интернете.

        ZonedDateTime bastilleDay = ZonedDateTime.of(
                1789, 7,14,12, 0,0,0,
                ZoneId.of("Europe/Paris"));

        ZonedDateTime gagarinDay = ZonedDateTime.of(
                1961, 4,12,9, 7,0,0,
                ZoneId.of("Asia/Oral"));

        System.out.println("Количество секунд между днем взятия Бастилии и полетом Гагарина: " +
                ChronoUnit.SECONDS.between(bastilleDay,gagarinDay));
    }


    public static <T> Collection<T> getElements(List<T> list, int... elements) {
        return IntStream.of(elements)
                .filter(index -> index >= 0 && index < list.size()) // Фильтрация для предотвращения IndexOutOfBoundsException
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}
