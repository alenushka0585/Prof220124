package org.example.lesson25;

import reactor.core.publisher.Flux;

public class SideEffects {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4, 5)
//                .log() //МОЖНО ДЕБАГИТЬ, В РЕАЛЬНЫХ ПРОЭКТАХ НЕ ПРИМЕНИМ
                .map(integer -> integer * integer)
//                .log()
                .doOnNext(integer -> System.out.println("onNext: " + integer)) //sideEffect
                //.doOnError(...) /// как-то залогировать
                .subscribe(integer -> System.out.println(integer));
    }
}
