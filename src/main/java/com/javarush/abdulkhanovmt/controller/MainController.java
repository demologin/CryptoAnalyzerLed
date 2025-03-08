package com.javarush.abdulkhanovmt.controller;


import com.javarush.abdulkhanovmt.exception.CipherException;
import com.javarush.abdulkhanovmt.functionality.BruteForce;
import com.javarush.abdulkhanovmt.functionality.Cipher;
import com.javarush.abdulkhanovmt.functionality.Const;

import java.util.Scanner;

public class MainController {

    private String sourceFilePath;
    private String encryptedFilePath;
    private String decryptedFilePath;
    private String bruteforcedFilePath;
    private String analyzedFilePath;
    private boolean isEnd = false;
    private int key = -1;

    public MainController(String sourceFilePath,
                          String encryptedFilePath,
                          String decryptedFilePath,
                          String bruteforcedFilePath,
                          String analyzedFilePath) {
        this.sourceFilePath = sourceFilePath;
        this.encryptedFilePath = encryptedFilePath;
        this.decryptedFilePath = decryptedFilePath;
        this.bruteforcedFilePath = bruteforcedFilePath;
        this.analyzedFilePath = analyzedFilePath;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        greetings();
        this.key = enterKeyValue(input);
        executeCommand(input, this.key);
    }

    private void executeCommand(Scanner input, int key) {

        while (!this.isEnd) {
            System.out.println("Введите номер команды");
            String command = input.next();
            System.out.println(command);
            if (command.equalsIgnoreCase("end") || command.equalsIgnoreCase("exit")) {
                System.out.printf(Const.APPLICATION_CLOSED);
                return;
            }
            switch (command) {
                case "1" -> Cipher.encrypt(this.sourceFilePath, this.encryptedFilePath, this.key);
                case "2" -> Cipher.decrypt(this.encryptedFilePath, this.decryptedFilePath, this.key);
                case "3" -> BruteForce.decodeByBruteForce(this.encryptedFilePath, this.bruteforcedFilePath);
                default -> System.out.printf(Const.NOT_FOUND_ACTION_FORMAT, "the command doesn't exist\n");
            }
            nextMove(input);
        }
    }

    private void nextMove(Scanner input) {
        System.out.println("Выберите следующее действие");
        detach();
        System.out.println("""
                \"1\" - ввести команду 
                \"2\" - поменять ключ шифрования
                \"3\" - закончить работу 
                """);
        while (!this.isEnd) {
            String command = input.next();
            System.out.println(command);
            if (command.equalsIgnoreCase("end") || command.equalsIgnoreCase("exit")) {
                System.out.printf(Const.APPLICATION_CLOSED);
                this.isEnd = true;
            }
            switch (command) {
                case "1" -> {
                    executeCommand(input, this.key);
                    return;
                }
                case "2" -> {
                    enterKeyValue(input);
                    return;
                }
                case "3" -> this.isEnd = true;
                default -> System.out.printf(Const.NOT_FOUND_ACTION_FORMAT, "the command doesn't exist\n");
            }
        }
    }

    private static int enterKeyValue(Scanner input) {
        System.out.println("Введите целочисленный ключ шифрования");
        String keyTxt = input.next();
        System.out.println(keyTxt);
        return Integer.parseInt(keyTxt);
    }

    private void greetings() {
        detach();
        System.out.println("Криптоанализатор v0.1");
        detach();
        System.out.println("Список команд:");
        System.out.println("""
                \"1\" - encrypt 
                \"2\" - decrypt 
                \"3\" - bruteforce 
                \"4\" - analyze 
                """);
        detach();
    }

    private void detach() {
        System.out.println("=".repeat(50));
    }
}
