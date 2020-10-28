package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {
    private final SimpleArray<T> arr;
    private int index;

    public SimpleArrayIterator(SimpleArray<T> arr) {
        this.arr = arr;
        index = arr.getValue();
    }

    @Override
    public boolean hasNext() {
        return arr.getValue() < arr.getCount();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T el = arr.get(index++);
        arr.setValue(index);
        return el;
    }
}
