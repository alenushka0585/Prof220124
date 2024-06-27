package org.example.lesson14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter// Lombok генирирует геттер
@AllArgsConstructor
public class Emp implements Serializable {
    private String name;
    private int age;
    private String position;

    @Override
    public String toString() {
        return "{ n="+name+", a="+age+" ,p=" + position + "}";
    }
}
