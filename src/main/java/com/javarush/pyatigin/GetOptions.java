package com.javarush.pyatigin;



import com.javarush.pyatigin.constatnt.ALPHABET;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.Files.isRegularFile;

public class GetOptions {
    private int option;
    private Path path;
    private int key;

    public int getOption() {
        return option;
    }

    public Path getPath() {
        return path;
    }

    public int getKey() {
        return key;
    }

    public GetOptions(int option) {
        this.option = option;
        Scanner scanner = new Scanner(System.in);
        this.path = promptFile(option == 1 ? "File to be encrypted" : "File to be decrypted", scanner);
        this.key = promptKey(option, scanner);
    }

    private Path promptFile(String message, Scanner scanner) {
        System.out.println(message);
        Path filePath;
        while (true) {
            filePath = Paths.get(scanner.nextLine());
            if (!isRegularFile(filePath)) {
                System.out.println("File not found. Please try again.");
            } else {
                break;
            }
        }
        return filePath;
    }

    private int promptKey(int option, Scanner scanner) {
        if (option == 1 || option == 2) {
            System.out.println(option == 1 ? "Encryption key" : "Decryption key");
            while (true) {
                try {
                    int keyTemp = Integer.parseInt(scanner.nextLine());
                    if(keyTemp >= ALPHABET.getALPHABETLength()) {
                        System.out.println("Long key. Please try again.");
                    } else {
                    return scanner.nextInt();}
                } catch (InputMismatchException e) {
                    System.out.println("Invalid key. Please enter a valid integer.");
                    scanner.next(); // Clear the invalid input
                }
            }
        } else {
            return 0; // Key is 0 for option 3
        }
    }
}