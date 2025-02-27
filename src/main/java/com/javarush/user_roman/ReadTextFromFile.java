package com.javarush.user_roman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadTextFromFile {
    public static void readTextFromFile() {
        Path path = Path.of("src\\main\\java\\com\\javarush\\user_roman\\test.txt");
        if (Files.exists(path)) {
            List<String> strings = null;
            try {
                strings = Files.readAllLines(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (String i : strings) {
                System.out.println(i);
            }
        } else {
            System.out.println("Не найден файл");
        }
    }
}