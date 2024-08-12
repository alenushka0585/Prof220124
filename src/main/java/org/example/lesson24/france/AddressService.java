package org.example.lesson24.france;

import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Query;

// GET
// https://api-adresse.data.gouv.fr
//  /search/
//      ?q=8+bd+du+port
//      &limit=3
public interface AddressService {
    @GET("/search")
    Mono<Result> search(@Query("q") String address, @Query("limit") int limit);
}
