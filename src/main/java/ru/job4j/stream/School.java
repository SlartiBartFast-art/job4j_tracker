package ru.job4j.stream;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.function.Predicate;

public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> students1 = students.stream().filter(predict)
                .collect(Collectors.toList());

        return students1;
    }

    Predicate<Student> predict = student -> student.getScore() > 50;
}
