package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> simpleArray = new SimpleArray<>();


    public void add(T model) {
        if (equal(model)) {
            simpleArray.add(model);
        }
    }

    public boolean equal(T model) {
        for (T t : simpleArray) {
            if (t.equals(model)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
