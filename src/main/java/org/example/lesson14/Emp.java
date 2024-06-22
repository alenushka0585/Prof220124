package org.example.lesson14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter// Lombok генирирует геттер
@AllArgsConstructor
public class Emp {
    private String name;
    private int age;
    private String position;

    @Override
    public String toString() {
        return "{ n="+name+", a="+age+" ,p=" + position + "}";
    }
}
