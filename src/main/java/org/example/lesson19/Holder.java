package org.example.lesson19;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Holder<T> {
    private T value;
}
