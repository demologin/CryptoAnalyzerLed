package com.javarush.user_roman;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class WriteTextToFile {
    public static void writeTextToFile(Path path) {
        /*String file1 = "src\\main\\java\\com\\javarush\\user_roman\\readme.txt";
                Path path = Path.of(file1);
                try {
                    Files.createFile(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Напишите текст для записи");
        String textConsole = sc.nextLine();
        try {
            Files.write(path, textConsole.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Строка успешно записана в файл. " + FinalConstant.getKaomojiFileWrite());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}