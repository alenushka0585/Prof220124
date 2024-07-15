package org.example.lesson19;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairImpl<K, V> pair = (PairImpl<K, V>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }


}
