package com.javarush.pyatigin.exception;

import com.javarush.pyatigin.ALPHABET;

import java.util.Scanner;

public class KeyPrompter {
    public int promptKey(String message, Scanner scanner) {
        System.out.println(message);
        int key;
        while (true) {
            key = scanner.nextInt();
            if (key >= ALPHABET.getALPHABETLength()) {
                System.out.println("Key is out of range");
            } else {
                break;
            }
        }
        return key;
    }
}
