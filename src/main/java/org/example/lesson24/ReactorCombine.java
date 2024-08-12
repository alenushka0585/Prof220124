package org.example.lesson24;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

public class ReactorCombine {
    public static void main(String[] args) {
        List<String> names = List.of("Max", "Olga");
        List<Integer> ages = List.of(27,25);

        Flux<String> flux = Flux.fromIterable(names);
        flux.flatMap(s -> Flux.fromArray(s.split("")))
                .subscribe(l -> System.out.println("letter: " + l));

        //для вызова rest сервиса или блоктрующей функции в потоке правильно
        //использовать flatMap

        Flux.fromIterable(names)
                .flatMap(s -> Mono.fromCallable(() -> s.toUpperCase()))
                .flatMap(s -> Mono.fromCallable(() -> getLength(s)))
                .subscribe(r -> System.out.println(r))
        ;

        // параллельный вызов Flux/Mono
        Flux.zip(
                Flux.fromIterable(names),
                Flux.fromIterable(ages),
                (s, i) -> s +"|" + i)
                .subscribe(
                        s -> System.out.println("zip: " +s)
                )
        ;


        // names преобразовать в пары из ИМЯ:длина
        Flux.fromIterable(names)
                .flatMap(
                        w -> Flux.zip(
                                Mono.fromCallable(() -> toUpper(w))
                                        .subscribeOn(Schedulers.parallel()),
                                Mono.fromCallable(() -> getLength(w))
                                        .subscribeOn(Schedulers.parallel())
                                ,
                                (s, i) -> s + "|" + i
                        )
                )
                .subscribe(
                        // по-умолчанию все шаги потока обрабатываются в том thread-е в
                        // котором произошел subscribe
                        s -> System.out.println("zip: " + s)
                );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getLength(String s){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return s.length();
    }

    public static String toUpper(String s){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return s.toUpperCase();
    }
}
