package com.javarush.user_roman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ReadTextFromFile {
    public static void readTextFromFile(Path path) {
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
            System.out.println("Не найден файл " + FinalConstant.getKaomojiNotFound());
        }
    }
}