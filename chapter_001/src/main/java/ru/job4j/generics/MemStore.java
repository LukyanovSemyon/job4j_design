package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndex(id);
        if (index != -1) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndex(id);
        if (index != -1) {
            mem.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int index = findIndex(id);
        T mod = null;
        if (index != -1) {
            mod = mem.remove(index);
        }
        return mod;
    }

    public int findIndex(String id) {
        int index = Integer.parseInt(id);
        if (index < mem.size() && index >= 0) {
            return index;
        } else {
            return -1;
        }
    }
}
