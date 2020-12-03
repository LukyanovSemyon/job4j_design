package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "js").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        List<Path> list = new ArrayList<>();
        PrintFiles searcher = new PrintFiles() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(ext)) {
                    System.out.println(file.toRealPath());
                }
                return CONTINUE;
            }
        };
        list.add(Files.walkFileTree(root, searcher));
        return list;
    }
}
