package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {
    private final SimpleArray<T> arr;
    private int index;

    public SimpleArrayIterator(SimpleArray<T> arr) {
        this.arr = arr;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < arr.getCount();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arr.get(index++);
    }
}
