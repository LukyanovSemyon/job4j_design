package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int count = 0;
    private int value = 0;

    public SimpleArray(Object[] array) {
        this.array = array;
    }

    public void add(T model) {
        array[count] = model;
        count++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>(this);
    }

    public int getCount() {
        return count;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
