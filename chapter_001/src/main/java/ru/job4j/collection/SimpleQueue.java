package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int countIn = 0;
    int countOut = 0;

    public T poll() {
        if (countOut == 0) {
            while (countIn != 0) {
                out.push(in.pop());
                countIn--;
                countOut++;
            }
        }
        countOut--;
        return out.pop();
    }

    public void push(T value) {
            in.push(value);
            countIn++;
    }

    @Override
    public String toString() {
        return "SimpleQueue{"
                + "in=" + in
                + ", out=" + out
                + ", count=" + countIn
                + ", index=" + countOut + '}';
    }
}
