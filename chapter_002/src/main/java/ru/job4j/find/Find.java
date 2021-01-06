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
                out.write(line + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, String ext, String howToSearch) throws IOException {
        FindFiles searcher = null;
        if (howToSearch.equals("-m")) {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**" + ext);
            searcher = new FindFiles(pathMatcher::matches);
        } else if (howToSearch.equals("-f")) {
            searcher = new FindFiles(p -> p.getFileName().toString().equals(ext));
        }
        assert searcher != null;
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
