package ru.job4j.find;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.List;

public class Find {
    public static void main(String[] args) throws IOException {
        Arg arg = new Arg(args);
        if (arg.valid()) {
            save(search(Paths.get(arg.directory()), arg.exclude(), arg.howToSearch()), arg.output());
        }
    }

    public static void save(List<Path> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (Path line : log) {
                out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, String ext, String howToSearch) throws IOException {
        FindFiles searcher = Searcher.searcher(ext, howToSearch);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
