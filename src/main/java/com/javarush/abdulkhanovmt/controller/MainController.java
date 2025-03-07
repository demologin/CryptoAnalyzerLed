package com.javarush.abdulkhanovmt.controller;


import com.javarush.abdulkhanovmt.functionality.Cipher;

import java.util.Scanner;

public class MainController {

    private String sourceFilePath;
    private String encryptedFilePath;
    private String decryptedFilePath;
    private String bruteforcedFilePath;
    private String analyzedFilePath;

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
        int key = enterKeyValue(input);
        executeCommand(input, key);
    }

    private void executeCommand(Scanner input, int key) {

//        boolean isEnd = command.equalsIgnoreCase("End") || (command.equalsIgnoreCase("Exit"));
        while (true) {
            System.out.println("Введите номер команды");
            String command = input.next();
//            String command = "2";
            System.out.println(command);
            if (command.equalsIgnoreCase("end") || command.equalsIgnoreCase("exit")) {
                break;
            }
            switch (command) {
                case "1": {
                    Cipher.encrypt(this.sourceFilePath, this.encryptedFilePath, key);
                    break;
                }
                case "2": {
                    Cipher.decrypt(this.encryptedFilePath, this.decryptedFilePath, key);
                    break;
                }
            }
            return;
        }
    }

    private static int enterKeyValue(Scanner input) {
        int key = 0;
        System.out.println("Введите целочисленный ключ шифрования");
        String keyTxt = input.next();
//        String keyTxt = "1";
        System.out.println(keyTxt);
        return key = Integer.parseInt(keyTxt);
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
