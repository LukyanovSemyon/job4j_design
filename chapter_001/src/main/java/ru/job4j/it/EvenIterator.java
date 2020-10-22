package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    final int[] numbers;
    private int cell = 0;

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        while (numbers[cell] % 2 != 0 && cell < numbers.length - 1) {
            cell++;
        }
        return numbers[cell] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int num = 0;
        if (numbers[cell] % 2 == 0) {
            num = numbers[cell];
        }
        cell++;
        return num;
    }
}
