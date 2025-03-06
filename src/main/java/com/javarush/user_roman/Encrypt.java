package com.javarush.user_roman;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Encrypt {
    static String alphabet = FinalConstant.getAlphabetRus(); // Алфавит
    static Path inputFilePath = FinalConstant.getText();  // Путь к входному файлу text
    static Path outputFilePath = FinalConstant.getEncrypt(); // Путь к выходному зашифрованному файлу encrypt
    static Path decryptedFilePath = FinalConstant.getDecryptPath(); // Путь к выходному расшифрованному файлу decrypt
    static List<String> encryptedLines = new ArrayList<>(); // Зашифрованная строка

    // Метод для шифрования текста с помощью шифра Цезаря
    private static String encrypt(String text, String alphabet, int shift) {
        StringBuilder encrypted = new StringBuilder();
        int alphabetLength = alphabet.length();

        for (char character : text.toCharArray()) {
            int index = alphabet.indexOf(character);
            if (index != -1) {
                // Если символ найден в алфавите, сдвигаем его
                int newIndex = (index + shift) % alphabetLength;
                encrypted.append(alphabet.charAt(newIndex));
            } else {
                // Если символ не найден в алфавите, добавляем его без изменений
                encrypted.append(character);
            }
        }
        return encrypted.toString();
    }

    // Метод для расшифровки текста
    private static String decrypt(String text, String alphabet, int shift) {
        return encrypt(text, alphabet, alphabet.length() - shift);
    }

    public static void encryptStart(int shift) {
        try {
            // Чтение всех строк из входного файла
            List<String> lines = Files.readAllLines(inputFilePath, StandardCharsets.UTF_8);

            // Шифрование каждой строки
            for (String line : lines) {
                encryptedLines.add(encrypt(line, alphabet, shift));
            }
            // Запись зашифрованных строк в выходной файл
            WriteTextToFile.writeTextToFile(outputFilePath, encryptedLines);

        } catch (IOException e) {
            System.err.println("Не найден файл. Ошибка при чтении файла: " + FinalConstant.getKaomojiError() + e.getMessage());
        }
    }

    public static void decryptStart(int shift) {
        // Расшифровка каждой строки
        List<String> decryptedLines = new ArrayList<>();
        for (String line : encryptedLines) {
            decryptedLines.add(decrypt(line, alphabet, shift));
        }
        // Запись расшифрованных строк в новый файл
        WriteTextToFile.writeTextToFile(decryptedFilePath, decryptedLines);
    }
}