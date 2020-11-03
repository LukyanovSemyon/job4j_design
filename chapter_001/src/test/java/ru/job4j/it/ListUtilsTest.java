package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, -3, 7, -8, 9));
        ListUtils.removeIf(input, x -> x < 0);
        assertThat(Arrays.asList(1, 7, 9), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 7, 3, 8, 9));
        ListUtils.replaceIf(input, x -> x % 2 != 0, 0);
        assertThat(Arrays.asList(0, 0, 0, 0, 8, 0), Is.is(input));
    }

    @Test
    public void whenReplaceIAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 7, 3, 8, 9, 1));
        List<Integer> check = new ArrayList<>(Arrays.asList(9, 7));
        ListUtils.removeAll(input, check);
        assertThat(Arrays.asList(1, 3, 3, 8, 1), Is.is(input));
    }
}