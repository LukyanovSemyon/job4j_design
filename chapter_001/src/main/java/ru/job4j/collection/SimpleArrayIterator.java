package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {
    private final SimpleArray<T> arr;
    private int index;
    private int expectedModCount;

    public SimpleArrayIterator(SimpleArray<T> arr) {
        this.arr = arr;
        index = arr.getValue();
        expectedModCount = arr.getModCount();
    }

    @Override
    public boolean hasNext() {
        if (expectedModCount != arr.getModCount()) {
            throw new ConcurrentModificationException();
        }
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
