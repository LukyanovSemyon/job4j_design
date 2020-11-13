package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(
                 new FileReader(source));
            PrintWriter out = new PrintWriter(
                 new BufferedOutputStream(
                     new FileOutputStream(target)))) {
            List<String[]> list = read.lines()
                 .map(line -> line.split(" "))
                 .collect(Collectors.toList());
            int i = 0;
            for (String[] line : list) {
                if (i % 2 == 0 && (line[0].contains("400") || line[0].contains("500"))) {
                    out.write(line[1] + ";");
                    i++;
                } else if (i % 2 != 0 && (line[0].contains("200") || line[0].contains("300"))) {
                    out.write(line[1] + System.lineSeparator());
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy h = new Analizy();
        h.unavailable("./chapter_002/data/source.txt", "./chapter_002/data/target.csv");
    }
}
