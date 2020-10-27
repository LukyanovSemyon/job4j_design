package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {
    private final SimpleArray<T> arr;

    public SimpleArrayIterator(SimpleArray<T> arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return arr.value < arr.count;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arr.get(arr.value++);
    }
}
