package org.example.lesson19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>(
                List.of(3.14, 33)
        );

        numberList.add(-1);
        numberList.add(-33.22);

        //  Double d = numberList.get(0); не будет работать, так как храняться Number

        printListOfNumbers(numberList);

        List<Double> doubleList = new ArrayList<>(
                List.of(3.14, 33.55, 1.2)
        );

        printListOfNumbers(doubleList);

        List<Integer> integerList = new ArrayList<>(
                List.of(1, 2, 3)
        );

        addNumber(integerList);
        addNumber(numberList);

    }


    //"Контракт" - мы не будем пытаться ничего писать в список
    // а будем только доставать из него элементы
    // Consumer - "потребитель" ? extends Number
    public static void printListOfNumbers(List<? extends Number> numbers) {
        numbers.forEach(
                n -> System.out.println("number is: " + n)
        );

//        numbers.add(33);
//        numbers.add(33.444);
    }

    //  "Контракт" - мы не будем пытаться оттуда ничего читать, а будем
    // только записывать
// Producer - "производитель" - ? super Integer
    public static void addNumber(List<? super Integer> integers) {
        integers.add(new Random().nextInt());
        System.out.println(integers.get(0));
    }
}
