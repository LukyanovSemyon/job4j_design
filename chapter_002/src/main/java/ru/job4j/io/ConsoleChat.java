package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static List<String> answers = new ArrayList<>();
    private static List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        log("Консольный чат, напишите сообщение");
        String userMessage = "";
        while (!userMessage.equals(OUT)) {
            userMessage = readData();
            switch (userMessage) {
                case STOP -> {
                    log("Чат остановлен, для продолжения напишите: продолжить");
                    while (!userMessage.equals(CONTINUE)) {
                        userMessage = readData();
                    }
                    log(answerBot());
                }
                case OUT -> log("Чат прекращен");
                default -> log(answerBot());
            }
        }
    }

    public String readData() {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            answers = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner ing = new Scanner(System.in);
        String userMessage = ing.nextLine();
        log.add(userMessage);
        return userMessage;
    }

    public void writeDataInFile() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true)
        )) {
            for (String line : log) {
                out.write(line + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(String str) {
        System.out.println(str);
        log.add(str);
    }

    public String answerBot() {
        return answers.get((int) (Math.random() * answers.size()));
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./chapter_002/data/ConsoleChatLog.txt", "./chapter_002/data/BotAnswers.txt");
        cc.run();
        cc.writeDataInFile();
    }
}
