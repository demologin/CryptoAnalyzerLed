package com.javarush.user_roman;

import java.util.Scanner;

public class Encrypt {
    public static String encrypt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сдвиг");
        int shift = sc.nextInt();
        StringBuilder result = new StringBuilder();
        // Проходим по каждому символу текста
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Шифруем заглавные буквы
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((ch + shift - 'A') % 26) + 'A');
                result.append(encryptedChar);
            }
            // Шифруем строчные буквы
            else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((ch + shift - 'a') % 26) + 'a');
                result.append(encryptedChar);
            } else {
                // Оставляем другие символы без изменений
                result.append(ch);
            }
        }
        return result.toString();
    }
}
