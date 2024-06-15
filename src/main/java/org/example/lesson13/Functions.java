package org.example.lesson13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {
    public static void main(String[] args) {
        //Function - преобразовывает элемент одного типа в элемент другого типа
//        Function<String, Integer> stringLength = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
        // Function<String, Integer> stringLength = s -> s.length();
        Function<String, Integer> stringLength = String::length;

        List<String> names = List.of("John", "Max", "Alexander", "Vasilisa");

        System.out.println(names.stream().map(stringLength).toList());

        Map<String, Integer> nameLength = new HashMap<>();
        names.stream()
                .map(name -> nameLength.computeIfAbsent(name, stringLength))
                .toList();

        System.out.println(nameLength);

        BiFunction<Double, Double, Double> add = (aDouble, aDouble2) -> aDouble + aDouble2;

        Function<Integer, Double> square = integer -> 1.0 * integer * integer;

        // stringLength.andThen(square); подключения еще одного фанкшн в конец
//        square.compose(stringLength); тоже самое, но другой синтаксис

    }
}
