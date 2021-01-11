package ru.job4j.find;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

public class Searcher {
    private static FindFiles searcher;

    public static FindFiles searcher(String ext, String howToSearch) {
        if (howToSearch.equals("-m")) {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**" + ext);
            searcher = new FindFiles(pathMatcher::matches);
        } else if (howToSearch.equals("-f")) {
            searcher = new FindFiles(p -> p.getFileName().toString().equals(ext));
        }
        return searcher;
    }
}
