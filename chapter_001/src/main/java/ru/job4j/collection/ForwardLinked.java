package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> forward;
        while (current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        current = previous;
        head = current;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> first = head;
        head = head.next;
        return first.value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tail = head;
        Node<T> ccc = head;
        T e;
        if (tail.next == null) {
            head = null;
        }
        while (tail.next != null) {
            ccc = tail;
            tail = tail.next;
        }
        e = tail.value;
        ccc.next = null;
        return e;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        return "ForwardLinked{"
                + "head=" + head + '}';
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "value="
                    + value + ", next="
                    + next + '}';
        }
    }
}
