package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class LinkList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int value = 0;
    private int modCount = 0;

    public static class Node<E> {
        private final E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkList() {
        first = null;
    }

    public void add(E value) {
        final Node<E> node = last;
        final Node<E> newNode = new Node<>(node, value, null);
        last = newNode;
        if (node == null) {
            first = newNode;
        } else {
            node.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = first;
        int i = 0;
        while (i != index) {
            node = node.next;
            i++;
        }
        return  node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkListIterator<>(this);
    }

    public int getSize() {
        return size;
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
