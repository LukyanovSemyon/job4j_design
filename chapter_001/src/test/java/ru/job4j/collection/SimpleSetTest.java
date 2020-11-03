package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("first");
        array.add("second");
        Iterator<String> it = array.iterator();
        it.next();
        assertThat(it.next(), is("second"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<String> array = new SimpleSet<>();
        Iterator<String> it = array.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }

}