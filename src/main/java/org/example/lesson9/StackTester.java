package org.example.lesson9;

import java.util.Arrays;
import java.util.Stack;

public class StackTester {
    // добавление и получение элемента с одной стороны
    // LIFO Last-In First-Out
    // T push(T) // добавление элемента вверх стэка
    // P pop() //удаляет элемент с вершины и возвращает его EmptyStackException
    // T peek() // возвращает верхний элемент стэка но не удаляет его EmptyStackException
    // boolean empty() // пустой или нет

    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("Dima");
        names.push("Max");
        names.push("Darya");

        System.out.println(names);
        System.out.println(names.size());

        System.out.println("peek: " + names.peek());
        System.out.println("size after peek: " + names.size());

        System.out.println("pop: " + names.pop());
        System.out.println("size after poop: " + names.size());
        System.out.println(names);

        System.out.println("Max position: " + names.search("Max"));

        String phrase = "однажды в студенную зимнюю пору я из лесу вышел";

        System.out.println(backwartOrder(phrase));

        while (!names.empty())
            System.out.println("name: " + names.pop());

        Stack<String> words = new Stack<>();
        words.addAll(
                Arrays.asList(
                        phrase.split(" ")
                )
        );
        while (!words.empty())
            System.out.print(words.pop() + " ");



    }

    public static Stack<String> backwartOrder(String s) {
        String[] strings = s.split(" ");
        Stack<String> result = new Stack<>();
        for (int i = strings.length - 1; i >= 0; i--) {
            result.push(strings[i]);
        }
        return result;
    }
}

