package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(a -> a.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(a -> new Tuple(a.getName(), a
                        .getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(a -> a.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(b -> new Tuple(b.getKey(), b.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(a -> new Tuple(a.getName(), a.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(a -> a.getSubjects().stream())
                .collect(Collectors.groupingBy(
                                Subject::getName,
                                Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(b -> new Tuple(b.getKey(), b.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
