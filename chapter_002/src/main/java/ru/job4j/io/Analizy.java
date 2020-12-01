package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public static void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(
                 new FileReader(source))) {
            int i = 0;
            String line;
            String first = null;
            String second;
            while ((line = read.readLine()) != null) {
                if (i % 2 == 0 && (line.contains("400") || line.contains("500"))) {
                    first = line.split(" ")[1] + ";";
                    i++;
                } else if (i % 2 != 0 && (line.contains("200") || line.contains("300"))) {
                    second = line.split(" ")[1] + System.lineSeparator();
                    i++;
                    list.add(first + second);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (String str : list) {
                out.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unavailable("./chapter_002/data/source.txt", "./chapter_002/data/target.csv");
    }
}
