package com.javarush.user_roman;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

class WriteTextToFile {
    public static void writeTextToFile(Path path) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Напишите текст для записи");
        String textConsole = sc.nextLine();
        try {
            Files.write(path, textConsole.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println(FinalConstant.getKaomojiFileWrite() + "\nСтрока успешно записана в файл. " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTextToFile(Path outputFilePath, List<String> encryptedLines) {
        try {
            Files.write(outputFilePath, encryptedLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println(FinalConstant.getKaomojiFileWrite() + "\nРезультат записан в " + outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}