package org.example.algoritms.hw6;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {

//        Level 1
//        Последовательность ([{}]) является правильной,
//        а последовательности ([)], {()] правильными не являются.
//        Докажите это используя стек!
        String[] testStrings = {"([{}])", "([)]", "{()]", "()", "[]{}", "{[()]}"};

        for (String s : testStrings) {
            System.out.println(s + " is " + (isValid(s) ? "valid" : "invalid"));
        }

//        Level 2
//        Дан односвязный список. Написать функцию или блок схему, определяющую,
//        образуют ли его элементы симметричную последовательность.
//        Для решения задачи использовать стек и очередь. Функция будет возвращать значение true,
//        если список является симметричным, false – в противном случае.
//        По определению пустой список является симметричным. Поэтому, если список пуст,
//        то возвращаем значение true. Для проверки симметричности списка нужно проверить на равенство
//        все пары элементов, равноотстоящих от середины списка. Каждая пара содержит один элемент
//        из первой половины списка и один – из второй. Элементы первой половины списка последовательно
//        заносятся в очередь, второй половины в стек. Если количество элементов списка будет нечетным,
//        то серединный элемент будет симметричен сам себе и не будет помещен ни в очередь, ни в стек.

        List<Character> list = new ArrayList<>(
                List.of('0','1','2','3','3','2','1','0')
        );

        List<Character> list1 = new ArrayList<>(
                List.of('0','1','2','3','4','3','2','1','0')
        );

        List<Character> list2 = new ArrayList<>(
                List.of('0','1','2','3','4','0','1','2','3')
        );
        List<Character> list3 = new ArrayList<>(
                List.of('0','1','2','3','0','1','2','3')
        );

        System.out.println(list + " is " + (isSymmetric(list) ? "symmetric" : "asymmetric"));
        System.out.println(list1 + " is " + (isSymmetric(list1) ? "symmetric" : "asymmetric"));
        System.out.println(list2 + " is " + (isSymmetric(list2) ? "symmetric" : "asymmetric"));
        System.out.println(list3 + " is " + (isSymmetric(list3) ? "symmetric" : "asymmetric"));

    }

    // Метод для проверки правильности скобок в строке
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Если открывающая скобка, добавляем ее в стек
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Если закрывающая скобка, проверяем стек
            else if (c == ')' || c == '}' || c == ']') {
                // Если стек пустой или верхняя скобка не соответствует текущей закрывающей, строка неправильная
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        // Если после обработки строки стек пустой, строка правильная
        return stack.isEmpty();
    }

    // Метод для проверки, соответствуют ли открывающая и закрывающая скобки
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static boolean isSymmetric(List<Character> list) {
        // пустой список является симметричным
        if (list == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        int size = list.size() / 2;
        // Элементы первой половины списка последовательно заносятся в очередь, второй половины в стек
        if (list.size() % 2 == 0) {
            for (int i = 0; i < size; i++) {
                queue.add(list.get(i));
                stack.push(list.get(i + size));
            }

        } else {
            for (int i = 0; i < size; i++) {
                queue.add(list.get(i));
                stack.push(list.get(i + size + 1));
            }
        }

        // проверка на равенство все пары элементов, равноотстоящих от середины списка.
        for (int i = 0; i < size; i++) {
            if (queue.peek().equals(stack.peek())) {
                queue.poll();
                stack.pop();
            }
        }

        return stack.empty() && queue.isEmpty();
    }
}
