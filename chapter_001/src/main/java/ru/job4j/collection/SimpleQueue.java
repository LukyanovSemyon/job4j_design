package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int count = 0;

    public T poll() {
        int index = 0;
        while (index != count) {
            out.push(in.pop());
            index++;
        }
        T element = out.pop();
        index--;
        while (index != 0) {
            in.push(out.pop());
            index--;
        }
        count--;
        return element;
    }

    public void push(T value) {
        in.push(value);
        count++;
    }
}
