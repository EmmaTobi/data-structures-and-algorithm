package com.emmatblingx.algorithms;

import java.time.LocalTime;
import java.util.*;

public class GreedyAlgorithm {

    class Subject implements Comparable<Subject>{
        String name;
        LocalTime start;
        LocalTime end;

        public Subject(String name, LocalTime start, LocalTime end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Subject o) {
            if (this.start.isBefore(o.start)) {
                return -1;
            } else if (this.start.equals(o.start) ) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    List<Subject> subjects = new ArrayList<>();

    {
        subjects.add( (new Subject("Music", LocalTime.of(11, 0), LocalTime.of(12, 0))));
        subjects.add( (new Subject("Art", LocalTime.of(9, 0), LocalTime.of(10, 0))));
        subjects.add( (new Subject("Eng", LocalTime.of(9, 30), LocalTime.of(10, 30))));
        subjects.add( (new Subject("Math", LocalTime.of(10, 0), LocalTime.of(11, 0))));
        subjects.add( (new Subject("CS", LocalTime.of(10, 30), LocalTime.of(11, 30))));
    }

    List<Subject> scheduleClass() {
        subjects.sort(Comparator.naturalOrder());

        List<Subject> results = new ArrayList<>();

        results.add(subjects.stream().findFirst().get());

        for(Subject result : subjects ) {
            if (
                    results.get(results.size() - 1).end.isBefore(result.start) ||
                    results.get(results.size() - 1).end.equals(result.start)
            ) {
                results.add(result);
            }
        }

        return results;
    }
}
