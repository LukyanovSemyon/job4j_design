package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.*;

public class Cash {
    Map<String, SoftReference<String>> cash = new HashMap<>();

    public String getCash(String name) {
        if (cash.size() == 0 || cash.get(name) == null) {
            return " ";
        }
        return cash.get(name).get();
    }

    public void setCash(String name, SoftReference<String> softReference) {
        cash.put(name, softReference);
    }
}
