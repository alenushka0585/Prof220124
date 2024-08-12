package org.example.lesson24.france;
//https://adresse.data.gouv.fr/api-doc/adresse

//https://www.jsonschema2pojo.org/
// ресурс для генерации классов

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//https://api-adresse.data.gouv.fr
// /search/                    http метод
// ?q=8+bd+du+port             параметр
// &limit=15                   параметр длины
public class FranceTest {
    public static void main(String[] args) {

        //настройка библиотеки ретрофит
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-adresse.data.gouv.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                .build();
        //создание экзэмпляра проаннотированного интерфейса
        AddressService service = retrofit.create(AddressService.class);

        String address = "20, rue de rivoli, paris";

        //Mono - либо 1 ответ, либо ошибка, либо окончание потока
        service.search(address, 3) //Mono<Result>
                .subscribe(
                        result -> System.out.println(
                                result.getFeatures().getFirst().getProperties().getLabel()));


        System.exit(0);
    }
}
