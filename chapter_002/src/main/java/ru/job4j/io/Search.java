package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length <= 1) {
            throw new IllegalArgumentException(((args.length == 0) ? "Root folder is null." : "Sought file extension is null.")
                    + " Usage java -jar search.jar");
        }
            Path start = Paths.get(args[0]);
            String str = args[1];
            search(start, str).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toString().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}