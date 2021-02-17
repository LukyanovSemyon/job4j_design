package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;

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
        String text = cash.getCash(nameFile);
        if (text.equals(" ")) {
            SoftReference<String> softRef = new SoftReference<>(readFile(nameFile));
            cash.setCash(nameFile, softRef);
            printFile(nameFile);
        } else {
                System.out.println(text);
        }
    }

    public String readFile(String nameFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader("./chapter_004/textFiles/" + nameFile))) {
            in.lines().forEach(stringBuilder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
