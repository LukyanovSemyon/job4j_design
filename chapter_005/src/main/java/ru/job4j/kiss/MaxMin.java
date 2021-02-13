package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return sorter(value, comparator.reversed());
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return sorter(value, comparator);
    }

    public <T> T sorter(List<T> value, Comparator<T> comparator) {
        T u = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(value.get(i), u) > 0) {
                u = value.get(i);
                }
            }
        return u;
    }
}
