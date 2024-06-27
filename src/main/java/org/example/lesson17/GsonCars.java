package org.example.lesson17;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonCars {
    public static void main(String[] args) {
        Gson gson = new Gson();

        try (FileReader fr = new FileReader("cars.json.txt")) {
            Type carListType = new TypeToken<ArrayList<Car>>() {
            }.getType(); // необходимо указать тип коллекции для json

            List<Car> cars = gson.fromJson(fr, carListType);
            System.out.println(cars);
            System.out.println(
                    cars.stream()
                            .mapToDouble(car -> car.getPrice())
                            .sum()
            );


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
