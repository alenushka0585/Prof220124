package org.example.lesson15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderItem {
    private String title;
    private int quantity;
    private double unitPrice;
}
