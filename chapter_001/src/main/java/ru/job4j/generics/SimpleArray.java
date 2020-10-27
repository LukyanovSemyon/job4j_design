package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    Object[] array;
    int count = 0;
    int value = 0;

    public SimpleArray(Object[] array) {
        this.array = array;
    }

    public void add(T model) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                array[index] = model;
                count++;
                break;
            }
        }
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
}
