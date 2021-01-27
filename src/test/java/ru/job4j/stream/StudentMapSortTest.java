package ru.job4j.stream;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class StudentMapSortTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(3, "Ivan Fedorov"));
        students.add(new Student(2, "Ivan Fedorov"));
        students.add(new Student(1, "Petr Ivanov"));
        students.add(new Student(3, "Ivan Vasilevsky"));

    }

    @Test
    public void sort() {
        StudentMapSort stdnMS = new StudentMapSort();
        Map<String, Student> rsl = StudentMapSort.sort(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivan Fedorov", new Student(3, "Ivan Fedorov"));
        expected.put("Petr Ivanov", new Student(1, "Petr Ivanov"));
        expected.put("Ivan Vasilevsky", new Student(3, "Ivan Vasilevsky"));
        assertThat(rsl, is(expected));


    }
}