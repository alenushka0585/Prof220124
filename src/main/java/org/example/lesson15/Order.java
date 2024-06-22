package org.example.lesson15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    public Order(OrderItem ... items){
        this.items.addAll(Arrays.asList(items));
    }

}
