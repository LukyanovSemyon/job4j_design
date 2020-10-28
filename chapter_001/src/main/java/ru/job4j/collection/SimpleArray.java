package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int count = 0;
    private int value = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = new Object[10];
    }

    public void add(T model) {
        container[count] = model;
        count++;
        if (count == container.length) {
            container = Arrays.copyOf(container, container.length + 1);
        }
        modCount++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        container[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        count--;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
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

    public int getModCount() {
        return modCount;
    }
}
