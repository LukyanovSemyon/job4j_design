package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : source) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./pom.zip")
        );
        ArgZip argZip = new ArgZip(args);
        List<Path> source;
        if (!argZip.valid()) {
            System.out.println("Неверное количество параметров");
        } else {
            source = Files.walk(Paths.get(argZip.directory()))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            List<Path> exclude = Search.search(Paths.get(argZip.directory()), argZip.exclude());
            source.removeAll(exclude);
            new Zip().packFiles(source, new File(argZip.output()));
        }
    }
}
