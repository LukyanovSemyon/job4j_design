package ru.job4j.tree;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void diff() {
        Analize analize = new Analize();
        List<Analize.User> previous = List.of(
                new Analize.User(1, "name"),
                new Analize.User(2, "name"),
                new Analize.User(3, "name"),
                new Analize.User(4, "name"),
                new Analize.User(5, "name"),
                new Analize.User(6, "name"),
                new Analize.User(7, "name"));
        List<Analize.User> current = List.of(
                new Analize.User(1, "newName"),
                new Analize.User(2, "name"),
                new Analize.User(3, "newName"),
                new Analize.User(4, "name"),
                new Analize.User(8, "name"),
                new Analize.User(9, "name"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(2));
        assertThat(info.deleted, is(3));
        assertThat(info.changed, is(2));
    }
}