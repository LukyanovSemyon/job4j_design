package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkListIterator<E> implements Iterator<E> {
    private final LinkList<E> list;
    private int index;
    private final int expectedModCount;

    public LinkListIterator(LinkList<E> list) {
        this.list = list;
        this.expectedModCount = list.getModCount();
    }

    @Override
    public boolean hasNext() {
        if (expectedModCount != list.getModCount()) {
            throw new ConcurrentModificationException();
        }
        return index < list.getSize();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.get(index++);
    }
}
