package ru.job4j.io;

public class ArgZip {

    private final String[] args;
    private ArgsName value = new ArgsName();

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        value = ArgsName.of(args);
        if (value.get("d") == null || value.get("e") == null || value.get("o") == null) {
            throw new IllegalArgumentException("Не введены данные");
        }
        return true;
    }

    public String directory() {
        return value.get("d");
    }

    public String exclude() {
        return value.get("e");
    }

    public String output() {
        return value.get("o");
    }
}