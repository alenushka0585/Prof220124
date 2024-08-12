package org.example.lesson25.currency;

import lombok.*;

import java.util.HashMap;
@AllArgsConstructor
@NoArgsConstructor //обязателен для retrofit
@Getter
@Setter
@ToString
public class Convert {
//    {
//        "amount": 10.0,
//            "base": "GBP",
//            "date": "2024-08-08",
//            "rates": {
//        "USD": 12.6956
//    }
//    }
    private Double amount;
    private String base;
    private String date;
    private HashMap<String, Double> rates;

}
