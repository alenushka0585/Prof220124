package org.example.lesson17;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor // обязательно для Gson
public class Car {
    private String maker;
    private String model;
    private double price;
}
