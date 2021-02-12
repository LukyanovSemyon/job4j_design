package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return sorter(value, comparator).get(0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return sorter(value, comparator).get(value.size() - 1);
    }

    public <T> List<T> sorter(List<T> value, Comparator<T> comparator) {
        for (int j = 0; j < value.size() - 1; j++) {
            for (int i = 0; i < value.size() - 1; i++) {
                if (comparator.compare(value.get(i), value.get(i + 1)) > 0) {
                    T t = value.get(i);
                    value.set(i, value.get(i + 1));
                    value.set(i + 1, t);
                }
            }
        }
        return value;
    }
}
