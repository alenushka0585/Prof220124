package org.example.lesson9.homework9;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
//        Напишите класс который считывает вводимые пользователем строки
//        с консоли до того момента как встретится строка quit
//        После этого все до введенные ранее строки нужно распечатать
//        в обратном порядке.
//        Например:
//        one
//        two
//        three
//        quit
//->
//        three
//        two
//        one

        Stack<String> strings = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Enter a word!");

        while (!input.equals("quit")) {
            input = scanner.nextLine();
            strings.push(input);
        }

        while (!strings.isEmpty()) {
            System.out.println(strings.pop());
        }


//        ** 2. Напишите метод, который принимает на вход список целых
//        и число k
//        Метод должен возвратить список, в котором первые k чисел поменялись
//        местами и должны находится в обратном порядке
//        Например: [10, 20, 30, 40, 50], 4 -> [40, 30, 20, 10, 50]
//        Желательно сделать с помощью стэков/очередей

        List<Integer> list = new ArrayList<>(
                Arrays.asList(10, 20, 30 ,40 ,50)
        );

        System.out.println(getReverse(list, 4));

    }

    public static List<Integer> getReverse(List<Integer> list, int k) {
        if (list == null || list.isEmpty() || k > list.size() || k <=0) {
            throw new IllegalArgumentException("Invalid list or k");
        }
        List<Integer> result = new ArrayList<>(list);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(list.get(i));
        }

        for (int i = 0; i < k; i++){
            result.set(i, stack.pop());
        }

        return result;
    }
}
