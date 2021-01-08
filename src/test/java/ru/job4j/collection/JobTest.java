package ru.job4j.collection;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenByName() {
      Comparator<Job> job =  new SortByNameJob();
        int rsl = job.compare(new Job("Fix bug", 1), new Job("Impl task", 2));
        assertThat(rsl, lessThan(1));
    }
    @Test
    public void whenDescByName() {
        Comparator<Job> job = new JobDescByName();
        int rsl = job.compare(new Job("Fix bug", 1), new Job("Impl task", 2));
        assertThat(rsl, is(3));

    }
    @Test
    public void whenDescByNameln() {
        Comparator<Job> job = new JobDescByNameLn();
        int rsl = job.compare(new Job("Fix bug", 1), new Job("Impl task", 2));
        assertThat(rsl, lessThan(2));
    }
    @Test
    public void whenDescPriority() {
        Comparator<Job> job = new JobDescByPriority();
        int rsl = job.compare(new Job("Fix bug", 1), new Job("Impl task", 2));
        assertThat(rsl, lessThan(2));
    }
    @Test
    public void whenDescByPriority() {
        Comparator<Job> job = new JobDescByPriority();
        int rsl = job.compare(new Job("Fix bug", 1), new Job("Impl task", 2));
        assertThat(rsl, lessThan(2));
    }

}