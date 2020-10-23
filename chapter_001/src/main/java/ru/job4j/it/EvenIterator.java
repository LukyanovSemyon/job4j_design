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
        while (cell < numbers.length - 1 && numbers[cell] % 2 != 0) {
            cell++;
        }
        return cell < numbers.length && numbers[cell] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[cell++];
    }
}
