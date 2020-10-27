package ru.job4j.generics;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void add() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        array.add("first");
        array.add("second");
        String rsl = array.get(1);
        assertThat(rsl, is("second"));
    }

    @Test
    public void set() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        array.add("first");
        array.add("second");
        array.set(1, "third");
        String rsl = array.get(1);
        assertThat(rsl, is("third"));
    }

    @Test
    public void remove() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("fourth");
        array.remove(1);
        String rsl = array.get(2);
        assertThat(rsl, is("fourth"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkIndex() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("fourth");
        array.remove(1);
        array.get(3);
    }

    @Test
    public void next() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        array.add("first");
        array.add("second");
        array.add("third");
        assertThat(array.iterator().next(), is("first"));
        assertThat(array.iterator().next(), is("second"));
        assertThat(array.iterator().next(), is("third"));
    }

    @Test
    public void hasNextTrue() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        assertThat(array.iterator().hasNext(), is(false));
    }

    @Test
    public void hasNextFalse() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        array.add("first");
        assertThat(array.iterator().hasNext(), is(true));
        array.iterator().next();
        assertThat(array.iterator().hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException() {
        SimpleArray<String> array = new SimpleArray<>(new Object[10]);
        array.add("first");
        array.iterator().next();
        array.iterator().next();
    }
}