package org.example.lesson25.currency;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyTester {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.frankfurter.app")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                .build();
        CurrencyService service = retrofit.create(CurrencyService.class);


        service.convert(250,"USD","EUR")
                .subscribe(result -> System.out.println(result));

        System.exit(0);
    }
}
