package org.example.lesson25;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

public class ReactorTester {
    public static void main(String[] args) {
        Flux<String> countries = Flux.from(
                new Publisher<String>() {
                    @Override
                    public void subscribe(Subscriber<? super String> subscriber) {
                        subscriber.onNext("France");
                        subscriber.onNext("Hungary");
                        subscriber.onNext("Poland");
                        subscriber.onError(new IllegalArgumentException("hello"));
                        subscriber.onNext("Estonia");
                        subscriber.onComplete(); // закрытие потока
                        subscriber.onNext("Australia"); // более не принимает данные
                        subscriber.onNext("India");
                    }
                }
        );

        countries
                .map(c -> c.toUpperCase())
                .subscribe(
                        c -> System.out.println("country: " + c),
                        error -> System.out.println(error.getMessage()))
        ;

        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4, 5, 6);

        //merge объеденитель 2-х последовательностей
        // элементы добвляются в порядке поступления
        Flux.merge(flux1, flux2)
                .collectList()
                .subscribe(
                        System.out::println
                )
        ;

        //concat добавляет сначала элементы первого Flux, потом второго и т.д.
        Flux.concat(flux1, flux2)
                .collectList()
                .subscribe(
                        System.out::println
                )
        ;

        Flux.zip(
                        flux1,
                        flux2,
                        (a, b) -> Tuples.of(a, b)
                )
                .subscribe(
                        t -> System.out.println(t),
                        e -> {
                        }
                )
        ;

        Flux.just("hello", "world")
                .flatMap(
                        (prefix) -> Mono
                                .fromCallable(() -> getTime(prefix))
                                .map(time -> Tuples.of(prefix, time))
                )
                .subscribe(t -> System.out.println("Tuples: " +t));


        //reduce - выдает конечный результат (действие над элементами)
        flux2.reduce(
                (a, b) -> a * b)
                .subscribe(s -> System.out.println("result" + s));

        //scan - выдает промежуточные результаты тоже + итог
        flux2.scan(
                        (a, b) -> a * b)
                .subscribe(s -> System.out.println("scan" + s));

        flux2.all(
                i -> i>3
        )
                .subscribe(
                        i -> System.out.println("all > 3: " + i)
                );
    }

    public static String getTime(String prefix) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return prefix + "|" + System.currentTimeMillis();
    }
}
