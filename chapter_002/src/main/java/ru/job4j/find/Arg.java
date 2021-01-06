package ru.job4j.find;

import java.util.HashMap;
import java.util.Map;

public class Arg {
    private final String[] args;
    private final Map<String, String> value = new HashMap<>();

    public Arg(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 7) {
            throw new IllegalArgumentException("Arguments aren't input\n -d directory, -n nameFile "
                    + "-m(or -f search by mask or by full name) -o nameResultFile");
        }
        value.put(args[0], args[1]);
        value.put(args[2], args[3]);
        value.put("howToSearch", args[4]);
        value.put(args[5], args[6]);
        return true;
    }

    public String directory() {
        return value.get("-d");
    }

    public String exclude() {
        return value.get("-n");
    }

    public String output() {
        return value.get("-o");
    }

    public String howToSearch() {
        return value.get("howToSearch");
    }
}