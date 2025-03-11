package com.javarush.halubkova.filemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileManager {
    public static Stream<String> readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.lines(path);
    }

    public static void createFile(String path) throws IOException {
        Files.createFile(Path.of(path));
    }

    public static void writeFile(String content, String filePath) throws IOException {
        Path file = Path.of(filePath);
        Files.writeString(file, content);
    }

}
