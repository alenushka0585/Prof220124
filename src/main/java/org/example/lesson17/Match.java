package org.example.lesson17;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Match {
    private Calendar date;
    private String team1, result,team2;
    private int watchers;
    private String stadium;
}
