package org.example.lesson25;

import reactor.core.publisher.Flux;
import reactor.util.context.Context;

import java.util.stream.Collectors;

public class ReactiveContext {
    public static void main(String[] args) {
        Flux<String> names = Flux.just("Max", "Alex", "Masha", "Olesya")
                // .map(n-> n.toUpperCase())
                .transformDeferredContextual(
                        (flux, ctx) -> flux.map(
                                n -> n.toUpperCase() + "|" + ctx.getOrDefault("SUFFIX", ""))
                );

        names
                .contextWrite(Context.of("SUFFIX", "!!!!")) // парраметр SUFFIX, значение "!!!!"
                .subscribe(
                        name -> System.out.println("name: " + name)
                );

        names
                .collect(Collectors.toList())
                .subscribe(
                        l -> System.out.println("list: " + l)
                );
    }
}
