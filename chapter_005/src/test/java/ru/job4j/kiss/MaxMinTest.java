package ru.job4j.kiss;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest extends TestCase {
        List<User> person = Arrays.asList(
                new User(21,"a"),
                new User(32, "s"),
                new User(12, "d"),
                new User(42, "f")
        );
        Comparator<User> comparator = (o1, o2) -> o2.getAge() - o1.getAge();
        MaxMin v = new MaxMin();

    public void testMax() {
        assertThat(v.max(person, comparator).getAge(),
                is(42)
        );
    }

    public void testMin() {
        assertThat(v.min(person, comparator).getAge(),
                is(12)
        );
    }
}