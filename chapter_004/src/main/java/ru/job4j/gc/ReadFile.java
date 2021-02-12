package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {
    Cash cash = new Cash();

    public static void main(String[] args) {
        ReadFile r = new ReadFile();
        r.printFile("Names.txt");
        r.printFile("Names.txt");
        r.printFile("Address.txt");
        r.printFile("Address.txt");
        r.printFile("Names.txt");
        r.printFile("Names.txt");
    }

    private void printFile(String nameFile) {
        List<String> text = cash.getCash(nameFile).get();
        if (text.size() == 0) {
            SoftReference<List<String>> softRef = new SoftReference<>(readFile(nameFile));
            cash.setCash(nameFile, softRef);
            printFile(nameFile);
        } else {
            for (String str : text) {
                System.out.println(str);
            }
        }
    }

    public List<String> readFile(String nameFile) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("./chapter_004/textFiles/" + nameFile))) {
            list = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
