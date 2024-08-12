package org.example.lesson25.currency;

import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Query;

// GET https://api.frankfurter.app
// /latest
// ?amount=10
// &from=GBP
// &to=USD
public interface CurrencyService {
    @GET("/latest")
    Mono<Convert> convert(
            @Query("amount") double amount,
            @Query("from") String from,
            @Query("to") String to
    );
}

