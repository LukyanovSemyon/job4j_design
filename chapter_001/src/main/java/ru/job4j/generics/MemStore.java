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
        int index = Integer.parseInt(id);
        if (index < mem.size() && index > 0) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = Integer.parseInt(id);
        if (index < mem.size() && index > 0) {
            mem.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int index = Integer.parseInt(id);
        T mod = null;
        if (index < mem.size() && index > 0) {
            mod = mem.get(index);
        }
        return mod;
    }
}
