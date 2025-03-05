package com.javarush.yatsevich;

import java.util.Scanner;

import static com.javarush.yatsevich.EncryptDecryptClass.*;
import static com.javarush.yatsevich.KeyValidation.keyValidation;

public class Actions {

    public static void start() {
            try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                String operation = scanner.nextLine();
                if (!(operation.matches("\\d+")) || (Integer.parseInt(operation) > 4)) {
                    throw new IllegalArgumentException("Choose correct option (1-4)");
                }
                switch (operation) {
                    case "1":
                        encrDecrOperation(scanner, Operation.ENCRYPT);
                        System.out.println("Encrypt operation finished");
                        break;
                    case "2":
                        encrDecrOperation(scanner, Operation.DECRYPT);
                        System.out.println("Decrypt operation finished");
                        break;
                    case "3":
                        keyReturn(scanner);
                        break;
                    case "4":
                        break label;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument. " + e.getMessage());
        }
    }

    public static void printMenu() {
        System.out.println("Chose option");
        System.out.println("1. encrypt");
        System.out.println("2. decrypt");
        System.out.println("3. brut");
        System.out.println("4. exit");
    }

    public static void encrDecrOperation(Scanner scanner, Operation operation) {
        int key;
        FileProcessor fileProcessor = new FileProcessor();
        System.out.println("Please enter file to read: ");
        String pathToRead = scanner.nextLine();
        fileProcessor.readFile(pathToRead);
        key = keyValidation(scanner);
        char[] text;
        if (operation == Operation.ENCRYPT) {
            text = encrypt(fileProcessor.readFile(pathToRead), key);
        } else if (operation == Operation.DECRYPT) {
            text = decrypt(fileProcessor.readFile(pathToRead), key);
        } else {
            text = new char[0];
        }
        System.out.println("Please enter file to write: ");
        String pathToWrite = scanner.nextLine();
        fileProcessor.writeFile(text, pathToWrite);
    }

    public static void keyReturn(Scanner scanner) {
        FileProcessor fileProcessor = new FileProcessor();
        System.out.println("Please enter encrypted file: ");
        String encryptedFile = scanner.nextLine();
        char[] encrypted = fileProcessor.readFile(encryptedFile);
        System.out.println("Please enter original file: ");
        String originalFile = scanner.nextLine();
        char[] original = fileProcessor.readFile(originalFile);
        int finalKey = findKey(encrypted, original);
        System.out.println("Key found: " + finalKey);
    }


}
