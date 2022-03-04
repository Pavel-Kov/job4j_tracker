package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 1),
                new Job("B", 0),
                new Job("C", 2)
        );
        List<Job> expected = List.of(
                new Job("B", 0),
                new Job("A", 1),
                new Job("C", 2)

        );
        Collections.sort(jobs, new JobAscByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 1),
                new Job("B", 0),
                new Job("C", 2)
        );
        List<Job> expected = List.of(
                new Job("C", 2),
                new Job("A", 1),
                new Job("B", 0)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("B", 0),
                new Job("C", 2),
                new Job("A", 1)
        );
        List<Job> expected = List.of(
                new Job("A", 1),
                new Job("B", 0),
                new Job("C", 2)
        );
        Collections.sort(jobs, new JobAscByName());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("B", 0),
                new Job("C", 2),
                new Job("A", 1)
        );
        List<Job> expected = List.of(
                new Job("C", 2),
                new Job("B", 0),
                new Job("A", 1)
        );
        Collections.sort(jobs, new JobDescByName());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortAscByNameThenDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 1),
                new Job("B", 4),
                new Job("A", 2)
        );
        List<Job> expected = List.of(
                new Job("A", 2),
                new Job("A", 1),
                new Job("B", 4)
        );
        Comparator<Job> comb = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        Collections.sort(jobs, comb);
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortDescByNameThenAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 1),
                new Job("B", 4),
                new Job("A", 2)
        );
        List<Job> expected = List.of(
                new Job("B", 4),
                new Job("A", 1),
                new Job("A", 2)
        );
        Comparator<Job> comb = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        Collections.sort(jobs, comb);
        assertEquals(expected, jobs);
    }
}