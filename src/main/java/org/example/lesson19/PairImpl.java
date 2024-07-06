package org.example.lesson19;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@AllArgsConstructor
public class PairImpl<K,V> implements Pair<K,V> {
    private K first;
    private V second;
    @Override
    public K first() {
        return first;
    }

    @Override
    public V second() {
        return second;
    }
}
