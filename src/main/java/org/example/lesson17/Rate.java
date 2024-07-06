package org.example.lesson17;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rate {
    private double amount;
    private String base;
    private String date;
    private Map<String, Double> rates = new HashMap<>();

}
