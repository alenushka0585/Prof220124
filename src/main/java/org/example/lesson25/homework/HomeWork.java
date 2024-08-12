package org.example.lesson25.homework;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import org.example.lesson25.currency.CurrencyService;
import reactor.core.publisher.Flux;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.stream.Collectors;

public class HomeWork {
    public static void main(String[] args) {
//        1. Создайте флюкс из нескольких имен - например, "Max", "Masha", "Alexander", "Olga"
//        Преобразуйте строки в их длину и соберите длины в список целых.
//        Распечатайте список, подписавшись на этот флюкс


        Flux<String> names = Flux.just("Max", "Masha", "Alexander", "Olga");
        names
                .map(n -> n.length())
                .collectList()
                .subscribe(l -> System.out.println("List of names' lengths: " + l));


//        2. Воспользуйтесь именами из предыдущего примера и
//        создайте флюкс и с помощью flatMap преобразуйте его в
//        "max", "MAX", "masha", "MASHA" …
//        То есть, для кажого имени нужно выдавать пару элементов в нижнем и в верхем регистре.
//        Соберите в Set, распечатайте Set

        names
                .flatMap(name -> Flux.just(name.toLowerCase(), name.toUpperCase()))
                .collect(Collectors.toSet())
                .subscribe(set -> System.out.println("Set of names: " + set));



//        3. Воспользуйтесь CurrencyService чтобы вызвать два перевода валюты друг за другом:
//        евро в фунты и получившуюся сумму фунтов в доллары
//        Выполните эту операцию для флюкса из 10,20,50,100,500 евро
//        Воспользуйтесь двумя последовательными flatMap
//        Результаты сохраните в список и его распечатайте

        Flux<Integer> sums = Flux.just(10,20,50,100,500);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.frankfurter.app")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                .build();
        CurrencyService service = retrofit.create(CurrencyService.class);


       sums
               .flatMap(euroSum -> service.convert(euroSum, "EUR", "GBP" ))
                      .flatMap(gbpSum -> service.convert(gbpSum.getRates().get("GBP"), "GBP", "USD" ))
                               .collectList()
                                       .subscribe(listOfUsd -> System.out.println("List of USD sums: " + listOfUsd));

       System.exit(0);
    }
}
