package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkListTest {

    @Test
    public void add() {
        LinkList<String> list = new LinkList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        String rsl = list.get(2);
        assertThat(rsl, is("3"));
    }

    @Test
    public void whenAddThenIt() {
        LinkList<String> list = new LinkList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        String rsl = list.iterator().next();
        assertThat(rsl, is("1"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        LinkList<String> list = new LinkList<>();
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        LinkList<String> list = new LinkList<>();
        list.add("first");
        list.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        LinkList<String> list = new LinkList<>();
        list.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        LinkList<String> list = new LinkList<>();
        list.add("first");
        Iterator<String> it = list.iterator();
        list.add("second");
        it.next();
    }
}