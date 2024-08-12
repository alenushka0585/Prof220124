package org.example.lesson24;

import reactor.core.publisher.Flux;

public class Errors {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1,2,0,3,-5);

        integerFlux
                .map(i -> 150/i)
                .onErrorContinue((error, i) -> System.out.println("e: " + error.getMessage() + " with element " + i))
                .subscribe(
                        i -> System.out.println("result is: " + i),
                        error -> System.out.println("error: " + error.getMessage()) // не выполняется из-за onErrorContinue
                );
    }
}
