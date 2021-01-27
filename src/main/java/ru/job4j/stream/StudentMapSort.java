package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMapSort {

    public static Map<String, Student> sort(List<Student> student) {
        return student
                .stream()
                .collect(Collectors
                        .toMap(Student::getSurname, s -> s, (a, b) -> a));
    }
}
