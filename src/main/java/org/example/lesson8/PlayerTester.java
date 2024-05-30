package org.example.lesson8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlayerTester {
    public static void main(String[] args) {
        Set<Player> players = new HashSet<>(
                Arrays.asList(new Player("11", "Mike"),
                new Player("12", "Mike"),
                new Player("11", "Galina"))
        );

        System.out.println("players size: " + players.size());
        System.out.println("players: " + players);

        players.add(new Player("33", "Alexander"));

        for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();){
            if(iterator.next().getName().contains("i")){
                iterator.remove();
            }
        }

        System.out.println(players);
    }
}
