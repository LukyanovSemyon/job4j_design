package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        return args.length >= 3;
    }

    public String directory() {
        String dir = ArgsName.of(args).get("d");
        if (dir == null) {
            System.out.println("Не указана директория, параметр -d");
        }
        return dir;
    }

    public String exclude() {
        String exclude = ArgsName.of(args).get("e");
        if (exclude == null) {
            System.out.println("Не указано расширение исключаемых файлов, параметр -e");
        }
        return exclude;
    }

    public String output() {
        String output = ArgsName.of(args).get("o");
        if (output == null) {
            System.out.println("Не указано имя архива, параметр -o");
        }
        return output;
    }
}