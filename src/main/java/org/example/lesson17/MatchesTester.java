package org.example.lesson17;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MatchesTester {
    public static void main(String[] args) {

        List<Match> matches = new ArrayList<>();
        try (Reader reader = new FileReader("matches.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);) {

//            String line = bufferedReader.readLine();
//            while (line != null) {
//                String[] m = line.split(", ");
//                Calendar calendar = new GregorianCalendar(
//                        Integer.parseInt(m[0]),
//                        Integer.parseInt(m[1]),
//                        Integer.parseInt(m[2]));
//                Match match = new Match(
//                        calendar, m[3],m[4],m[5],
//                        Integer.parseInt(m[6]),
//                        m[7]);
//                matches.add(match);
//                line=bufferedReader.readLine();

//            }

           matches = bufferedReader.lines()
                    .map(s -> s.split(", "))
                    .map(m -> new Match(new GregorianCalendar(
                            Integer.parseInt(m[0]),
                            Integer.parseInt(m[1]),
                            Integer.parseInt(m[2])),
                            m[3], m[4], m[5],
                            Integer.parseInt(m[6]),
                            m[7])
                    ).toList();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());

        }

        System.out.println(matches);
        System.out.println(
                matches.stream().mapToInt(match -> match.getWatchers())
                        .sum()
        );
    }
}
