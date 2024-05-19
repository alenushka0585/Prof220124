package org.example.lesson6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        Person p1 = new Person("Max Kotkov",
                28,
                new ArrayList<>(
                        List.of(
                                new Address("zelenay", "12"),
                                new Address("krasnaya", "33")
                        )
                ));

        Person p2 = new Person("Masha Semenova",
                28,
                new ArrayList<>(
                        List.of(
                                new Address("sinya", "44"))
                        )
                );

        List<Person> people = List.of(p1, p2);

        System.out.println(getAddresses(people));
    }

    public static List<Address> getAddresses (List<Person> persons){
        List<Address> result = new ArrayList<>();
       Iterator<Person> p = persons.iterator();
       while (p.hasNext()){
           result.addAll(p.next().getAddresses());
       }
        return result;
    }
}
