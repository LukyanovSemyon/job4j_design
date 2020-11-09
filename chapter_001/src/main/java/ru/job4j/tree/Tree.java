package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> el = findBy(parent);
        if (findBy(child).isPresent()) {
            return false;
        }
        if (el.isPresent()) {
            el.get().children.add(new Node<>(child));
        }
        return true;
    }

    public boolean isBinary() {
        Predicate<Node<E>> predicate = el -> el.children.size() > 2;
        return check(predicate).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> predicate = el -> el.value.equals(value);
        return check(predicate);
    }

    public Optional<Node<E>> check(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
