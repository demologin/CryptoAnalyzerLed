package com.javarush.pyatigin.exception;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Files.isRegularFile;

public class FilePrompter {
    public Path promptFile(String message, Scanner scanner) {
        System.out.println(message);
        Path path;
        while (true) {
            path = Paths.get(scanner.nextLine());
            if (!isRegularFile(path)) {
                System.out.println("File not found. Please try again.");
            } else {
                break;
            }
        }
        return path;
    }
}