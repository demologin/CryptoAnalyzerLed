package com.javarush.yatsevich;

import java.util.Scanner;

public class KeyValidation {
    public static int keyValidation(Scanner scanner) {
        int number = 0;
        try {
            int min = 0, max = 100;
            System.out.println("Please, enter key from " + min + " to " + max);
            String key = scanner.nextLine();
            if (!key.matches("\\d+")) {
                throw new NumberFormatException("Incorrect symbol");
            }
            number = Integer.parseInt(key);

            if (number < min || number > max) {
                throw new IllegalArgumentException("Incorrect number. Please, enter key from " + min + " to " + max);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Attention: " + e.getMessage());
        }
        return number;
    }

}

