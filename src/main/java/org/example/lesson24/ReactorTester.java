package org.example.lesson24;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.Callable;

public class ReactorTester {
    public static void main(String[] args) {
        //Mono- источник данных
        //выдать 1 элемент и закрыться
        //либо выдать ошибку и закрыться
        //либо просто закрыься
        Mono<Integer> integerMono = Mono.just(1);

        // Flux - источник 0 до бескончености элементов
        // может выдать от 0 до N элементов и закрыться
        // может выдать от 0 до N элементов и выдать ошибку
        // может закрыться
        Flux<String> stringFlux = Flux.just("Hello", "world", "how", "are", "you");

        //ничего не запускается пока мы не подписались subscribe()

        integerMono
                .map(i -> 10 * i)
                .filter(i -> i > 5)
                .subscribe(i -> System.out.println("element " + i + " received"),
                        null,
                        () -> System.out.println("stream closed")
                )
        ;

        stringFlux
                .map(i -> i.length()*3)
                .subscribe(integer -> System.out.println(integer));

       // Mono.empty();
       //Flux.fromIterable(List)



        Mono<String> timeMono = Mono.fromCallable(() -> getTime());
        timeMono.subscribe(
                time -> System.out.println("time is: " + time)
        );

        //distinct
        //skip

        Flux.just(1,1,1,5,5,7,8,2,2,2,2,1)
                .distinctUntilChanged() // выдает изменяющиеся элементы
                .subscribe(
                        i -> System.out.println("i is: " + i)
                );
        //reduce
        //collect
        //all - все элементы Flux удовлетворяют критерию

        Flux.just(1,1,1,5,5,7,8,2,2,2,2,1)
                .all(i -> i>0)
                .subscribe(
                        r -> System.out.println("result: " + r)
                );

        //any
        //none
        //count
        Flux.just(1,1,1,5,5,7,8,2,2,2,2,1)
                .count()
                .subscribe(
                        r -> System.out.println("count: " + r)
                );



    }



    public static String getTime(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "" + System.currentTimeMillis();
    }

}
