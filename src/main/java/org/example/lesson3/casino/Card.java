package org.example.lesson3.casino;

public class Card {
    private Rank rank;
    private Suite suite;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public int getValue(){
        return rank.getValue();
    }

    @Override
    public String toString() {
        return "rank: " + rank +
                ", suite: " + suite;
    }
}
