package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> simpleArray = new SimpleArray<>();

    public boolean add(T model) {
        for (T t : simpleArray) {
            if (Objects.equals(t, model)) {
                return false;
            }
        }
        simpleArray.add(model);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleSet<?> simpleSet = (SimpleSet<?>) o;
        return Objects.equals(simpleArray, simpleSet.simpleArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simpleArray);
    }
}
