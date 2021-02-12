package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.*;

public class Cash {
    Map<String, SoftReference<List<String>>> cash = new HashMap<>();

    public SoftReference<List<String>> getCash(String name) {
        if (cash.size() == 0 || cash.get(name) == null) {
            return new SoftReference<>(new ArrayList<>());
        }
        return cash.get(name);
    }

    public void setCash(String name, SoftReference<List<String>> softReference) {
        cash.put(name, softReference);
    }
}
