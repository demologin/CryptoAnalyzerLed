package com.javarush.halubkova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileManager {
    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static void createFile(String path) throws IOException {
        Files.createFile(Path.of(path));
    }

    public static void writeFile(String content, String filePath) throws IOException {
        Path file = Path.of(filePath);
        Files.writeString(file, content);
    }


    //Чтение/запись по частям. Для очень больших файлов, которые не помещаются в оперативную память,
    // используйте методы Files.lines() для чтения по строкам или Files.newInputStream() для чтения по блокам.
    //Буферизация. ИспользуйBufferedReader и BufferedWriter для буферизации операций ввода/вывода,
    // что повышает производительность.


}
