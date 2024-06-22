package org.example.lesson15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        //flatMap - flattering - уплощение + mapping - трансформирует
        //filter(Predicate) - пропускает от 0 до N элементов
        //map(Function) - пропускает все элементы 1:1
        //flatMap - на базе каждого элемента создает от 0 до ... новых элементов
        // все элементы последовотельно будут вывовдиться в поток

        Integer[][] twoDimensijbnalArray = {
                {1, 2, 3},
                {4},
                {5, 6, 7, 8},
                {9, 10}
        };

        Arrays.stream(twoDimensijbnalArray)
                .forEach(array -> System.out.println(Arrays.toString(array)));
        // element -> stream(...)

        System.out.println(Arrays.stream(twoDimensijbnalArray)
                .flatMap(array -> Arrays.stream(array) )
                .toList());


        List<List<String>> names = List.of(
                List.of("Masha", "Alexander"),
                List.of("Sveta", "Vlad", "Alice", "Xenia")
        );


        System.out.println(
                names.stream()
                        .flatMap(a -> a.stream())
                        .toList()
        );

        System.out.println(
                names.stream()
                        .flatMap(a -> a.stream())
                        .flatMap(w -> Arrays.stream(w.split("")))
                        .toList()
        );


        System.out.println(
                names.stream()
                        .flatMap(s -> s.stream())
                        .flatMap(s -> Stream.of(s, s.toUpperCase()))
                        .toList()
        );


        System.out.println(
                names.stream()
                        .flatMap(s -> s.stream().map(a -> a.length()))
                        .toList()
        );

        Order grocery = new Order(
                new OrderItem("mango", 2,1.6),
                new OrderItem("apples", 3, 0.99),
                new OrderItem("sprite", 1, 1.5)
        );

        Order utility = new Order(new OrderItem("water", 104, 0.3),
                new OrderItem("electricity", 201, 0.38));


        List<Order> orders = List.of(grocery, utility);

        System.out.println(
                orders.stream()
                        .flatMap(order -> order.getItems().stream())
                        .mapToDouble(item -> item.getUnitPrice() * item.getQuantity())
                        .sum()
        );



    }
}
